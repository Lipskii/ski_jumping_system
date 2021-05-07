package com.lipskii.ski_jumping_system.service;

import com.lipskii.ski_jumping_system.dao.VenueRepository;
import com.lipskii.ski_jumping_system.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class VenueService implements ServiceInterface {

    private final VenueRepository venueRepository;
    private final HillService hillService;

    @Autowired
    public VenueService(VenueRepository venueRepository, HillService hillService) {
        this.venueRepository = venueRepository;
        this.hillService = hillService;
    }

    @Override
    public List<Venue> findAll() {
        return venueRepository.findAllByOrderByName();
    }

    public List<Venue> get(Specification<Venue> spec, Sort sort) {
        return venueRepository.findAll(spec, sort);
    }


    public List<Venue> findAllWithHills() {
        List<Venue> venues = venueRepository.findAllByOrderByName();
        venues.removeIf(venue -> hillService.findAllByVenueId(venue.getId()).isEmpty());
        return venues;
    }


    public List<Venue> findAllByCountry(int id) {
        return venueRepository.findAllByCityRegionCountryIdOrderByName(id);
    }


    @Override
    public Optional<Venue> findById(int id) {
        return venueRepository.findById(id);
    }

    public List<Venue> findAllByCity(City city) {
        return venueRepository.findAllByCityOrderByName(city);
    }

    @Override
    public Venue save(Object obj) {
        return venueRepository.save((Venue) obj);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        Venue venue = venueRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("venue does not exist!"));
        System.out.println(venue);
        venueRepository.delete(venue);
    }


    List<Venue> findAllByCountry(Country country) {
        return venueRepository.findAllByCityRegionCountry(country);
    }


    public void delete(Venue venue) {
        venueRepository.delete(venue);
    }

    public Venue updateVenue(int venueId, Venue venue) {
        if (venueRepository.findById(venueId).isPresent()) {
            venue.setId(venueId);
            venueRepository.save(venue);
        } else {
            throw new ResourceNotFoundException("No venue found for id: " + venueId);
        }

        return venue;
    }
}
