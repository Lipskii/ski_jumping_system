package com.lipskii.ski_jumping_system.controllers;

import com.lipskii.ski_jumping_system.dto.HillRecordDTO;
import com.lipskii.ski_jumping_system.entity.*;
import com.lipskii.ski_jumping_system.service.*;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.domain.GreaterThanOrEqual;
import net.kaczmarzyk.spring.data.jpa.domain.LessThanOrEqual;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.*;


@CrossOrigin(origins = "*")
@RequestMapping("/api/results")
@org.springframework.web.bind.annotation.RestController
public class ResultController {

    private final ResultService resultService;


    @Autowired
    public ResultController( ResultService resultService) {
        this.resultService = resultService;
    }

    @Transactional
    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<Result> getResults(
            @And({
                    @Spec(path = "id", params = "id", spec = Equal.class),
                    @Spec(path = "skiJumper.id", params = "skiJumperId", spec = Equal.class),
                    @Spec(path = "competition.season.id", params = "seasonId", spec = Equal.class),
                    @Spec(path = "competition.season.season", params = "season", spec = Equal.class),
                    @Spec(path = "competition.hillVersion.hill.venue.city.region.country.id", params = "countryId", spec = Equal.class),
                    @Spec(path = "competition.seriesMajor.id", params = "seriesMajorId", spec = Equal.class),
                    @Spec(path = "competition.seriesMinor.id", params = "seriesMinorId", spec = Equal.class),
                    @Spec(path = "competition.hillVersion..id", params = "hillVersionId", spec = Equal.class),
                    @Spec(path = "competition.hillVersion.hill.id", params = "hillId", spec = Equal.class),
                    @Spec(path = "competition.hillVersion.hill.venue.id", params = "venueId", spec = Equal.class),
                    @Spec(path = "competition.hillVersion.hill.sizeOfHill.id", params = "sizeOfHillId", spec = Equal.class),
                    @Spec(path = "totalRank", params = "minRank", spec = LessThanOrEqual.class),
                    @Spec(path="date1", params= "after" ,spec= GreaterThanOrEqual.class)
            }) Specification<Result> spec) {
        return resultService.get(spec, Sort.by(Sort.Direction.ASC, "competition.date1"));
    }

    @Transactional
    @GetMapping(value = "/hillRecords", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<HillRecordDTO> getHillRecords(
            @And({
                    @Spec(path = "id", params = "id", spec = Equal.class),
                    @Spec(path = "skiJumper.id", params = "skiJumperId", spec = Equal.class),
                    @Spec(path = "competition.season.id", params = "seasonId", spec = Equal.class),
                    @Spec(path = "competition.season.season", params = "season", spec = Equal.class),
                    @Spec(path = "competition.hillVersion.hill.venue.city.region.country.id", params = "countryId", spec = Equal.class),
                    @Spec(path = "competition.seriesMajor.id", params = "seriesMajorId", spec = Equal.class),
                    @Spec(path = "competition.seriesMinor.id", params = "seriesMinorId", spec = Equal.class),
                    @Spec(path = "competition.hillVersion.id", params = "hillVersionId", spec = Equal.class),
                    @Spec(path = "competition.hillVersion.hill.id", params = "hillId", spec = Equal.class),
                    @Spec(path = "competition.hillVersion.hill.venue.id", params = "venueId", spec = Equal.class),
                    @Spec(path = "competition.hillVersion.hill.sizeOfHill.id", params = "sizeOfHillId", spec = Equal.class),
                    @Spec(path="date1", params= "after" ,spec= GreaterThanOrEqual.class)
            }) Specification<Result> spec) {
        return resultService.getHillRecords(spec, Sort.by(Sort.Direction.DESC, "competition.date1"));
    }

    @GetMapping("/{competitionId}")
    public List<Result> getResultsByCompetitionId(@PathVariable("competitionId") int competitionId) {
        return resultService.findAllByCompetitionId(competitionId);
    }

    @PostMapping("/link/{competitionId}")
    public void uploadResultsLink(@RequestBody String link, @PathVariable("competitionId") int competitionId){
        resultService.saveFromLink(link, competitionId);
    }


}
