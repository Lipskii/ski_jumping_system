package com.lipskii.ski_jumping_system.dao;

import com.lipskii.ski_jumping_system.entity.Season;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeasonRepository extends JpaRepository<Season,Integer> {

    List<Season> findAllByOrderBySeasonDesc();
}
