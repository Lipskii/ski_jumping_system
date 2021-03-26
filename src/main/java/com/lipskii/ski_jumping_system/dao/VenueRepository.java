package com.lipskii.ski_jumping_system.dao;

import com.lipskii.ski_jumping_system.entity.City;
import com.lipskii.ski_jumping_system.entity.Country;
import com.lipskii.ski_jumping_system.entity.Venue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VenueRepository extends JpaRepository<Venue,Integer>, JpaSpecificationExecutor<Venue> {

    List<Venue> findAllByCityRegionCountry(Country country);

    List<Venue> findAllByCityRegionCountryIdOrderByName(int countryId);

    List<Venue> findAllByCityIdOrderByName(int cityId);

    List<Venue> findAllByOrderByName();

    List<Venue> findAllByCityOrderByName(City city);


}
