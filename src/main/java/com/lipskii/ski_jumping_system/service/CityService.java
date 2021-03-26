package com.lipskii.ski_jumping_system.service;

import com.lipskii.ski_jumping_system.dao.CityRepository;

import com.lipskii.ski_jumping_system.entity.City;
import com.lipskii.ski_jumping_system.entity.Country;
import com.lipskii.ski_jumping_system.entity.SkiJumper;
import com.lipskii.ski_jumping_system.entity.Venue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
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
    private final SkiClubService skiClubService;
    private final SkiJumperService skiJumperService;

    @Autowired
    public CityService(CityRepository cityRepository, VenueService venueService, SkiClubService skiClubService, SkiJumperService skiJumperService) {
        this.cityRepository = cityRepository;
        this.venueService = venueService;
        this.skiClubService = skiClubService;
        this.skiJumperService = skiJumperService;
    }


    @Override
    public List<City> findAll() {
        return cityRepository.findAll();
    }

    public List<City> get(Specification<City> spec, Sort sort) {
        return cityRepository.findAll(spec, sort);
    }

    @Override
    public Optional<City> findById(int id) {
        return cityRepository.findById(id);
    }

    public List<City> findAllWithSkiClubs(){
        List<City> cities = cityRepository.findAllByOrderByName();
        cities.removeIf(city -> skiClubService.findAllByCity(city).isEmpty());
        return cities;
    }

    @Override
    public City save(Object obj) {
        return cityRepository.save((City) obj);
    }

    public List<City> findCitiesByCountry(Country country){
        return cityRepository.findAllByRegionCountry(country);
    }

    @Override
    public void deleteById(int id) {
        cityRepository.deleteById(id);
    }

}
