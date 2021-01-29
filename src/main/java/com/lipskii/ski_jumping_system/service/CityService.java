package com.lipskii.ski_jumping_system.service;

import com.lipskii.ski_jumping_system.dao.CityRepository;
import com.lipskii.ski_jumping_system.dto.CityDTO;
import com.lipskii.ski_jumping_system.dto.CountryDTO;
import com.lipskii.ski_jumping_system.entity.City;
import com.lipskii.ski_jumping_system.entity.Country;
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
    protected final Logger log = Logger.getLogger(getClass().getName());

    @Autowired
    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
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
    public void save(Object obj) {

        cityRepository.save((City) obj);
        log.log(Level.INFO,"City: " + obj.toString() + " saved");
    }

    public List<City> findCitiesByCountry(String code){
        return cityRepository.findAllByRegionCountryCode(code);
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
