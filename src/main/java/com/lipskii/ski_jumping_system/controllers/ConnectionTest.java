package com.lipskii.ski_jumping_system.controllers;

import com.lipskii.ski_jumping_system.service.CountryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ConnectionTest {

    private final CountryService countryService;

    public ConnectionTest(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/connection_test")
    public String connectionTest(){

        return "helloworld";
    }
}
