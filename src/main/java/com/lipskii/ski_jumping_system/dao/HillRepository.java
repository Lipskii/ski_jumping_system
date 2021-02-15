package com.lipskii.ski_jumping_system.dao;

import com.lipskii.ski_jumping_system.entity.Hill;
import com.lipskii.ski_jumping_system.entity.Venue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HillRepository extends JpaRepository<Hill,Integer> {

    List<Hill> findAllByVenue(Venue venue);
}
