package com.lipskii.ski_jumping_system.service;

import com.lipskii.ski_jumping_system.dao.JuryTypeRepository;
import com.lipskii.ski_jumping_system.entity.JuryType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JuryTypeService implements ServiceInterface{

    private final JuryTypeRepository juryTypeRepository;

    @Autowired
    public JuryTypeService(JuryTypeRepository juryTypeRepository) {
        this.juryTypeRepository = juryTypeRepository;
    }

    @Override
    public List<JuryType> findAll() {
        return (List<JuryType>) juryTypeRepository.findAll();
    }

    @Override
    public Optional<JuryType> findById(int id) {
        return juryTypeRepository.findById(id);
    }

    @Override
    public JuryType save(Object obj) {
        return juryTypeRepository.save((JuryType) obj);
    }

    @Override
    public void deleteById(int id) {
        juryTypeRepository.deleteById(id);
    }
}
