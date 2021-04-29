package com.lipskii.ski_jumping_system.service;

import com.lipskii.ski_jumping_system.dao.ResultRepository;
import com.lipskii.ski_jumping_system.db_data.FetchedResultsObject;
import com.lipskii.ski_jumping_system.entity.Competition;
import com.lipskii.ski_jumping_system.entity.Result;
import com.lipskii.ski_jumping_system.entity.Series;
import com.lipskii.ski_jumping_system.entity.SkiJumper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
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
public class ResultService implements ServiceInterface {

    private final ResultRepository resultRepository;
    private final CompetitionService competitionService;
    private final SkiJumperService skiJumperService;
    private final DisqualificationTypeService disqualificationTypeService;
    private final OverallStandingService overallStandingService;
    private final TeamOverallStandingService teamOverallStandingService;

    @Autowired
    public ResultService(ResultRepository resultRepository,
                         CompetitionService competitionService,
                         SkiJumperService skiJumperService,
                         DisqualificationTypeService disqualificationTypeService,
                         TeamOverallStandingService teamOverallStandingService,
                         OverallStandingService overallStandingService) {
        this.resultRepository = resultRepository;
        this.competitionService = competitionService;
        this.skiJumperService = skiJumperService;
        this.disqualificationTypeService = disqualificationTypeService;
        this.overallStandingService = overallStandingService;
        this.teamOverallStandingService = teamOverallStandingService;
    }

    @Override
    public List<Result> findAll() {
        return resultRepository.findAll();
    }

    public List<Result> findAllByHillVersionIdAndCompetitionSeriesMajorId(int hillVersionId, int seriesMajorId) {
        return resultRepository.findAllByCompetitionHillVersionIdAndCompetitionSeriesMajorId(hillVersionId, seriesMajorId);
    }

    public List<Result> findAllByCompetitionId(int competitionId) {
        return resultRepository.findAllByCompetitionIdOrderByTotalRank(competitionId);
    }

    public List<Result> get(Specification<Result> spec, Sort sort) {
        return resultRepository.findAll(spec, sort);
    }


    public List<Result> findAllBySeriesMajorAndSeason(Series series, int season) {
        List<Result> results = new ArrayList<>();
        List<Competition> competitions = competitionService.findAllBySeriesMajorAndSeason(series, season);
        for (Competition competition : competitions) {
            List<Result> resultsCompetition = competition.getResults();
            results.addAll(resultsCompetition);
        }
        return results;
    }

    public List<Result> findBySeriesMinorAndSeason(Series series, int season) {
        List<Result> results = new ArrayList<>();
        List<Competition> competitions = competitionService.findAllBySeriesMinorAndSeason(series, season);
        for (Competition competition : competitions) {
            List<Result> resultsCompetition = competition.getResults();
            results.addAll(resultsCompetition);
        }

        return results;
    }


    @Override
    public Optional<Result> findById(int id) {
        return resultRepository.findById(id);
    }

    @Override
    public Result save(Object obj) {
        return resultRepository.save((Result) obj);
    }


    public void saveFromLink(String link, int competitionId) {
        link = link.replace("%3A", ":");
        link = link.replace("%2F", "/");
        link = link.replace("%3F", "?");

        Competition competition = competitionService
                .findById(competitionId)
                .orElseThrow(() -> new ResourceNotFoundException("no competition found for id = " + competitionId));

        if (!competition.getResults().isEmpty()) {
            for (Result result : competition.getResults()) {
                resultRepository.deleteById(result.getId());
            }
        }
        List<FetchedResultsObject> fetchedResultsObjects = fetchResults(link);
        assert fetchedResultsObjects != null;
        saveResultsFromFetchedResultsObjects(fetchedResultsObjects, competition);
        try {
            overallStandingService.calculateStandings(competition.getSeriesMajor().getId(), competition.getSeason().getSeason());
            if (competition.getSeriesMajor().getId() == 9) {
                teamOverallStandingService.calculateNationsCupByPointScaleIndividualCompetitions(competition.getSeason().getSeason());
            }
            if (competition.getSeriesMinor() != null) {
                overallStandingService.calculateStandings(competition.getSeriesMinor().getId(), competition.getSeason().getSeason());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Transactional
    public void saveResultsFromFetchedResultsObjects(List<FetchedResultsObject> fetchedResultsObjects, Competition competition) {
        for (FetchedResultsObject fetchedResultsObject : fetchedResultsObjects) {
            Result result = new Result();
            SkiJumper skiJumper = skiJumperService.findByCode(String.valueOf(fetchedResultsObject.getCode()));
            if (skiJumper != null) {
                result.setSkiJumper(skiJumper);
                result.setCompetition(competition);
                result.setTotalRank(fetchedResultsObject.getRank());
                result.setTotalPoints(BigDecimal.valueOf(fetchedResultsObject.getTotalPoints()));
                result.setFirstRoundDistance(BigDecimal.valueOf(fetchedResultsObject.getFirstRoundDistance()));
                result.setFirstRoundTotal(BigDecimal.valueOf(fetchedResultsObject.getFirstRoundPoints()));
                result.setSecondRoundDistance(BigDecimal.valueOf(fetchedResultsObject.getSecondRoundDistance()));
                result.setSecondRoundTotal(BigDecimal.valueOf(fetchedResultsObject.getSecondRoundPoints()));
                result.setThirdRoundDistance(BigDecimal.valueOf(fetchedResultsObject.getThirdRoundDistance()));
                result.setThirdRoundTotal(BigDecimal.valueOf(fetchedResultsObject.getThirdRoundPoints()));
                result.setFourthRoundDistance(BigDecimal.valueOf(fetchedResultsObject.getFourthRoundDistance()));
                result.setFourthRoundTotal(BigDecimal.valueOf(fetchedResultsObject.getFourthRoundPoints()));
                resultRepository.save(result);
            }
        }
    }



    @Override
    public void deleteById(int id) {
        resultRepository.deleteById(id);
    }

    public static List<FetchedResultsObject> fetchResults(String link) {
        try {
            Document doc = Jsoup.connect(link).get();
            Elements elements = doc.getElementsByClass("table-row");
            List<FetchedResultsObject> fetchedResultsObjects = new ArrayList<>();
            for (Element element : elements) {
                if (!element.getElementsByClass("g-lg g-md g-sm g-xs justify-left bold").text().equals("")) {

                    FetchedResultsObject fetchedResultsObject = new FetchedResultsObject();
                    if (!element.getElementsByClass("g-lg-1 g-md-1 g-sm-1 g-xs-2 justify-right pr-1 gray bold")
                            .text().equals("")) {
                        fetchedResultsObject.setRank(Integer
                                .parseInt(element
                                        .getElementsByClass("g-lg-1 g-md-1 g-sm-1 g-xs-2 justify-right pr-1 gray bold")
                                        .text()));
                    }
                    if (!element.getElementsByClass("g-lg-2 g-md-2 g-sm-2 hidden-xs justify-right gray pr-1")
                            .text().equals("")) {
                        fetchedResultsObject.setCode(Integer
                                .parseInt(element
                                        .getElementsByClass("g-lg-2 g-md-2 g-sm-2 hidden-xs justify-right gray pr-1")
                                        .text()));
                    }
                    if (!element.getElementsByClass("g-row justify-right bold")
                            .text().equals("")) {
                        String[] distances = element.getElementsByClass("g-row justify-right bold")
                                .text().split(" ");

                        switch (distances.length) {
                            case 1:
                                fetchedResultsObject.setFirstRoundDistance(Float.parseFloat(distances[0]));
                                break;
                            case 2:
                                fetchedResultsObject.setFirstRoundDistance(Float.parseFloat(distances[0]));
                                fetchedResultsObject.setSecondRoundDistance(Float.parseFloat(distances[1]));
                                break;
                            case 3:
                                fetchedResultsObject.setFirstRoundDistance(Float.parseFloat(distances[0]));
                                fetchedResultsObject.setSecondRoundDistance(Float.parseFloat(distances[1]));
                                fetchedResultsObject.setThirdRoundDistance(Float.parseFloat(distances[2]));
                                break;
                            case 4:
                                fetchedResultsObject.setFirstRoundDistance(Float.parseFloat(distances[0]));
                                fetchedResultsObject.setSecondRoundDistance(Float.parseFloat(distances[1]));
                                fetchedResultsObject.setThirdRoundDistance(Float.parseFloat(distances[2]));
                                fetchedResultsObject.setFourthRoundDistance(Float.parseFloat(distances[3]));
                        }
                    }
                    if (!element.getElementsByClass("g-lg-24 justify-right bold")
                            .text().equals("")) {
                        String[] points = element.getElementsByClass("g-lg-24 justify-right bold")
                                .text().split(" ");

                        switch (points.length) {
                            case 1:
                                fetchedResultsObject.setFirstRoundPoints(Float.parseFloat(points[0]));
                                break;
                            case 2:
                                fetchedResultsObject.setFirstRoundPoints(Float.parseFloat(points[0]));
                                fetchedResultsObject.setSecondRoundPoints(Float.parseFloat(points[1]));
                                break;
                            case 3:
                                fetchedResultsObject.setFirstRoundPoints(Float.parseFloat(points[0]));
                                fetchedResultsObject.setSecondRoundPoints(Float.parseFloat(points[1]));
                                fetchedResultsObject.setThirdRoundPoints(Float.parseFloat(points[2]));
                                break;
                            case 4:
                                fetchedResultsObject.setFirstRoundPoints(Float.parseFloat(points[0]));
                                fetchedResultsObject.setSecondRoundPoints(Float.parseFloat(points[1]));
                                fetchedResultsObject.setThirdRoundPoints(Float.parseFloat(points[2]));
                                fetchedResultsObject.setFourthRoundPoints(Float.parseFloat(points[3]));
                        }
                    }
                    if (!element.getElementsByClass("g-lg-2 g-md-2 g-sm-3 g-xs-5 justify-right blue bold ")
                            .text().equals("")) {
                        fetchedResultsObject.setTotalPoints(Float.parseFloat(element.getElementsByClass("g-lg-2 g-md-2 g-sm-3 g-xs-5 justify-right blue bold ")
                                .text()));
                    }
                    fetchedResultsObjects.add(fetchedResultsObject);
                }

            }

            return fetchedResultsObjects;


        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
