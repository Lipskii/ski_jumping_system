package com.lipskii.ski_jumping_system.service;

import com.lipskii.ski_jumping_system.dao.OverallStandingRepository;
import com.lipskii.ski_jumping_system.entity.OverallStanding;
import com.lipskii.ski_jumping_system.entity.PointsScaleValue;
import com.lipskii.ski_jumping_system.entity.Result;
import com.lipskii.ski_jumping_system.entity.Series;
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
    private final PointsScaleValueService pointsScaleValueService;
    private final SeriesService seriesService;

    @Autowired
    public OverallStandingService(OverallStandingRepository overallStandingRepository, @Lazy ResultService resultService,
                                  PointsScaleValueService pointsScaleValueService, SeriesService seriesService) {
        this.overallStandingRepository = overallStandingRepository;
        this.resultService = resultService;
        this.pointsScaleValueService = pointsScaleValueService;
        this.seriesService = seriesService;
    }

    @Override
    public List<OverallStanding> findAll() {

        return overallStandingRepository.findAll();
    }

    public List<OverallStanding> get(Specification<OverallStanding> spec, Sort sort) {
        return overallStandingRepository.findAll(spec, sort);
    }

    public void calculateStandings(int seriesId, int season) {
        List<Result> results = resultService.findBySeriesIdAndSeason(seriesId, season);
        Series series = seriesService.findById(seriesId).orElseThrow(() -> new ResourceNotFoundException("no series found for id = " + seriesId));
        List<PointsScaleValue> pointsScaleValues = pointsScaleValueService.findByPointsScale(series.getPointsScale());

        for (Result result : results) {
            OverallStanding overallStanding = overallStandingRepository.findBySeasonSeasonAndSeriesAndSkiJumper(season, series, result.getSkiJumper());
            int rank = result.getTotalRank();

            PointsScaleValue pointsScaleValue = pointsScaleValues.stream()
                    .filter(pointsScaleValue1 -> pointsScaleValue1.getRank() == rank)
                    .findFirst()
                    .orElse(null);

            if (pointsScaleValue != null) {
                if (overallStanding != null) {
                    overallStanding.setPoints(overallStanding.getPoints().add(BigDecimal.valueOf(rank)));
                } else {
                    overallStanding = new OverallStanding(series, result.getCompetition().getSeason(), result.getSkiJumper(), BigDecimal.valueOf(pointsScaleValue.getPoints()));
                }
                overallStandingRepository.save(overallStanding);
            }
        }
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
