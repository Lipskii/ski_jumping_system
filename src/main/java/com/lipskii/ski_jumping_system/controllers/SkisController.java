package com.lipskii.ski_jumping_system.controllers;


import com.lipskii.ski_jumping_system.entity.*;
import com.lipskii.ski_jumping_system.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;


@CrossOrigin(origins = "*")
@RequestMapping("/api/skis")
@org.springframework.web.bind.annotation.RestController
public class SkisController {

    private final SkisService skisService;

    @Autowired
    public SkisController(SkisService skisService) {
        this.skisService = skisService;
    }

    @GetMapping("")
    public List<Skis> getSkis() {
        return skisService.findAll();
    }


}
