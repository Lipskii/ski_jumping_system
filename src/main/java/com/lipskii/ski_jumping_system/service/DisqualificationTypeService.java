package com.lipskii.ski_jumping_system.service;

import com.lipskii.ski_jumping_system.dao.DisqualificationTypeRepository;
import com.lipskii.ski_jumping_system.entity.DisqualificationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DisqualificationTypeService implements ServiceInterface {

    private final DisqualificationTypeRepository disqualificationTypeRepository;

    @Autowired
    public DisqualificationTypeService(DisqualificationTypeRepository disqualificationTypeRepository) {
        this.disqualificationTypeRepository = disqualificationTypeRepository;
    }

    @Override
    public List<DisqualificationType> findAll() {
        return (List<DisqualificationType>) disqualificationTypeRepository.findAll();
    }

    @Override
    public Optional<DisqualificationType> findById(int id) {
        return disqualificationTypeRepository.findById(id);
    }

    @Override
    public DisqualificationType save(Object obj) {
        return disqualificationTypeRepository.save((DisqualificationType) obj);
    }

    @Override
    public void deleteById(int id) {
        disqualificationTypeRepository.deleteById(id);
    }
}
