package com.lipskii.ski_jumping_system.service;

import com.lipskii.ski_jumping_system.dao.GenderRepository;
import com.lipskii.ski_jumping_system.entity.Gender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenderService {

    private final GenderRepository genderRepository;

    @Autowired
    public GenderService(GenderRepository genderRepository) {
        this.genderRepository = genderRepository;
    }

    public List<Gender> findAll() {
        return genderRepository.findAll();
    }

    public Optional<Gender> findById(int id) {
        return genderRepository.findById(id);
    }

}
