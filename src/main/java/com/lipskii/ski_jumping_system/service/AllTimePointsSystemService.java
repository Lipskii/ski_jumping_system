package com.lipskii.ski_jumping_system.service;

import com.lipskii.ski_jumping_system.dao.AllTimePointsSystemRepository;
import com.lipskii.ski_jumping_system.entity.AllTimePointsSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AllTimePointsSystemService implements ServiceInterface {

    private final AllTimePointsSystemRepository allTimePointsSystemRepository;

    @Autowired
    public AllTimePointsSystemService(AllTimePointsSystemRepository allTimePointsSystemRepository) {
        this.allTimePointsSystemRepository = allTimePointsSystemRepository;
    }

    @Override
    public List<AllTimePointsSystem> findAll() {
        return (List<AllTimePointsSystem>) allTimePointsSystemRepository.findAll();
    }

    @Override
    public Optional<AllTimePointsSystem> findById(int id) {
        return allTimePointsSystemRepository.findById(id);
    }

    @Override
    public AllTimePointsSystem save(Object obj) {
        return allTimePointsSystemRepository.save((AllTimePointsSystem) obj);
    }

    @Override
    public void deleteById(int id) {
        allTimePointsSystemRepository.deleteById(id);
    }
}
