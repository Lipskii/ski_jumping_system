package com.lipskii.ski_jumping_system.service;

import com.lipskii.ski_jumping_system.dao.CountryRepository;
import com.lipskii.ski_jumping_system.dto.CountryWithVenuesDTO;
import com.lipskii.ski_jumping_system.dto.VenueDTO;
import com.lipskii.ski_jumping_system.entity.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CountryService implements ServiceInterface {

    private final CountryRepository countryRepository;
    private final VenueService venueService;

    private final SkiClubService skiClubService;
    private final SkiJumperService skiJumperService;
    private final JuryService juryService;


    @Autowired
    public CountryService(CountryRepository countryRepository,
                          VenueService venueService,
                          SkiClubService skiClubService,
                          SkiJumperService skiJumperService,
                          JuryService juryService) {
        this.countryRepository = countryRepository;
        this.venueService = venueService;
        this.juryService = juryService;
        this.skiClubService = skiClubService;
        this.skiJumperService = skiJumperService;
    }

    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    public List<Country> get(Specification<Country> spec, Sort sort){
        return countryRepository.findAll(spec,sort);
    }

    @Override
    public Optional<Country> findById(int id) {
        return countryRepository.findById(id);
    }

    @Override
    public Country save(Object obj) {
        return countryRepository.save((Country) obj);
    }

    @Override
    public void deleteById(int id) {
        countryRepository.deleteById(id);
    }

    public List<Country> findAllWithVenues() {
        List<Country> countries = countryRepository.findAll();
        countries.removeIf(country -> venueService.findAllByCountry(country).isEmpty());
        return countries;
    }

    public List<Country> findAllWithVenuesWithHills(){
        List<Country> countries = new ArrayList<>();
        List<VenueDTO> venueDTOS = venueService.findAllWithHillsDTO();
        for(VenueDTO venueDTO : venueDTOS){
            countries.add(venueDTO.getCountry());
        }
     //   countries =;
        return  countries.stream().distinct().collect(Collectors.toList());
    }

    public List<Country> findAllWithJury() {
        List<Country> countries = countryRepository.findAll();
        countries.removeIf(country -> juryService.findAllByCountry(country).isEmpty());
        return countries;
    }

    public List<Country> findAllWithSkiClubs() {
        List<Country> countries = countryRepository.findAll();
        countries.removeIf(country -> skiClubService.findAllByCountry(country).isEmpty());
        return countries;
    }


    public List<Country> findAllWithSkiJumpers() {
        List<Country> countries = countryRepository.findAll();
        countries.removeIf(country -> skiJumperService.findAllByCountry(country).isEmpty());
        return countries;
    }



}
