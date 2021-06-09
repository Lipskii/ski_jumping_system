package com.lipskii.ski_jumping_system.dao;

import com.lipskii.ski_jumping_system.entity.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ResultRepository extends JpaRepository<Result,Integer>, JpaSpecificationExecutor<Result> {

    List<Result> findAllByCompetitionIdOrderByTotalRank(int competitionId);

    List<Result> findAllByCompetitionHillVersionIdAndCompetitionSeriesMajorId(int hillVersionId, int seriesMajorId);

}

