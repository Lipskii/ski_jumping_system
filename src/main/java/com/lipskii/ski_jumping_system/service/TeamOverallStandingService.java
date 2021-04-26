package com.lipskii.ski_jumping_system.service;

import com.lipskii.ski_jumping_system.dao.TeamOverallStandingRepository;
import com.lipskii.ski_jumping_system.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

//TODO CLEANUP CODE (Nations cup etc.)
@Service
public class TeamOverallStandingService implements ServiceInterface {

    private final TeamOverallStandingRepository teamOverallStandingRepository;
    private final ResultService resultService;
    private final TeamResultService teamResultService;
    private final PointsScaleValueService pointsScaleValueService;
    private final SeriesService seriesService;
    private final OverallStandingService overallStandingService;

    @Autowired
    public TeamOverallStandingService(TeamOverallStandingRepository overallStandingRepository,
                                      @Lazy ResultService resultService,
                                      TeamResultService teamResultService,
                                      PointsScaleValueService pointsScaleValueService,
                                      @Lazy OverallStandingService overallStandingService,
                                      SeriesService seriesService) {
        this.teamOverallStandingRepository = overallStandingRepository;
        this.resultService = resultService;
        this.pointsScaleValueService = pointsScaleValueService;
        this.teamResultService = teamResultService;
        this.seriesService = seriesService;
        this.overallStandingService = overallStandingService;
    }

    @Override
    public  List<TeamOverallStanding> findAll() {
        return teamOverallStandingRepository.findAll();
    }

    public List<TeamOverallStanding> get(Specification<TeamOverallStanding> spec, Sort sort) {
        return teamOverallStandingRepository.findAll(spec, sort);
    }

    @Override
    public Object findById(int id) {
        return teamOverallStandingRepository.findById(id);
    }

    @Override
    public TeamOverallStanding save(Object obj) {
        return teamOverallStandingRepository.save((TeamOverallStanding) obj);
    }

    @Override
    public void deleteById(int id) {
        teamOverallStandingRepository.deleteById(id);
    }

    public void calculateNationsCupStandings(int seriesId, int season) {
        Series series = seriesService.findById(seriesId).orElseThrow(() -> new ResourceNotFoundException("no series found for id = " + seriesId));
        if (series.getPointsScale() != null) {
            if (series.getPointsScale().getId() == 1) {
                setTeamOverallStandingsRankToZero(season, series);
                calculateNationsCupStandingsByPointScaleTeamCompetitions(season, series);
                calculateNationsCupByPointScaleIndividualCompetitions(season);
            }
            setRankingsForTeamOverallStandings(season, series);
        }
    }

    private void calculateNationsCupStandingsByPointScaleTeamCompetitions(int season, Series series) {
        List<PointsScaleValue> pointsScaleValues = pointsScaleValueService.findByPointsScale(series.getPointsScale());
        List<TeamResult> results = teamResultService.findBySeriesMajorAndSeason(series, season);

        for (TeamResult result : results) {
            int rank = result.getTotalRank();
            PointsScaleValue pointsScaleValue = getPointScaleValueByRank(pointsScaleValues, rank);

            if (pointsScaleValue != null) {
                TeamOverallStanding teamOverallStanding = teamOverallStandingRepository.findBySeasonSeasonAndSeriesAndCountry(season, series, result.getCountry());
                if (teamOverallStanding != null) {
                    teamOverallStanding.setPoints(teamOverallStanding.getPoints().add(BigDecimal.valueOf(pointsScaleValue.getPoints())));
                } else {
                    teamOverallStanding = new TeamOverallStanding(
                            series,
                            result.getCompetition().getSeason(),
                            result.getCountry(),
                            BigDecimal.valueOf(pointsScaleValue.getPoints()), 0);
                }
                teamOverallStandingRepository.save(teamOverallStanding);
            }
        }
    }

    public void calculateNationsCupByPointScaleIndividualCompetitions(int season) {
        Series teamSeries = seriesService.findById(11).orElseThrow(() -> new ResourceNotFoundException("no series found for id = 9"));
        Series indSeries = seriesService.findById(9).orElseThrow(() -> new ResourceNotFoundException("no series found for id = 9"));
        List<Result> results = resultService.findAllBySeriesMajorAndSeason(indSeries,season);
        List<PointsScaleValue> pointsScaleValues = pointsScaleValueService.findByPointsScale(indSeries.getPointsScale());
        for(Result result : results){
            int rank = result.getTotalRank();
            PointsScaleValue pointsScaleValue = getPointScaleValueByRank(pointsScaleValues, rank);

            if (pointsScaleValue != null) {
                TeamOverallStanding teamOverallStanding = teamOverallStandingRepository
                        .findBySeasonSeasonAndSeriesAndCountry(
                                season,
                                teamSeries,
                                result.getSkiJumper().getPerson().getCountry());

                if (teamOverallStanding != null) {
                    teamOverallStanding.setPoints(teamOverallStanding.getPoints().add(BigDecimal.valueOf(pointsScaleValue.getPoints())));
                } else {
                    teamOverallStanding = new TeamOverallStanding(
                            teamSeries,
                            result.getCompetition().getSeason(),
                            result.getSkiJumper().getPerson().getCountry(),
                            BigDecimal.valueOf(pointsScaleValue.getPoints()),
                            0);
                }
                teamOverallStandingRepository.save(teamOverallStanding);
            }

        }
    }

    private void setTeamOverallStandingsRankToZero(int season, Series series) {
        List<TeamOverallStanding> teamOverallStandings = teamOverallStandingRepository.findAllBySeasonSeasonAndSeriesOrderByPointsDesc(season, series);
        for (TeamOverallStanding teamOverallStanding : teamOverallStandings) {
            teamOverallStanding.setPoints(BigDecimal.valueOf(0));
            teamOverallStanding.setRanking(0);
            teamOverallStandingRepository.save(teamOverallStanding);
        }
    }

    private PointsScaleValue getPointScaleValueByRank(List<PointsScaleValue> pointsScaleValues, int rank) {
        PointsScaleValue pointsScaleValue = pointsScaleValues.stream()
                .filter(pointsScaleValue1 -> pointsScaleValue1.getRank() == rank)
                .findFirst()
                .orElse(null);
        return pointsScaleValue;
    }

    private void setRankingsForTeamOverallStandings(int season, Series series) {
        List<TeamOverallStanding> teamOverallStandings = teamOverallStandingRepository.findAllBySeasonSeasonAndSeriesOrderByPointsDesc(season, series);
        for (int i = 0; i < teamOverallStandings.size(); i++) {
            TeamOverallStanding teamOverallStanding = teamOverallStandings.get(i);
            BigDecimal formerPoints;

            if (teamOverallStanding.getPoints().equals(BigDecimal.ZERO)) {
                teamOverallStanding.setRanking(0);
            } else {
                if (i == 0) {
                    formerPoints = BigDecimal.valueOf(-1);
                } else {
                    formerPoints = teamOverallStandings.get(i - 1).getPoints();
                }

                if (teamOverallStanding.getPoints().equals(formerPoints)) {
                    teamOverallStanding.setRanking(teamOverallStandings.get(i - 1).getRanking());
                } else {
                    teamOverallStanding.setRanking(i + 1);
                }
            }

            teamOverallStandingRepository.save(teamOverallStanding);
        }
    }

    @Transactional
    public void teamOverallStandingsSubtractionByIndCompetition(Competition competition) {
        Series series;

        if(competition.getSeriesMajor().getId() == 9){
            series = seriesService.findById(11).orElseThrow(() -> new ResourceNotFoundException("no series found for id = 9"));
        } else {
            series = seriesService.findById(11).orElseThrow(() -> new ResourceNotFoundException("no series found for id = 9")); //TODO later change it to womens nations cup
        }

        List<PointsScaleValue> pointsScaleValues = pointsScaleValueService.findByPointsScale(competition.getSeriesMajor().getPointsScale());

        for(Result result : competition.getResults()){

            TeamOverallStanding teamOverallStanding = teamOverallStandingRepository.findBySeasonSeasonAndSeriesAndCountry(
                    competition.getSeason().getSeason(), series, result.getSkiJumper().getPerson().getCountry());

            int rank = result.getTotalRank();
            PointsScaleValue pointsScaleValue = getPointScaleValueByRank(pointsScaleValues, rank);
            if(pointsScaleValue != null){
                teamOverallStanding.setPoints(teamOverallStanding.getPoints().subtract(BigDecimal.valueOf(pointsScaleValue.getPoints())));
                teamOverallStandingRepository.save(teamOverallStanding);
            }
        }
    }
}
