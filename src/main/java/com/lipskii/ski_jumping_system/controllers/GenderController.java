package com.lipskii.ski_jumping_system.controllers;


import com.lipskii.ski_jumping_system.entity.*;
import com.lipskii.ski_jumping_system.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;


@CrossOrigin(origins = "*")
@RequestMapping("/api/genders")
@org.springframework.web.bind.annotation.RestController
public class GenderController {

    private final GenderService genderService;


    @Autowired
    public GenderController(GenderService genderService) {
        this.genderService = genderService;
    }


    @GetMapping("")
    public List<Gender> getGenders() {
        return genderService.findAll();
    }

}
