package com.lipskii.ski_jumping_system.controllers;

import com.lipskii.ski_jumping_system.entity.*;
import com.lipskii.ski_jumping_system.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;


@CrossOrigin(origins = "*")
@RequestMapping("/api/results")
@org.springframework.web.bind.annotation.RestController
public class ResultController {

    private final CompetitionService competitionService;
    private final ResultService resultService;


    @Autowired
    public ResultController(CompetitionService competitionService, ResultService resultService) {
        this.competitionService = competitionService;
        this.resultService = resultService;
    }

    @GetMapping("/{competitionId}")
    public List<Result> getResultsByCompetitionId(@PathVariable("competitionId") int competitionId) {
        return resultService.findAllByCompetitionId(competitionId);
    }

    @PostMapping(value = "/files/csv/{competitionId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity uploadResultsCsv(@RequestPart("csv") MultipartFile csvFile,
                                           //@RequestPart("pdf") MultipartFile pdfFile,
                                           @PathVariable("competitionId") int competitionId)
            throws ResourceNotFoundException {
        Competition competition = competitionService
                .findById(competitionId)
                .orElseThrow(() -> new ResourceNotFoundException("no competition found for id = " + competitionId));

        try {
            competitionService.assignFiles(csvFile, competition, competitionId);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok().build();
    }

}
