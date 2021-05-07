package com.lipskii.ski_jumping_system.dao;

import com.lipskii.ski_jumping_system.entity.TeamResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamResultRepository extends JpaRepository<TeamResult,Integer>, JpaSpecificationExecutor<TeamResult> {

}
