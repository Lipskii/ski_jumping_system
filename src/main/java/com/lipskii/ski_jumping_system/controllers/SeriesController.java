package com.lipskii.ski_jumping_system.controllers;


import com.lipskii.ski_jumping_system.entity.*;
import com.lipskii.ski_jumping_system.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@CrossOrigin(origins = "*")
@RequestMapping("/api/series")
@org.springframework.web.bind.annotation.RestController
public class SeriesController {

    private final SeriesService seriesService;

    @Autowired
    public SeriesController(SeriesService seriesService) {
        this.seriesService = seriesService;
    }

    @GetMapping("")
    public List<Series> getSeries() {
        return seriesService.findAll();
    }

}
