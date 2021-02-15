package com.lipskii.ski_jumping_system.dao;

import com.lipskii.ski_jumping_system.entity.Country;
import com.lipskii.ski_jumping_system.entity.Venue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VenueRepository extends JpaRepository<Venue,Integer> {

    List<Venue> findAllByCityRegionCountryNameOrderByName(String country);

    List<Venue> findAllByCityRegionCountry(Country country);
//    List<Venue> findAllByCityExists();

}
