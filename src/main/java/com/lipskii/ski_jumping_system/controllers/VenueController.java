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
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.*;


@CrossOrigin(origins = "*")
@RequestMapping("/api/venues")
@org.springframework.web.bind.annotation.RestController
public class VenueController {

    private final VenueService venueService;


    @Autowired
    public VenueController(VenueService venueService) {
        this.venueService = venueService;
    }


    @Transactional
    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<Venue> getVenues(
            @Join(path = "hills", alias = "o")
            @And({
                    @Spec(path = "id", params = "id", spec = Equal.class),
                    @Spec(path = "skiClub.id", params = "skiClubId", spec = Equal.class),
                    @Spec(path = "city.region.country.id", params = "countryId", spec = Equal.class),
                    @Spec(path = "city.id", params = "cityId", spec = Equal.class),
                    @Spec(path = "o", params = "hasHills", spec = NotNull.class),
            }) Specification<Venue> spec) {
        return venueService.get(spec, Sort.by("name"));
    }

    @PostMapping("")
    public Venue saveVenue(@RequestBody Venue venue) {
        venueService.save(venue);
        return venue;
    }

    @PutMapping("/{venueId}")
    public ResponseEntity<Venue> updateVenue(@RequestBody Venue venue, @PathVariable("venueId") int venueId) throws ResourceNotFoundException {

        if (venueService.findById(venueId).isPresent()) {
            venue.setId(venueId);
            venueService.save(venue);
        } else {
            throw new ResourceNotFoundException("No venue found for id: " + venueId);
        }

        return ResponseEntity.ok(venue);
    }

    @DeleteMapping("/{venueId}")
    public void deleteVenue(@PathVariable("venueId") int venueId) {
        venueService.deleteById(venueId);
    }


}
