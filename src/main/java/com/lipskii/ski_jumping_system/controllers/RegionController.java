package com.lipskii.ski_jumping_system.controllers;


import com.lipskii.ski_jumping_system.entity.*;
import com.lipskii.ski_jumping_system.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;


@CrossOrigin(origins = "*")
@RequestMapping("/api/regions")
@org.springframework.web.bind.annotation.RestController
public class RegionController {

    private final RegionService regionService;

    @Autowired
    public RegionController(RegionService regionService) {
        this.regionService = regionService;
    }

    @GetMapping("")
    public List<Region> getRegions() {
        return regionService.findAllOrderByName();
    }

    @GetMapping("/country/{countryId}")
    public List<Region> getRegionsByCountry(@PathVariable("countryId") int countryId) {
        return regionService.getRegionsByCountry(countryId);
    }


}
