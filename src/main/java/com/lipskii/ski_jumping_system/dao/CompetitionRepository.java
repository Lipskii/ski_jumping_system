package com.lipskii.ski_jumping_system.dao;

import com.lipskii.ski_jumping_system.entity.Competition;
import com.lipskii.ski_jumping_system.entity.Hill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompetitionRepository extends JpaRepository<Competition,Integer>, JpaSpecificationExecutor<Competition> {
    List<Competition> findAllByOrderByDate1Desc();

    List<Competition> findAllBySeriesMajorIdOrderByDate1Desc(int seriesId);

    List<Competition> findAllByHillVersionHillOrderByDate1Desc(Hill hill);

    List<Competition> findAllBySeriesMajorIdAndHillVersionHillOrderByDate1Desc(int seriesId, Hill hill);

    List<Competition> findAllBySeasonId(int seasonId);

}
