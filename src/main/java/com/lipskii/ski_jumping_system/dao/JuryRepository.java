package com.lipskii.ski_jumping_system.dao;

import com.lipskii.ski_jumping_system.entity.Country;
import com.lipskii.ski_jumping_system.entity.Jury;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JuryRepository extends JpaRepository<Jury,Integer>, JpaSpecificationExecutor<Jury> {
    List<Jury> findAllByPersonCountry(Country country);

    List<Jury> findAllByPersonCountryId(int countryId);

    List<Jury> findAllByJuryTypeId(int juryTypeId);
}
