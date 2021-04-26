package com.lipskii.ski_jumping_system.dao;

import com.lipskii.ski_jumping_system.entity.Result;
import com.lipskii.ski_jumping_system.entity.TeamResultIndividual;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamResultIndividualRepository extends JpaRepository<TeamResultIndividual,Integer>, JpaSpecificationExecutor<TeamResultIndividual> {
    List<TeamResultIndividual> findAllByTeamResultId(int teamResultId);
    List<TeamResultIndividual> findAllByTeamResultCompetitionHillVersionIdAndTeamResultCompetitionSeriesMajorId(int hillVersionId, int seriesMajorId);
}
