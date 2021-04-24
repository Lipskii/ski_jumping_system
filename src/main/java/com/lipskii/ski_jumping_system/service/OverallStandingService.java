package com.lipskii.ski_jumping_system.service;

import com.lipskii.ski_jumping_system.dao.OverallStandingRepository;
import com.lipskii.ski_jumping_system.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OverallStandingService implements ServiceInterface {

    private final OverallStandingRepository overallStandingRepository;
    private final ResultService resultService;
    private final TeamResultService teamResultService;
    private final PointsScaleValueService pointsScaleValueService;
    private final SeriesService seriesService;

    @Autowired
    public OverallStandingService(OverallStandingRepository overallStandingRepository, @Lazy ResultService resultService, TeamResultService teamResultService,
                                  PointsScaleValueService pointsScaleValueService, SeriesService seriesService) {
        this.overallStandingRepository = overallStandingRepository;
        this.resultService = resultService;
        this.pointsScaleValueService = pointsScaleValueService;
        this.teamResultService = teamResultService;
        this.seriesService = seriesService;
    }

    @Override
    public List<OverallStanding> findAll() {

        return overallStandingRepository.findAll();
    }

    public List<OverallStanding> get(Specification<OverallStanding> spec, Sort sort) {
        return overallStandingRepository.findAll(spec, sort);
    }

    public List<OverallStanding> findAllBySeriesAndSeasonSeason(Series series, int season){
        return overallStandingRepository.findAllBySeasonSeasonAndSeriesOrderByPointsDesc(season,series);
    }

    public void calculateStandings(int seriesId, int season) {
        Series series = seriesService.findById(seriesId).orElseThrow(() -> new ResourceNotFoundException("no series found for id = " + seriesId));
        if (series.getPointsScale() != null) {
            if (series.getPointsScale().getId() == 6) {
                List<Result> results = resultService.findBySeriesMinorAndSeason(series,season);
                calculateStandingsByNote(season, series, results);
            } else {
                List<Result> results = resultService.findAllBySeriesMajorAndSeason(series, season);
                calculateStandingsByPointScale(season, series, results);
            }
            setRankingsForOverallStandings(season, series);
        }
    }


    private void calculateStandingsByNote(int season, Series series, List<Result> results) {
        setOverallStandingsRankToZero(season, series);
        for (Result result : results) {
            OverallStanding overallStanding = overallStandingRepository.findBySeasonSeasonAndSeriesAndSkiJumper(season, series, result.getSkiJumper());
            if (overallStanding != null) {
                overallStanding.setPoints(overallStanding.getPoints().add(result.getTotalPoints()));
            } else {
                overallStanding = new OverallStanding(series, result.getCompetition().getSeason(), result.getSkiJumper(), result.getTotalPoints(), 0);
            }
            overallStandingRepository.save(overallStanding);
        }
    }

    private void calculateStandingsByPointScale(int season, Series series, List<Result> results) {
        List<PointsScaleValue> pointsScaleValues = pointsScaleValueService.findByPointsScale(series.getPointsScale());
        setOverallStandingsRankToZero(season, series);

        for (Result result : results) {
            int rank = result.getTotalRank();
            PointsScaleValue pointsScaleValue = getPointScaleValueByRank(pointsScaleValues, rank);

            if (pointsScaleValue != null) {
                OverallStanding overallStanding = overallStandingRepository.findBySeasonSeasonAndSeriesAndSkiJumper(season, series, result.getSkiJumper());
                if (overallStanding != null) {
                    overallStanding.setPoints(overallStanding.getPoints().add(BigDecimal.valueOf(pointsScaleValue.getPoints())));
                } else {
                    overallStanding = new OverallStanding(
                            series,
                            result.getCompetition().getSeason(),
                            result.getSkiJumper(),
                            BigDecimal.valueOf(pointsScaleValue.getPoints()), 0);
                }

                overallStandingRepository.save(overallStanding);
            }
        }
    }


    private void setOverallStandingsRankToZero(int season, Series series) {
        List<OverallStanding> overallStandings = overallStandingRepository.findAllBySeasonSeasonAndSeriesOrderByPointsDesc(season, series);
        for (OverallStanding overallStanding : overallStandings) {
            overallStanding.setPoints(BigDecimal.valueOf(0));
            overallStanding.setRanking(0);
            overallStandingRepository.save(overallStanding);
        }
    }

    private void setRankingsForOverallStandings(int season, Series series) {
        List<OverallStanding> overallStandings = overallStandingRepository.findAllBySeasonSeasonAndSeriesOrderByPointsDesc(season, series);
        for (int i = 0; i < overallStandings.size(); i++) {
            OverallStanding overallStanding = overallStandings.get(i);
            BigDecimal formerPoints;
            if (overallStanding.getPoints().equals(BigDecimal.ZERO)) {
                overallStanding.setRanking(0);
            } else {
                if (i == 0) {
                    formerPoints = BigDecimal.valueOf(-1);
                } else {
                    formerPoints = overallStandings.get(i - 1).getPoints();
                }

                if (overallStanding.getPoints().equals(formerPoints)) {
                    overallStanding.setRanking(overallStandings.get(i - 1).getRanking());
                } else {
                    overallStanding.setRanking(i + 1);
                }
            }

            overallStandingRepository.save(overallStanding);
        }
    }

    private PointsScaleValue getPointScaleValueByRank(List<PointsScaleValue> pointsScaleValues, int rank) {
        PointsScaleValue pointsScaleValue = pointsScaleValues.stream()
                .filter(pointsScaleValue1 -> pointsScaleValue1.getRank() == rank)
                .findFirst()
                .orElse(null);
        return pointsScaleValue;
    }

    @Override
    public Object findById(int id) {
        return overallStandingRepository.findById(id);
    }

    @Override
    public OverallStanding save(Object obj) {
        return overallStandingRepository.save((OverallStanding) obj);
    }

    @Override
    public void deleteById(int id) {
        overallStandingRepository.deleteById(id);
    }


}
