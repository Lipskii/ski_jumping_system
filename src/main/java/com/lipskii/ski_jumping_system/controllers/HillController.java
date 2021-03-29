package com.lipskii.ski_jumping_system.controllers;

import com.lipskii.ski_jumping_system.entity.*;
import com.lipskii.ski_jumping_system.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("")
    public List<Hill> getHills() {
        return hillService.findAll();
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
    public ResponseEntity<Hill> updateHill(@PathVariable("hillId") int hillId, @RequestBody Hill requestHill) throws ResourceNotFoundException {

        if (hillService.findById(hillId).isPresent()) {
            requestHill.setId(hillId);
            hillService.save(requestHill);
        } else {
            throw new ResourceNotFoundException("No hill found for id: " + hillId);
        }

        return ResponseEntity.ok(requestHill);
    }

    @GetMapping("/{venueId}")
    public List<Hill> getHillsByVenue(@PathVariable("venueId") int venueId) {
        return hillService.findAllByVenueId(venueId);
    }

}
