package com.lipskii.ski_jumping_system.dao;


import com.lipskii.ski_jumping_system.entity.JuryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface JuryTypeRepository extends CrudRepository<JuryType,Integer> {
}
