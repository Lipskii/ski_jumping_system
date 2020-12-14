package com.lipskii.ski_jumping_system.service;

import com.lipskii.ski_jumping_system.dao.JuryRepository;
import com.lipskii.ski_jumping_system.entity.Jury;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JuryService implements ServiceInterface {

    private final JuryRepository juryRepository;

    @Autowired
    public JuryService(JuryRepository juryRepository) {
        this.juryRepository = juryRepository;
    }

    @Override
    public List<Jury> findAll() {
        return juryRepository.findAll();
    }

    @Override
    public Optional<Jury> findById(int id) {
        return juryRepository.findById(id);
    }

    @Override
    public void save(Object obj) {
        juryRepository.save((Jury) obj);
    }

    @Override
    public void deleteById(int id) {
        juryRepository.deleteById(id);
    }
}
