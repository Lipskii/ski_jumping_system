package com.lipskii.ski_jumping_system.service;

import com.lipskii.ski_jumping_system.dao.CityRepository;
import com.lipskii.ski_jumping_system.dto.CityDTO;
import com.lipskii.ski_jumping_system.entity.City;
import com.lipskii.ski_jumping_system.entity.Country;
import com.lipskii.ski_jumping_system.entity.Venue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class CityService implements ServiceInterface {

    private final CityRepository cityRepository;
    private final VenueService venueService;
    protected final Logger log = Logger.getLogger(getClass().getName());

    @Autowired
    public CityService(CityRepository cityRepository, VenueService venueService) {
        this.cityRepository = cityRepository;
        this.venueService = venueService;
    }

    @Override
    public List<City> findAll() {
        return cityRepository.findAll();
    }

    @Override
    public Optional<City> findById(int id) {
        return cityRepository.findById(id);
    }

    @Override
    public City save(Object obj) {
        return cityRepository.save((City) obj);
    }

    public List<City> findCitiesWithVenues(){
        List<City> cities = cityRepository.findAll();
        cities.removeIf(city -> venueService.findAllByCity(city).isEmpty());

        return cities;
    }

    public List<City> findCitiesByCountry(Country country){
        return cityRepository.findAllByRegionCountry(country);
    }

    public List<City> findCitiesByCountryOrderByName(String code){
        return cityRepository.findAllByRegionCountryCodeOrderByName(code);
    }

    @Override
    public void deleteById(int id) {
        cityRepository.deleteById(id);
    }

    public List<CityDTO> getCitiesByCountry(Country country){
        return cityRepository.findAllByRegionCountryOrderByName(country).stream().map(this::convertToCityDTO).collect(Collectors.toList());
    }

    public void saveIfNotExists(City city) {

        log.log(Level.INFO,"Checking if city: " + city + " exists in db");

        boolean exists = cityRepository.existsCityByName(city.getName());

        if(!exists){
            log.log(Level.INFO,"City: " + city + " does not exist in db");
            save(city);
            log.log(Level.INFO,"after saving: " + city);
        } else{
            log.log(Level.INFO,"City: " + city + " already exists in db");
        }
    }

    private CityDTO convertToCityDTO(City city) {
        CityDTO cityDTO = new CityDTO();
        cityDTO.setId(city.getId());
        cityDTO.setName(city.getName());
        cityDTO.setRegion(city.getRegion().getName());
        cityDTO.setCountry(city.getRegion().getCountry().getName());
        return cityDTO;
    }

    public City findCityByName(String cityName) {
        return cityRepository.findByName(cityName);
    }
}
