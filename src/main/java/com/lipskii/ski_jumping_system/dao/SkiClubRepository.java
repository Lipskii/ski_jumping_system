package com.lipskii.ski_jumping_system.dao;

import com.lipskii.ski_jumping_system.entity.Country;
import com.lipskii.ski_jumping_system.entity.SkiClub;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkiClubRepository extends JpaRepository<SkiClub,Integer> {

    List<SkiClub> findAllByCityRegionCountryCodeOrderByName(String code);

    List<SkiClub> findAllByCityRegionCountryOrderByName(Country country);

    List<SkiClub> findAllByCityRegionCountryIdOrderByName(int countryId);

    List<SkiClub> findAllByOrderByName();


}
