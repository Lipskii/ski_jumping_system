package com.lipskii.ski_jumping_system.service;

import com.lipskii.ski_jumping_system.dao.CountryRepository;
import com.lipskii.ski_jumping_system.dto.CountryWithVenuesDTO;
import com.lipskii.ski_jumping_system.entity.Country;
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
    private final CityService cityService;
    protected final Logger log = Logger.getLogger(getClass().getName());

    @Autowired
    public CountryService(CountryRepository countryRepository, VenueService venueService, CityService cityService) {
        this.countryRepository = countryRepository;
        this.venueService = venueService;
        this.cityService = cityService;
    }

    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }



    @Override
    public Optional<Country> findById(int id) {
        return countryRepository.findById(id);
    }

    @Override
    public Country save(Object obj) {
       return countryRepository.save((Country) obj);
    }

    public Country savee(Country country) {
        return countryRepository.save(country);
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

    public List<CountryWithVenuesDTO> findAllWithVenues(){
        List<Country> countries = countryRepository.findAll();
        countries.removeIf(country -> venueService.findAllByCountry(country).isEmpty());

        return countries.stream().map(this::convertToCountryWithVenuesDTO).collect(Collectors.toList());
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

    private CountryWithVenuesDTO convertToCountryWithVenuesDTO(Country country){
        CountryWithVenuesDTO countryWithVenuesDTO = new CountryWithVenuesDTO();
        countryWithVenuesDTO.setId(country.getId());
        countryWithVenuesDTO.setName(country.getName());
        countryWithVenuesDTO.setCode(country.getCode());
        countryWithVenuesDTO.setVenues(venueService.findAllByCountry(country.getId()));
        countryWithVenuesDTO.setCities(cityService.findCitiesByCountry(country));
        return countryWithVenuesDTO;
    }



}
