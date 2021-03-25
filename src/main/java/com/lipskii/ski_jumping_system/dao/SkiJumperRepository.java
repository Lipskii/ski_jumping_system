package com.lipskii.ski_jumping_system.dao;

import com.lipskii.ski_jumping_system.entity.City;
import com.lipskii.ski_jumping_system.entity.Country;
import com.lipskii.ski_jumping_system.entity.SkiJumper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkiJumperRepository extends JpaRepository<SkiJumper,Integer>, JpaSpecificationExecutor<SkiJumper> {

    List<SkiJumper> findAllByPersonCountryName(String country);

    List<SkiJumper> findAllByPersonCityOrderByPerson(City city);

    List<SkiJumper> findAllByPersonCountryOrderByPerson(Country country);

    List<SkiJumper> findAllByPersonCountryId(int countryId);

    List<SkiJumper> findAllByPersonCityId(int cityId);
}
