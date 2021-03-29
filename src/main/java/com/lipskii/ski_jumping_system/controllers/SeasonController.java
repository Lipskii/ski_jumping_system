package com.lipskii.ski_jumping_system.controllers;

import com.lipskii.ski_jumping_system.entity.*;
import com.lipskii.ski_jumping_system.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;


@CrossOrigin(origins = "*")
@RequestMapping("/api/seasons")
@org.springframework.web.bind.annotation.RestController
public class SeasonController {

    private final SeasonService seasonService;

    @Autowired
    public SeasonController(SeasonService seasonService) {
        this.seasonService = seasonService;
    }

    @GetMapping("")
    public List<Season> getSeasons() {
        return seasonService.findAll();
    }


}
