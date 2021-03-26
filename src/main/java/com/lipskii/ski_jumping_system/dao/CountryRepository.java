package com.lipskii.ski_jumping_system.dao;

import com.lipskii.ski_jumping_system.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer>, JpaSpecificationExecutor<Country> {

    boolean existsCountryByName(String name);

    Country findFirstByIdGreaterThan(int id);

    Country findCountryByCode(String code);

    Country findCountryByName(String name);


}
