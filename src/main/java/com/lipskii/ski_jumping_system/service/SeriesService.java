package com.lipskii.ski_jumping_system.service;

import com.lipskii.ski_jumping_system.dao.SeriesRepository;
import com.lipskii.ski_jumping_system.entity.Series;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return (List<Series>) seriesRepository.findAll();
    }

    @Override
    public Optional<Series> findById(int id) {
        return seriesRepository.findById(id);
    }

    @Override
    public void save(Object obj) {
        seriesRepository.save((Series) obj);
    }

    @Override
    public void deleteById(int id) {
        seriesRepository.deleteById(id);
    }
}
