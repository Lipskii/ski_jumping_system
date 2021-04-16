package com.lipskii.ski_jumping_system.service;

import com.lipskii.ski_jumping_system.dao.OverallStandingsRepository;
import com.lipskii.ski_jumping_system.entity.OverallStandings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OverallStandingsService implements ServiceInterface {

    private final OverallStandingsRepository overallStandingsRepository;

    @Autowired
    public OverallStandingsService(OverallStandingsRepository overallStandingsRepository) {
        this.overallStandingsRepository = overallStandingsRepository;
    }

    @Override
    public List<?> findAll() {
        return null;
    }

    public List<OverallStandings> get(Specification<OverallStandings> spec, Sort sort) {
        return overallStandingsRepository.findAll(spec, sort);
    }

    @Override
    public Object findById(int id) {
        return overallStandingsRepository.findById(id);
    }

    @Override
    public OverallStandings save(Object obj) {
        return overallStandingsRepository.save((OverallStandings) obj);
    }

    @Override
    public void deleteById(int id) {
        overallStandingsRepository.deleteById(id);
    }

}
