package com.lipskii.ski_jumping_system.controllers;

import com.lipskii.ski_jumping_system.entity.*;
import com.lipskii.ski_jumping_system.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;


@CrossOrigin(origins = "*")
@RequestMapping("/api/juryTypes")
@org.springframework.web.bind.annotation.RestController
public class JuryTypeController {

    private final JuryTypeService juryTypeService;


    @Autowired
    public JuryTypeController(JuryTypeService juryTypeService) {
        this.juryTypeService = juryTypeService;
    }

    @GetMapping("")
    public List<JuryType> getJuryTypes() {
        return juryTypeService.findAll();
    }

}
