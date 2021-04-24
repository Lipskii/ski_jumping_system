package com.lipskii.ski_jumping_system.dao;

import com.lipskii.ski_jumping_system.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamOverallStandingRepository extends JpaRepository<TeamOverallStanding,Integer>, JpaSpecificationExecutor<TeamOverallStanding> {
    TeamOverallStanding findBySeasonSeasonAndSeriesAndCountry(int season, Series series, Country country);

    List<TeamOverallStanding> findAllBySeasonSeasonAndSeriesOrderByPointsDesc(int season, Series series);
}
