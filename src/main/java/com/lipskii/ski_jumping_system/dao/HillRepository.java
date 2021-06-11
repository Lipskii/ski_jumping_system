package com.lipskii.ski_jumping_system.dao;

import com.lipskii.ski_jumping_system.entity.Hill;
import com.lipskii.ski_jumping_system.entity.Venue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface HillRepository extends JpaRepository<Hill,Integer>, JpaSpecificationExecutor<Hill> {

    List<Hill> findAllByVenue(Venue venue);

    @Transactional
    @Modifying
    @Query(value = "delete from Hill h where h.id = :id ")
    void deleteHillById(@Param("id") int id);
}


