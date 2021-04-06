package com.lipskii.ski_jumping_system.service;

import com.lipskii.ski_jumping_system.dao.SkiJumperRepository;
import com.lipskii.ski_jumping_system.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
        return skiJumperRepository.findAll();
    }

    public List<SkiJumper> get(Specification<SkiJumper> spec, Sort sort) {
        return skiJumperRepository.findAll(spec, sort);
    }

    public List<SkiJumper> findAllByCountry(Country country){
        return skiJumperRepository.findAllByPersonCountryOrderByPerson(country);
    }

    @Override
    public Optional<SkiJumper> findById(int id) {
        return skiJumperRepository.findById(id);
    }

    public SkiJumper findByCode(String code){
        return skiJumperRepository.findByFisCode(code);
    }

    @Override
    public SkiJumper save(Object obj) {
        return skiJumperRepository.save((SkiJumper) obj);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        SkiJumper skiJumper = skiJumperRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("ski jumper does not exist!"));
        System.out.println(skiJumper);
        skiJumperRepository.delete(skiJumper);
    }

}
