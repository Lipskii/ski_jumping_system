package com.lipskii.ski_jumping_system.dao;

import com.lipskii.ski_jumping_system.entity.Series;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeriesRepository extends JpaRepository<Series,Integer>, JpaSpecificationExecutor<Series> {
    List<Series> findAllByOrderByName();
}
