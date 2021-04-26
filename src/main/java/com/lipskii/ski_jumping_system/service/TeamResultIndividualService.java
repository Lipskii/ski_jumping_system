package com.lipskii.ski_jumping_system.service;

import com.lipskii.ski_jumping_system.dao.TeamResultIndividualRepository;
import com.lipskii.ski_jumping_system.entity.TeamResultIndividual;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class TeamResultIndividualService implements ServiceInterface {

    private TeamResultIndividualRepository teamResultIndividualRepository;

    @Autowired
    public TeamResultIndividualService(TeamResultIndividualRepository teamResultIndividualRepository) {
        this.teamResultIndividualRepository = teamResultIndividualRepository;
    }

    @Override
    public List<TeamResultIndividual> findAll() {
        return teamResultIndividualRepository.findAll();
    }

    public List<TeamResultIndividual> findAllByTeamResultId(int competitionId) {
        return teamResultIndividualRepository.findAllByTeamResultId(competitionId);
    }

    public List<TeamResultIndividual> findAllByHillVersionIdAndSeriesMajorId(int hillVersionId, int seriesMajorId) {
        return teamResultIndividualRepository.findAllByTeamResultCompetitionHillVersionIdAndTeamResultCompetitionSeriesMajorId(hillVersionId, seriesMajorId);
    }

    public List<TeamResultIndividual> get(Specification<TeamResultIndividual> spec, Sort sort) {
        return teamResultIndividualRepository.findAll(spec, sort);
    }

    @Override
    public Optional<TeamResultIndividual> findById(int id) {
        return teamResultIndividualRepository.findById(id);
    }

    @Transactional
    @Override
    public TeamResultIndividual save(Object obj) {
        return teamResultIndividualRepository.save((TeamResultIndividual) obj);
    }

    @Override
    public void deleteById(int id) {
        teamResultIndividualRepository.deleteById(id);
    }
}
