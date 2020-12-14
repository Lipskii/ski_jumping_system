package com.lipskii.ski_jumping_system.service;

import com.lipskii.ski_jumping_system.dao.SizeOfHillRepository;
import com.lipskii.ski_jumping_system.entity.SizeOfHill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SizeOfHillService implements ServiceInterface {

    private final SizeOfHillRepository sizeOfHillRepository;

    @Autowired
    public SizeOfHillService(SizeOfHillRepository sizeOfHillRepository) {
        this.sizeOfHillRepository = sizeOfHillRepository;
    }

    @Override
    public List<SizeOfHill> findAll() {
        return (List<SizeOfHill>) sizeOfHillRepository.findAll();
    }

    @Override
    public Optional<SizeOfHill> findById(int id) {
        return sizeOfHillRepository.findById(id);
    }

    @Override
    public void save(Object obj) {
        sizeOfHillRepository.save((SizeOfHill) obj);
    }

    @Override
    public void deleteById(int id) {
        sizeOfHillRepository.deleteById(id);
    }
}
