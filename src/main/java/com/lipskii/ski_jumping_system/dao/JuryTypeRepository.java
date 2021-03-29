package com.lipskii.ski_jumping_system.dao;


import com.lipskii.ski_jumping_system.entity.JuryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JuryTypeRepository extends JpaRepository<JuryType,Integer> {

    List<JuryType> findAllByOrderByJuryType();
}
