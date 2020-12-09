package com.lipskii.ski_jumping_system.dao;

import com.lipskii.ski_jumping_system.entity.SkiJumper;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkiJumperRepository extends JpaRepository<SkiJumper,Integer> {
}
