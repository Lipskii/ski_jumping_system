package com.lipskii.ski_jumping_system.dao;

import com.lipskii.ski_jumping_system.entity.Judge;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JudgeRepository extends JpaRepository<Judge,Integer> {
}
