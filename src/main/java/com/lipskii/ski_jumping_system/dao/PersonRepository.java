package com.lipskii.ski_jumping_system.dao;

import com.lipskii.ski_jumping_system.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person,Integer> {

    List<Person> findAllByOrderByLastNameAsc();
}
