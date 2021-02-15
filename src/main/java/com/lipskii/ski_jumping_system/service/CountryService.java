package com.lipskii.ski_jumping_system.service;

import com.lipskii.ski_jumping_system.dao.CountryRepository;
import com.lipskii.ski_jumping_system.dto.CountryDTO;
import com.lipskii.ski_jumping_system.dto.VenueDTO;
import com.lipskii.ski_jumping_system.entity.City;
import com.lipskii.ski_jumping_system.entity.Country;
import com.lipskii.ski_jumping_system.entity.Region;
import com.lipskii.ski_jumping_system.entity.Venue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class CountryService implements ServiceInterface {

    private final CountryRepository countryRepository;
    private final VenueService venueService;
    protected final Logger log = Logger.getLogger(getClass().getName());

    @Autowired
    public CountryService(CountryRepository countryRepository, VenueService venueService) {
        this.countryRepository = countryRepository;
        this.venueService = venueService;
    }

    @Override
    public List<Country> findAll() {
        return (List<Country>) countryRepository.findAll();
    }

    public List<CountryDTO> findAllDTO(){
        return countryRepository.findAll().stream().map(this::convertToCountryDTO).collect(Collectors.toList());
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

    public List<CountryDTO> findAllWithVenues(){
        List<Country> countries = countryRepository.findAll();
        countries.removeIf(country -> venueService.findAllByCountry(country).isEmpty());
        return countries.stream().map(this::convertToCountryDTO).collect(Collectors.toList());
    }

    public Country findFirstById(){
        return countryRepository.findFirstByIdGreaterThan(-1);
    }

    public Country findCountryByCode(String code){
        return countryRepository.findCountryByCode(code);
    }

    public Country findCountryByName(String name){
        return countryRepository.findCountryByName(name);
    }

    private CountryDTO convertToCountryDTO(Country country) {
        CountryDTO countryDTO = new CountryDTO();
        countryDTO.setId(country.getId());
        countryDTO.setName(country.getName());
        countryDTO.setCode(country.getCode());
        return countryDTO;
    }
}
