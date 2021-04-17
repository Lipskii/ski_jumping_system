package com.lipskii.ski_jumping_system.service;

import com.lipskii.ski_jumping_system.dao.PointsScaleValueRepository;
import com.lipskii.ski_jumping_system.entity.PointsScale;
import com.lipskii.ski_jumping_system.entity.PointsScaleValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PointsScaleValueService implements ServiceInterface {

    private final PointsScaleValueRepository pointsScaleValueRepository;

    @Autowired
    public PointsScaleValueService(PointsScaleValueRepository pointsScaleValueRepository) {
        this.pointsScaleValueRepository = pointsScaleValueRepository;
    }

    @Override
    public List<PointsScaleValue> findAll() {
        return pointsScaleValueRepository.findAll();
    }

    public List<PointsScaleValue> get(Specification<PointsScaleValue> spec, Sort sort) {
        return pointsScaleValueRepository.findAll(spec, sort);
    }

    public List<PointsScaleValue> findByPointsScale(PointsScale pointsScale){
        return pointsScaleValueRepository.findAllByPointsScaleOrderByPoints(pointsScale);
    }

    @Override
    public Optional<PointsScaleValue> findById(int id) {
        return pointsScaleValueRepository.findById(id);
    }

    @Override
    public PointsScaleValue save(Object obj) {
        return pointsScaleValueRepository.save((PointsScaleValue) obj);
    }

    @Override
    public void deleteById(int id) {
        pointsScaleValueRepository.deleteById(id);
    }
}
