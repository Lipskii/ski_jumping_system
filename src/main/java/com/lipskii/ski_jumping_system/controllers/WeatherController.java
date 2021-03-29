package com.lipskii.ski_jumping_system.controllers;


import com.lipskii.ski_jumping_system.entity.*;
import com.lipskii.ski_jumping_system.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@CrossOrigin(origins = "*")
@RequestMapping("/api/weather")
@org.springframework.web.bind.annotation.RestController
public class WeatherController {

    private final WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("")
    public List<Weather> getWeather() {
        return weatherService.findAll();
    }

}
