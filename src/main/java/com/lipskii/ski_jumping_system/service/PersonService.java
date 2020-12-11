package com.lipskii.ski_jumping_system.service;

import com.lipskii.ski_jumping_system.dao.PersonRepository;
import com.lipskii.ski_jumping_system.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService implements ServiceInterface {

    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public List<Person> findAllOrderedByLastName(){
        return personRepository.findAllByOrderByLastNameAsc();
    }

    @Override
    public Person findById(int id) {
        return null;
    }

    @Override
    public void save(Object obj) {
        personRepository.save((Person) obj);
    }

    @Override
    public void deleteById(int id) {
        personRepository.deleteById(id);
    }
}
