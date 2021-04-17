package com.lipskii.ski_jumping_system.dao;

import com.lipskii.ski_jumping_system.entity.OverallStanding;
import com.lipskii.ski_jumping_system.entity.Series;
import com.lipskii.ski_jumping_system.entity.SkiJumper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface OverallStandingRepository extends JpaRepository<OverallStanding,Integer>, JpaSpecificationExecutor<OverallStanding> {

    OverallStanding findBySeasonSeasonAndSeriesAndSkiJumper(int season, Series series, SkiJumper skiJumper);

}
