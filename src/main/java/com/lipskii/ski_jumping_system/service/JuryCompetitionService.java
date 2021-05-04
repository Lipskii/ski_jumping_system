package com.lipskii.ski_jumping_system.service;

import com.lipskii.ski_jumping_system.dao.JuryCompetitionRepository;
import com.lipskii.ski_jumping_system.entity.JuryCompetition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JuryCompetitionService implements ServiceInterface {

    private final JuryCompetitionRepository juryCompetitionRepository;

    @Autowired
    public JuryCompetitionService(JuryCompetitionRepository juryCompetitionRepository) {
        this.juryCompetitionRepository = juryCompetitionRepository;
    }

    @Override
    public List<JuryCompetition> findAll() {
        return juryCompetitionRepository.findAll();
    }

    @Override
    public Optional<JuryCompetition> findById(int id) {
        return juryCompetitionRepository.findById(id);
    }

    @Override
    public JuryCompetition save(Object obj) {
        return juryCompetitionRepository.save((JuryCompetition) obj);
    }

    @Override
    public void deleteById(int id) {
        juryCompetitionRepository.deleteById(id);
    }
}
