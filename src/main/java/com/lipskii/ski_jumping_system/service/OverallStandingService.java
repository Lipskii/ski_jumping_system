package com.lipskii.ski_jumping_system.service;

import com.lipskii.ski_jumping_system.dao.OverallStandingRepository;
import com.lipskii.ski_jumping_system.entity.OverallStanding;
import com.lipskii.ski_jumping_system.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OverallStandingService implements ServiceInterface {

    private final OverallStandingRepository overallStandingRepository;
    private final ResultService resultService;

    @Autowired
    public OverallStandingService(OverallStandingRepository overallStandingRepository, ResultService resultService) {
        this.overallStandingRepository = overallStandingRepository;
        this.resultService = resultService;
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

        for(Result result : results){
            OverallStanding overallStanding = overallStandingRepository.findBySeasonSeasonAndSeriesIdAndSkiJumper(season, seriesId, result.getSkiJumper());

            int rank = result.getTotalRank();

            if(overallStanding != null){
                System.out.println("OS nie null");
            } else {
                System.out.println("OS null");
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
