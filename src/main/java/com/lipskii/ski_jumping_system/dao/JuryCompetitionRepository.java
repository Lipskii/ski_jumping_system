package com.lipskii.ski_jumping_system.dao;

import com.lipskii.ski_jumping_system.entity.JuryCompetition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JuryCompetitionRepository extends JpaRepository<JuryCompetition,Integer>  {
}
