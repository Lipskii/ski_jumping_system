package com.lipskii.ski_jumping_system.service;

import com.lipskii.ski_jumping_system.dao.QualificationRepository;
import com.lipskii.ski_jumping_system.entity.Qualification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QualificationService implements ServiceInterface {

    final QualificationRepository qualificationRepository;

    @Autowired
    public QualificationService(QualificationRepository qualificationRepository) {
        this.qualificationRepository = qualificationRepository;
    }

    @Override
    public List<Qualification> findAll() {
        return qualificationRepository.findAll();
    }

    @Override
    public Optional<Qualification> findById(int id) {
        return qualificationRepository.findById(id);
    }

    @Override
    public Qualification save(Object obj) {
        return qualificationRepository.save((Qualification) obj);
    }

    @Override
    public void deleteById(int id) {
        qualificationRepository.deleteById(id);
    }


}
