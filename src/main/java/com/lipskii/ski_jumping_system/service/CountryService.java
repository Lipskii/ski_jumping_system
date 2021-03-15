package com.lipskii.ski_jumping_system.service;

import com.lipskii.ski_jumping_system.dao.CountryRepository;
import com.lipskii.ski_jumping_system.dto.CountryWithVenuesDTO;
import com.lipskii.ski_jumping_system.entity.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CountryService implements ServiceInterface {

    private final CountryRepository countryRepository;
    private final VenueService venueService;
    private final CityService cityService;
    private final PersonService personService;
    private final SkiClubService skiClubService;
    private final SkiJumperService skiJumperService;
    private final JuryService juryService;

    @Autowired
    public CountryService(CountryRepository countryRepository,
                          VenueService venueService,
                          CityService cityService,
                          PersonService personService,
                          SkiClubService skiClubService,
                          SkiJumperService skiJumperService,
                          JuryService juryService) {
        this.countryRepository = countryRepository;
        this.venueService = venueService;
        this.cityService = cityService;
        this.juryService = juryService;
        this.skiClubService = skiClubService;
        this.skiJumperService = skiJumperService;
        this.personService = personService;
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

    @Override
    public void deleteById(int id) {
        countryRepository.deleteById(id);
    }

    public List<Country> findAllWithVenues() {
        List<Country> countries = countryRepository.findAll();
        countries.removeIf(country -> venueService.findAllByCountry(country).isEmpty());
        return countries;
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

    public List<Country> findAllWithPeople() {
        List<Country> countries = countryRepository.findAll();
        countries.removeIf(country -> personService.findAllByCountry(country).isEmpty());
        return countries;
    }

    public List<Country> findAllWithSkiJumpers() {
        List<Country> countries = countryRepository.findAll();
        countries.removeIf(country -> skiJumperService.findAllByCountry(country).isEmpty());
        return countries;
    }

    public Country findFirstById() {
        return countryRepository.findFirstByIdGreaterThan(-1);
    }

    public Country findCountryByCode(String code) {
        return countryRepository.findCountryByCode(code);
    }

    public Country findCountryByName(String name) {
        return countryRepository.findCountryByName(name);
    }

    private CountryWithVenuesDTO convertToCountryWithVenuesDTO(Country country) {
        CountryWithVenuesDTO countryWithVenuesDTO = new CountryWithVenuesDTO();
        countryWithVenuesDTO.setId(country.getId());
        countryWithVenuesDTO.setName(country.getName());
        countryWithVenuesDTO.setCode(country.getCode());
        countryWithVenuesDTO.setVenues(venueService.findAllByCountry(country.getId()));
        countryWithVenuesDTO.setCities(cityService.findCitiesByCountry(country));
        return countryWithVenuesDTO;
    }



}
