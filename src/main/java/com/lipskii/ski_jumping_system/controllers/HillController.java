package com.lipskii.ski_jumping_system.controllers;

import com.lipskii.ski_jumping_system.entity.*;
import com.lipskii.ski_jumping_system.service.*;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
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
@RequestMapping("/api/hills")
@org.springframework.web.bind.annotation.RestController
public class HillController {

    private final HillService hillService;


    @Autowired
    public HillController(HillService hillService) {
        this.hillService = hillService;
    }

    @Transactional
    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<Hill> getCompetitions(
            @And({
                    @Spec(path = "id", params = "id", spec = Equal.class),
                    @Spec(path = "venue.id", params = "venueId", spec = Equal.class),
                    @Spec(path = "venue.city.region.country.id", params = "countryId", spec = Equal.class),
                    @Spec(path = "venue.city.id", params = "cityId", spec = Equal.class),
                    @Spec(path = "sizeOfHill.id", params = "sizeOfHillId", spec = Equal.class),
            }) Specification<Hill> spec) {
        return hillService.get(spec, Sort.by(Sort.Direction.ASC, "name"));
    }

    @DeleteMapping("/{hillId}")
    public void deleteHill(@PathVariable("hillId") int hillId){
        hillService.deleteById(hillId);
    }

    @PostMapping("")
    public Hill addHill(@RequestBody Hill hill) {
        hillService.save(hill);
        return hill;
    }

    @PutMapping("/{hillId}")
    public Hill updateHill(@PathVariable("hillId") int hillId, @RequestBody Hill requestHill) {
        return hillService.updateHill(hillId,requestHill);
    }

    @GetMapping("/{venueId}")
    public List<Hill> getHillsByVenue(@PathVariable("venueId") int venueId) {
        return hillService.findAllByVenueId(venueId);
    }

}
