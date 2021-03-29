package com.lipskii.ski_jumping_system.service;

import com.lipskii.ski_jumping_system.dao.PersonRepository;
import com.lipskii.ski_jumping_system.entity.Country;
import com.lipskii.ski_jumping_system.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class PersonService implements ServiceInterface {

    private final PersonRepository personRepository;
    protected final Logger log = Logger.getLogger(getClass().getName());

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public List<Person> get(Specification<Person> spec, Sort sort){
        return personRepository.findAll(spec,sort);
    }

    public List<Person> findAllOrderedByLastName(){
        return personRepository.findAllByOrderByLastNameAsc();
    }

    public List<Person> findAllByCountryId(int countryId){
        return personRepository.findAllByCountryIdOrderByLastName(countryId);
    }

    public List<Person> findAllByCountry(Country country){
        return personRepository.findAllByCountry(country);
    }

    @Override
    public Optional<Person> findById(int id) {
        return personRepository.findById(id);
    }

    @Override
    public Person save(Object obj) {
        return personRepository.save((Person) obj);
    }

    @Override
    public void deleteById(int id) {
        personRepository.deleteById(id);
    }

    public HashMap<String,Person> getPeopleMap(){

        HashMap<String,Person> map = new HashMap<>();
        List<Person> list = findAll();

        for (Person person : list)
            map.put(person.toString(),person);

        return map;
    }

    public void addPeopleIfNotExist(List<Person> people){
        HashMap<String,Person> map =  getPeopleMap();

        for(Person person : people){
            if(!map.containsKey(person.toString())){
                save(person);
            } else {
                log.log(Level.INFO,"Person: " + person + " already exists in db");
            }
        }
    }
}
