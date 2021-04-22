package com.lipskii.ski_jumping_system.dao;

import com.lipskii.ski_jumping_system.entity.Country;
import com.lipskii.ski_jumping_system.entity.SkiJumper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface SkiJumperRepository extends JpaRepository<SkiJumper,Integer>, JpaSpecificationExecutor<SkiJumper> {

    List<SkiJumper> findAllByPersonCountryOrderByPerson(Country country);

    SkiJumper findByFisCode(String code);

    @Transactional
    @Modifying
    @Query(value = "delete from SkiJumper s where s.id = :id ")
    void deleteSkiJumperById(@Param("id") int id);

}
