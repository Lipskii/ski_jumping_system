package com.lipskii.ski_jumping_system.service;

import com.lipskii.ski_jumping_system.dao.CountryRepository;
import com.lipskii.ski_jumping_system.entity.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class CountryService implements ServiceInterface {

    private final CountryRepository countryRepository;
    protected final Logger log = Logger.getLogger(getClass().getName());

    @Autowired
    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> findAll() {
        return (List<Country>) countryRepository.findAll();
    }

    @Override
    public Optional<Country> findById(int id) {
        return countryRepository.findById(id);
    }

    @Override
    public void save(Object obj) {
        countryRepository.save((Country) obj);
    }

    public void saveIfNotExists(Country country){

        log.log(Level.INFO,"Checking if country: " + country + " exists in db");
        boolean exists = countryRepository.existsCountryByName(country.getName());

        if(!exists){
            log.log(Level.INFO,"Country: " + country + " does not exist in db");
            save(country);
        } else{
            log.log(Level.INFO,"Country: " + country + " already exists in db");
        }
    }

    @Override
    public void deleteById(int id) {
        countryRepository.deleteById(id);
    }

    public Country findFirstById(){
        return countryRepository.findFirstByIdGreaterThan(-1);
    }

    public Country findCountryByCode(String code){
        return countryRepository.findCountryByCode(code);
    }
}
