package com.lipskii.ski_jumping_system.service;

import com.lipskii.ski_jumping_system.dao.TeamResultRepository;
import com.lipskii.ski_jumping_system.db_data.FetchedTeamResultObject;
import com.lipskii.ski_jumping_system.entity.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TeamResultService implements ServiceInterface {

    TeamResultRepository teamResultRepository;
    CompetitionService competitionService;
    CountryService countryService;
    SkiJumperService skiJumperService;
    TeamOverallStandingService teamOverallStandingService;

    @Autowired
    public TeamResultService(TeamResultRepository teamResultRepository, CompetitionService competitionService,
                             CountryService countryService, SkiJumperService skiJumperService, @Lazy TeamOverallStandingService teamOverallStandingService) {
        this.teamResultRepository = teamResultRepository;
        this.competitionService = competitionService;
        this.countryService = countryService;
        this.skiJumperService = skiJumperService;
        this.teamOverallStandingService = teamOverallStandingService;
    }

    @Override
    public List<TeamResult> findAll() {
        return teamResultRepository.findAll();
    }

    public List<TeamResult> get(Specification<TeamResult> spec, Sort sort) {
        return teamResultRepository.findAll(spec, sort);
    }

    @Override
    public Optional<TeamResult> findById(int id) {
        return teamResultRepository.findById(id);
    }

    @Override
    public TeamResult save(Object obj) {
        return teamResultRepository.save((TeamResult) obj);
    }

    @Override
    public void deleteById(int id) {
        teamResultRepository.deleteById(id);
    }

    public void saveFromLink(String link, int competitionId) {
        Competition competition = competitionService
                .findById(competitionId)
                .orElseThrow(() -> new ResourceNotFoundException("no competition found for id = " + competitionId));
        saveTeamResult(link,competition);

        teamOverallStandingService.calculateNationsCupStandings(competition.getSeriesMajor().getId(),competition.getSeason().getSeason());
    }

    @Transactional
    public void saveTeamResult(String link, Competition competition){
        link = link.replace("%3A", ":");
        link = link.replace("%2F", "/");
        link = link.replace("%3F", "?");

        if (!competition.getTeamResults().isEmpty()) {
            for (TeamResult teamResult : competition.getTeamResults()) {
                teamResultRepository.deleteById(teamResult.getId());
            }
        }
        List<FetchedTeamResultObject> fetchedTeamResultObjects = fetchResults(link);
        for(FetchedTeamResultObject fetchedTeamResultObject : fetchedTeamResultObjects){
            TeamResult teamResult = new TeamResult();
            teamResult.setCompetition(competition);
            teamResult.setCountry(countryService.findByCode(fetchedTeamResultObject.getCountryCode()));

            SkiJumper skiJumper1 = skiJumperService.findByCode(String.valueOf(fetchedTeamResultObject.getSkiJumper1Code()));
            if(skiJumper1 != null){
                teamResult.setSkiJumper1(skiJumper1);
            }
            SkiJumper skiJumper2 = skiJumperService.findByCode(String.valueOf(fetchedTeamResultObject.getSkiJumper2Code()));
            if(skiJumper2 != null){
                teamResult.setSkiJumper2(skiJumper2);
            }
            SkiJumper skiJumper3 = skiJumperService.findByCode(String.valueOf(fetchedTeamResultObject.getSkiJumper3Code()));
            if(skiJumper3 != null){
                teamResult.setSkiJumper3(skiJumper3);
            }
            SkiJumper skiJumper4 = skiJumperService.findByCode(String.valueOf(fetchedTeamResultObject.getSkiJumper4Code()));
            if(skiJumper4 != null){
                teamResult.setSkiJumper4(skiJumper4);
            }

            teamResult.setTotalPoints(BigDecimal.valueOf(fetchedTeamResultObject.getTotalPoints()));

            teamResult.setTotalRank(fetchedTeamResultObject.getRank());
            save(teamResult);

        }
    }


    private List<FetchedTeamResultObject> fetchResults(String link) {
        List<FetchedTeamResultObject> fetchedTeamResultObjects = new ArrayList<>();
        try {
            Document doc = Jsoup.connect(link).get();
            Elements countryElements = doc.getElementsByClass("table-row table-row_theme_main m-0");
            Elements athletesElements = doc.getElementsByClass("table-row table-row_theme_additional");

            for (Element element : countryElements) {

                FetchedTeamResultObject fetchedTeamResultObject = new FetchedTeamResultObject();
                // rank
                int rank = Integer.parseInt(element.getElementsByClass("g-lg-1 g-md-1 g-sm-1 g-xs-2 justify-right bold pr-1").text());
                fetchedTeamResultObject.setRank(rank);

                //country code
                fetchedTeamResultObject.setCountryCode(element.getElementsByClass("country__name-short").text());

                //total rank
                fetchedTeamResultObject.setTotalPoints(Float.parseFloat(element.getElementsByClass("g-lg-2 g-md-2 g-sm-3 g-xs-5 justify-right").text()));

                fetchedTeamResultObject.setSkiJumper1Code(Integer.parseInt(athletesElements
                        .get((rank-1)*4)
                        .getElementsByClass("g-lg-2 g-md-2 g-sm-3 hidden-xs justify-right gray pr-1").text()));

                fetchedTeamResultObject.setSkiJumper2Code(Integer.parseInt(athletesElements
                        .get((rank-1)*4+1)
                        .getElementsByClass("g-lg-2 g-md-2 g-sm-3 hidden-xs justify-right gray pr-1").text()));

                fetchedTeamResultObject.setSkiJumper3Code(Integer.parseInt(athletesElements
                        .get((rank-1)*4+2)
                        .getElementsByClass("g-lg-2 g-md-2 g-sm-3 hidden-xs justify-right gray pr-1").text()));

                fetchedTeamResultObject.setSkiJumper4Code(Integer.parseInt(athletesElements
                        .get((rank-1)*4+3)
                        .getElementsByClass("g-lg-2 g-md-2 g-sm-3 hidden-xs justify-right gray pr-1").text()));

                fetchedTeamResultObjects.add(fetchedTeamResultObject);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fetchedTeamResultObjects;
    }

    public List<TeamResult> findBySeriesMajorAndSeason(Series series, int season) {
        List<TeamResult> results = new ArrayList<>();
        List<Competition> competitions = competitionService.findAllBySeriesMajorAndSeason(series,season);
        for (Competition competition : competitions) {
            List<TeamResult> resultsCompetition = competition.getTeamResults();
            results.addAll(resultsCompetition);
        }
        return results;
    }
}
