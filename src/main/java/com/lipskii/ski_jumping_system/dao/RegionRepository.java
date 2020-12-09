package com.lipskii.ski_jumping_system.dao;

import com.lipskii.ski_jumping_system.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionRepository extends JpaRepository<Region,Integer> {
}
