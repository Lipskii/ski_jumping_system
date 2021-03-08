package com.lipskii.ski_jumping_system.dao;

import com.lipskii.ski_jumping_system.entity.City;
import com.lipskii.ski_jumping_system.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City,Integer> {

    boolean existsCityByName(String name);

    List<City> findAllByRegionCountry(Country country);

    List<City> findAllByRegionCountryCodeOrderByName(String code);

    List<City> findAllByRegionCountryOrderByName(Country country);

    List<City> findAllByOrderByName();

    List<City> findAllByRegionCountryIdOrderByName(int countryId);

    City findByName(String name);
}
