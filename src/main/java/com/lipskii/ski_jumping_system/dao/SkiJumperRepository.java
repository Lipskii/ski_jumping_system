package com.lipskii.ski_jumping_system.dao;

import com.lipskii.ski_jumping_system.entity.SkiJumper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkiJumperRepository extends JpaRepository<SkiJumper,Integer> {

    List<SkiJumper> findAllByPersonCountryName(String country);
}
