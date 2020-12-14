package com.lipskii.ski_jumping_system.service;

import com.lipskii.ski_jumping_system.dao.CompetitionRepository;
import com.lipskii.ski_jumping_system.entity.Competition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompetitionService implements ServiceInterface {


    private final CompetitionRepository competitionRepository;

    @Autowired
    public CompetitionService(CompetitionRepository competitionRepository) {
        this.competitionRepository = competitionRepository;
    }

    @Override
    public List<Competition> findAll() {
        return competitionRepository.findAll();
    }

    @Override
    public Optional<Competition> findById(int id) {
        return competitionRepository.findById(id);
    }

    @Override
    public void save(Object obj) {
        competitionRepository.save((Competition) obj);
    }

    @Override
    public void deleteById(int id) {
        competitionRepository.deleteById(id);
    }
}
