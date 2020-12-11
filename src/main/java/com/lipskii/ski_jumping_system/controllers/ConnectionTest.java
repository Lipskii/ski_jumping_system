package com.lipskii.ski_jumping_system.controllers;

import com.lipskii.ski_jumping_system.service.CountryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ConnectionTest {

    private CountryService countryService;

    @GetMapping("/connection_test")
    public String connectionTest(){

        System.out.println(countryService.findAll());
        return "helloworld";

    }
}
