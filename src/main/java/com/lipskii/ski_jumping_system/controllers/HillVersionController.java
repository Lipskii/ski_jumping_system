package com.lipskii.ski_jumping_system.controllers;

import com.lipskii.ski_jumping_system.entity.Hill;
import com.lipskii.ski_jumping_system.entity.HillVersion;
import com.lipskii.ski_jumping_system.service.HillService;
import com.lipskii.ski_jumping_system.service.HillVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "*")
@RequestMapping("/api/hillVersions")
@RestController
public class HillVersionController {

    private final HillVersionService hillVersionService;

    @Autowired
    public HillVersionController(HillVersionService hillVersionService) {
        this.hillVersionService = hillVersionService;
    }

    @GetMapping("")
    public List<HillVersion> getHillVersions() {
        return hillVersionService.findAll();
    }


    @PostMapping("")
    public HillVersion addHillVersion(@RequestBody HillVersion hillVersion) {
        System.out.println(hillVersion);
        hillVersionService.save(hillVersion);
        return hillVersion;
    }

}
