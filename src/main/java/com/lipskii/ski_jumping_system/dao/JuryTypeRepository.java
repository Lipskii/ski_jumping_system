package com.lipskii.ski_jumping_system.dao;


import com.lipskii.ski_jumping_system.entity.JuryType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JuryTypeRepository extends CrudRepository<JuryType,Integer> {
}
