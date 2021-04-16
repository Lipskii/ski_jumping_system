package com.lipskii.ski_jumping_system.controllers;

import com.lipskii.ski_jumping_system.entity.Qualification;
import com.lipskii.ski_jumping_system.service.QualificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RequestMapping("/api/qualifications")
@RestController
public class QualificationController {

    private final QualificationService qualificationService;

    @Autowired
    public QualificationController(QualificationService qualificationService) {
        this.qualificationService = qualificationService;
    }

    @PostMapping("")
    public void uploadResultsLink(@RequestBody Qualification qualification){
       qualificationService.save(qualification);
    }
}
