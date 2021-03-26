package com.lipskii.ski_jumping_system.dao;

import com.lipskii.ski_jumping_system.entity.City;
import com.lipskii.ski_jumping_system.entity.Country;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City,Integer>, JpaSpecificationExecutor<City> {

    boolean existsCityByName(String name);

    List<City> findAllByRegionCountry(Country country);

    List<City> findAllByRegionCountryCodeOrderByName(String code);

    List<City> findAllByRegionCountryOrderByName(Country country);

    List<City> findAllByOrderByName();

    List<City> findAllByRegionCountryIdOrderByName(int countryId);

    List<City> findAllBySkiClubsNotNull(Specification<City> spec, Sort name);

    City findByName(String name);
}
