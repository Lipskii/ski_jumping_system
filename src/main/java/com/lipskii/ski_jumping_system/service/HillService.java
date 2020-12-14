package com.lipskii.ski_jumping_system.service;

import com.lipskii.ski_jumping_system.dao.HillRepository;
import com.lipskii.ski_jumping_system.entity.Hill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HillService implements ServiceInterface {

    private final HillRepository hillRepository;

    @Autowired
    public HillService(HillRepository hillRepository) {
        this.hillRepository = hillRepository;
    }

    @Override
    public List<Hill> findAll() {
        return hillRepository.findAll();
    }

    @Override
    public Optional<Hill> findById(int id) {
        return hillRepository.findById(id);
    }

    @Override
    public void save(Object obj) {
        hillRepository.save((Hill) obj);
    }

    @Override
    public void deleteById(int id) {
        hillRepository.deleteById(id);
    }
}
