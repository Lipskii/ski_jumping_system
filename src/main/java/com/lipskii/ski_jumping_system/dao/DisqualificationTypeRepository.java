package com.lipskii.ski_jumping_system.dao;

import com.lipskii.ski_jumping_system.entity.DisqualificationType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisqualificationTypeRepository extends CrudRepository<DisqualificationType, Integer> {
}
