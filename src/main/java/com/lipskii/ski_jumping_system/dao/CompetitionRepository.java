package com.lipskii.ski_jumping_system.dao;

import com.lipskii.ski_jumping_system.entity.Competition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompetitionRepository extends JpaRepository<Competition,Integer> {
}
