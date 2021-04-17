package com.lipskii.ski_jumping_system.service;

import com.lipskii.ski_jumping_system.dao.PointsScaleRepository;
import com.lipskii.ski_jumping_system.entity.PointsScale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PointsScaleService implements ServiceInterface {

    private final PointsScaleRepository pointsScaleRepository;

    @Autowired
    public PointsScaleService(PointsScaleRepository pointsScaleRepository) {
        this.pointsScaleRepository = pointsScaleRepository;
    }

    @Override
    public List<PointsScale> findAll() {
        return pointsScaleRepository.findAll();
    }

    public List<PointsScale> get(Specification<PointsScale> spec, Sort sort) {
        return pointsScaleRepository.findAll(spec, sort);
    }

    @Override
    public Optional<PointsScale> findById(int id) {
        return pointsScaleRepository.findById(id);
    }

    @Override
    public PointsScale save(Object obj) {
        return pointsScaleRepository.save((PointsScale) obj);
    }

    @Override
    public void deleteById(int id) {
        pointsScaleRepository.deleteById(id);
    }
}
