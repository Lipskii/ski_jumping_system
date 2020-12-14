package com.lipskii.ski_jumping_system.service;

import com.lipskii.ski_jumping_system.dao.SkiJumperRepository;
import com.lipskii.ski_jumping_system.entity.SkiJumper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkiJumperService implements ServiceInterface {

    private final SkiJumperRepository skiJumperRepository;

    @Autowired
    public SkiJumperService(SkiJumperRepository skiJumperRepository) {
        this.skiJumperRepository = skiJumperRepository;
    }

    @Override
    public List<SkiJumper> findAll() {
        return  skiJumperRepository.findAll();
    }

    @Override
    public Optional<SkiJumper> findById(int id) {
        return skiJumperRepository.findById(id);
    }

    @Override
    public void save(Object obj) {
        skiJumperRepository.save((SkiJumper) obj);
    }

    @Override
    public void deleteById(int id) {
        skiJumperRepository.deleteById(id);
    }
}
