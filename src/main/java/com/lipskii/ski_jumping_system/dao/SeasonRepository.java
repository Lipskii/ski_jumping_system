package com.lipskii.ski_jumping_system.dao;

import com.lipskii.ski_jumping_system.entity.Season;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeasonRepository extends CrudRepository<Season,Integer> {
}
