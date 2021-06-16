package com.lipskii.ski_jumping_system.controllers;


import com.lipskii.ski_jumping_system.entity.*;
import com.lipskii.ski_jumping_system.service.*;
import net.kaczmarzyk.spring.data.jpa.domain.*;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Join;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.*;


@CrossOrigin(origins = "*")
@RequestMapping("/api/countries")
@org.springframework.web.bind.annotation.RestController
public class CountryController {

    private final CountryService countryService;


    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }




    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<Country> getCountries(
            @Join(path = "people", alias = "o")
            @And({
                    @Spec(path = "id", params = "id", spec = Equal.class),
                    @Spec(path = "name", params = "name", spec = Equal.class),
                    @Spec(path = "code", params = "code", spec = Equal.class),
                    @Spec(path = "o", params = "hasPeople", spec = NotNull.class)
            }) Specification<Country> spec) {
        return countryService.get(spec, Sort.by("name"));
    }


    @GetMapping("/jury")
    public List<Country> getCountriesWithJury() {
        return countryService.findAllWithJury();
    }

    @GetMapping("/skiClubs")
    public List<Country> getCountriesWithSkiClubs() {
        return countryService.findAllWithSkiClubs();
    }

    @GetMapping("/skiJumpers")
    public List<Country> getCountriesWithSkiJumpers() {
        return countryService.findAllWithSkiJumpers();
    }

    @GetMapping("/venues")
    public List<Country> getCountriesWithVenues() {
        return countryService.findAllWithVenues();
    }

    @GetMapping("/venues/hills")
    public List<Country> getCountriesWithVenuesWithHills() {
        return countryService.findAllWithVenuesWithHills();
    }


}
