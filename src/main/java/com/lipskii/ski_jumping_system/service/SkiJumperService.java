package com.lipskii.ski_jumping_system.service;

import com.lipskii.ski_jumping_system.dao.SkiJumperRepository;
import com.lipskii.ski_jumping_system.dto.SkiJumperDTO;
import com.lipskii.ski_jumping_system.entity.City;
import com.lipskii.ski_jumping_system.entity.Competition;
import com.lipskii.ski_jumping_system.entity.Country;
import com.lipskii.ski_jumping_system.entity.SkiJumper;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Override
    public SkiJumper save(Object obj) {
        return skiJumperRepository.save((SkiJumper) obj);
    }

    @Override
    public void deleteById(int id) {
        skiJumperRepository.deleteById(id);
    }

}
