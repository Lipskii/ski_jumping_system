package com.lipskii.ski_jumping_system.controllers;


import com.lipskii.ski_jumping_system.entity.*;
import com.lipskii.ski_jumping_system.service.*;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.domain.NotNull;
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
import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping("/api/cities")
@org.springframework.web.bind.annotation.RestController
public class CityController {

    private final CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @Transactional
    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<City> getCities(
            @Join(path = "people", alias = "o")
            @And({
                    @Spec(path = "id", params = "id", spec = Equal.class),
                    @Spec(path = "name", params = "name", spec = Equal.class),
                    @Spec(path = "region.id", params = "regionId", spec = Equal.class),
                    @Spec(path = "region.country.id", params = "countryId", spec = Equal.class),
                    @Spec(path = "o", params = "hasPeople", spec = NotNull.class)
            }) Specification<City> spec) {
        return cityService.get(spec, Sort.by("name"));
    }

    @GetMapping("/skiClubs")
    public List<City> getCitiesWithSkiClubs() {
        return cityService.findAllWithSkiClubs();
    }

    @PostMapping("")
    public City addCity(@RequestBody City city) {
        cityService.save(city);
        return city;
    }

}


