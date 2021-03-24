package com.lipskii.ski_jumping_system.dao;

import com.lipskii.ski_jumping_system.entity.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultRepository extends JpaRepository<Result,Integer> {

    List<Result> findAllByCompetitionIdOrderByTotalRank(int competitionId);
}
