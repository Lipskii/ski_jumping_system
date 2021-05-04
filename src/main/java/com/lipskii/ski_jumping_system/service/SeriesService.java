package com.lipskii.ski_jumping_system.service;

import com.lipskii.ski_jumping_system.dao.SeriesRepository;
import com.lipskii.ski_jumping_system.entity.OverallStanding;
import com.lipskii.ski_jumping_system.entity.Series;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
public class SeriesService implements ServiceInterface {

    final SeriesRepository seriesRepository;

    @Autowired
    public SeriesService(SeriesRepository seriesRepository) {
        this.seriesRepository = seriesRepository;
    }

    @Override
    public List<Series> findAll() {
        return seriesRepository.findAllByOrderByName();
    }

    public List<Series> get(Specification<Series> spec, Sort sort) {
        return seriesRepository.findAll(spec, sort);
    }

    @Override
    public Optional<Series> findById(int id) {
        return seriesRepository.findById(id);
    }

    @Transactional
    @Override
    public Series save(Object obj) {
        return seriesRepository.save((Series) obj);
    }

    @Override
    public void deleteById(int id) {
        seriesRepository.deleteById(id);
    }
}
