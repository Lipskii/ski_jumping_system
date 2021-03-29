package com.lipskii.ski_jumping_system.controllers;

import com.lipskii.ski_jumping_system.entity.*;
import com.lipskii.ski_jumping_system.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@CrossOrigin(origins = "*")
@RequestMapping("/api/sizeOfHill")
@org.springframework.web.bind.annotation.RestController
public class SizeOfHillController {

    private final SizeOfHillService sizeOfHillService;


    @Autowired
    public SizeOfHillController(SizeOfHillService sizeOfHillService) {
        this.sizeOfHillService = sizeOfHillService;
    }


    @GetMapping("")
    public List<SizeOfHill> getSizesOfHil() {
        return sizeOfHillService.findAll();
    }

}

