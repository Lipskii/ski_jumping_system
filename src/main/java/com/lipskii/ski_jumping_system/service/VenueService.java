package com.lipskii.ski_jumping_system.service;

import com.lipskii.ski_jumping_system.dao.VenueRepository;
import com.lipskii.ski_jumping_system.dto.VenueDTO;
import com.lipskii.ski_jumping_system.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<Venue> get(Specification<Venue> spec, Sort sort){
        return venueRepository.findAll(spec,sort);
    }


    public List<VenueDTO> findAllDTO() {
        return venueRepository.findAllByOrderByName()
                .stream()
                .map(this::convertToVenueDTO).collect(Collectors.toList());
    }

    public List<VenueDTO> findAllWithHillsDTO(){
        List<VenueDTO> venues = venueRepository.findAllByOrderByName().stream().map(this::convertToVenueDTO).collect(Collectors.toList());
        venues.removeIf(venue -> hillService.findAllByVenueId(venue.getId()).isEmpty());
        return venues;
    }

    public List<VenueDTO> findAllByCountryDTO(int id) {
        return venueRepository.findAllByCityRegionCountryIdOrderByName(id)
                .stream().map(this::convertToVenueDTO)
                .collect(Collectors.toList());
    }

    public List<Venue> findAllByCountry(int id) {
        return venueRepository.findAllByCityRegionCountryIdOrderByName(id);
    }


    @Override
    public Optional<Venue> findById(int id) {
        return venueRepository.findById(id);
    }

    public List<VenueDTO> getVenuesByCity(int cityId) {
        return venueRepository.findAllByCityIdOrderByName(cityId).stream().map(this::convertToVenueDTO).collect(Collectors.toList());
    }

    public List<Venue> findAllByCity(City city){
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

    @Transactional
    public boolean deleteByIdBool(int id) {
        if(venueRepository.existsById(id)){

            venueRepository.deleteById(id);
           // return true;
        }
        //return false;

        return !venueRepository.existsById(id);
    }


    List<Venue> findAllByCountry(Country country){
        return venueRepository.findAllByCityRegionCountry(country);
    }

    private VenueDTO convertToVenueDTO(Venue venue){
        VenueDTO venueDTO = new VenueDTO();
        venueDTO.setId(venue.getId());
        venueDTO.setName(venue.getName());
        venueDTO.setYearOfOpening(venue.getYearOfOpening());
        venueDTO.setCapacity(venue.getCapacity());
        venueDTO.setHills(venue.getHills());
        venueDTO.setSkiClub(venue.getSkiClub());
        venueDTO.setCity(venue.getCity());
        venueDTO.setCountry(venue.getCity().getRegion().getCountry());
        return venueDTO;
    }


    public void delete(Venue venue) {
        venueRepository.delete(venue);
    }
}
