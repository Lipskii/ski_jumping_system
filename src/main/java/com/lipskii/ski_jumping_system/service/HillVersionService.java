package com.lipskii.ski_jumping_system.service;

import com.lipskii.ski_jumping_system.dao.HillVersionRepository;
import com.lipskii.ski_jumping_system.entity.HillVersion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HillVersionService implements ServiceInterface {

    private final HillVersionRepository hillVersionRepository;

    @Autowired
    public HillVersionService(HillVersionRepository hillVersionRepository) {
        this.hillVersionRepository = hillVersionRepository;
    }

    public List<HillVersion> get(Specification<HillVersion> spec, Sort sort) {
        return hillVersionRepository.findAll(spec, sort);
    }


    @Override
    public List<HillVersion> findAll() {
        return hillVersionRepository.findAll();
    }

    @Override
    public Optional<HillVersion> findById(int id) {
        return hillVersionRepository.findById(id);
    }

    @Override
    public HillVersion save(Object obj) {
        return hillVersionRepository.save((HillVersion) obj);
    }

    @Override
    public void deleteById(int id) {
        hillVersionRepository.deleteById(id);
    }
}
