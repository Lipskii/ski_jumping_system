package com.lipskii.ski_jumping_system.dao;

import com.lipskii.ski_jumping_system.entity.OverallStandings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface OverallStandingsRepository extends JpaRepository<OverallStandings,Integer>, JpaSpecificationExecutor<OverallStandings> {
}
