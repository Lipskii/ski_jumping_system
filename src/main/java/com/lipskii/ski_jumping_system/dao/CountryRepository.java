package com.lipskii.ski_jumping_system.dao;

import com.lipskii.ski_jumping_system.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer>, JpaSpecificationExecutor<Country> {

    Country findByCode(String code);

}
