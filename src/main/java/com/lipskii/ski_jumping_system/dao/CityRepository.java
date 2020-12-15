package com.lipskii.ski_jumping_system.dao;

import com.lipskii.ski_jumping_system.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City,Integer> {

    boolean existsCityByName(String name);

}
