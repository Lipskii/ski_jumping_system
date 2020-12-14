package com.lipskii.ski_jumping_system.dao;

import com.lipskii.ski_jumping_system.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionRepository extends JpaRepository<Region,Integer> {
}
