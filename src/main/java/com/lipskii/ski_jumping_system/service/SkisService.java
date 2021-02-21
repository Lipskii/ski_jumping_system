package com.lipskii.ski_jumping_system.service;

import com.lipskii.ski_jumping_system.dao.SkisRepository;
import com.lipskii.ski_jumping_system.dto.SkiJumperDTO;
import com.lipskii.ski_jumping_system.dto.SkisDTO;
import com.lipskii.ski_jumping_system.entity.SkiJumper;
import com.lipskii.ski_jumping_system.entity.Skis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SkisService implements ServiceInterface {

    private final SkisRepository skisRepository;

    @Autowired
    public SkisService(SkisRepository skisRepository) {
        this.skisRepository = skisRepository;
    }

    @Override
    public List<SkisDTO> findAll() {
        return skisRepository.findAll().stream().map(this::convertToSkisDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<Skis> findById(int id) {
        return skisRepository.findById(id);
    }

    @Override
    public Skis save(Object obj) {
        return skisRepository.save((Skis) obj);
    }

    @Override
    public void deleteById(int id) {
        skisRepository.deleteById(id);
    }

    private SkisDTO convertToSkisDTO(Skis skis) {
        SkisDTO skisDTO = new SkisDTO();
        skisDTO.setId(skis.getId());
        skisDTO.setBrand(skis.getBrand());

        return skisDTO;
    }
}
