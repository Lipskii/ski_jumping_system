package com.lipskii.ski_jumping_system.service;

import com.lipskii.ski_jumping_system.dao.VenueRepository;
import com.lipskii.ski_jumping_system.dto.SkisDTO;
import com.lipskii.ski_jumping_system.dto.VenueDTO;
import com.lipskii.ski_jumping_system.entity.Country;
import com.lipskii.ski_jumping_system.entity.Skis;
import com.lipskii.ski_jumping_system.entity.Venue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VenueService implements ServiceInterface {

    private final VenueRepository venueRepository;

    @Autowired
    public VenueService(VenueRepository venueRepository) {
        this.venueRepository = venueRepository;
    }

    @Override
    public List<VenueDTO> findAll() {
        return venueRepository.findAll().stream().map(this::convertToVenueDTO).collect(Collectors.toList());
    }

    public List<VenueDTO> findAllByCountryDTO(String country) {
        return venueRepository.findAllByCityRegionCountryNameOrderByName(country)
                .stream().map(this::convertToVenueDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<Venue> findById(int id) {
        return venueRepository.findById(id);
    }

    @Override
    public Venue save(Object obj) {
        return venueRepository.save((Venue) obj);
    }

    @Override
    public void deleteById(int id) {
        venueRepository.deleteById(id);
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

    private VenueDTO convertToVenueDTO(Venue venue) {
        VenueDTO venueDTO = new VenueDTO();
        venueDTO.setId(venue.getId());
        venueDTO.setName(venue.getName());
        venueDTO.setCity(venue.getCity().getName());
        venueDTO.setCityId(venue.getCity().getId());
        venueDTO.setRegion(venue.getCity().getRegion().getName());
        venueDTO.setRegionId(venue.getCity().getRegion().getId());
        venueDTO.setCountry(venue.getCity().getRegion().getCountry().getName());
        venueDTO.setCountryId(venue.getCity().getRegion().getCountry().getId());
        venueDTO.setSkiClub(venue.getSkiClub().getName());
        venueDTO.setSkiClubId(venue.getSkiClub().getId());
        venueDTO.setCapacity(venue.getCapacity());
        venueDTO.setYearOfOpening(venue.getYearOfOpening());

        return venueDTO;
    }
}
