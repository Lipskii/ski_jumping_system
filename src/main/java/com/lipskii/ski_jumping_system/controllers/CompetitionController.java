package com.lipskii.ski_jumping_system.controllers;

import com.lipskii.ski_jumping_system.entity.*;
import com.lipskii.ski_jumping_system.service.*;
import net.kaczmarzyk.spring.data.jpa.domain.*;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Join;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


import javax.transaction.Transactional;
import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping("/api/competitions")
@org.springframework.web.bind.annotation.RestController
public class CompetitionController {

    private final CompetitionService competitionService;


    @Autowired
    public CompetitionController(CompetitionService competitionService) {
        this.competitionService = competitionService;
    }

    @GetMapping("/hill/{hillId}")
    public List<Competition> getCompetitionsByHill(@PathVariable("hillId") int hillId) {
        return competitionService.findAllByHillId(hillId);
    }

    @GetMapping("/hillAndSeries/{hillId}&{seriesId}")
    public List<Competition> getCompetitionsByHillAndSeries(@PathVariable("seriesId") int seriesId, @PathVariable("hillId") int hillId) {
        return competitionService.findAllBySeriesAndHillId(hillId, seriesId);
    }

    @Transactional
    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<Competition> getCompetitions(
            @Join(path = "results", alias = "r")
            @And({
                    @Spec(path = "id", params = "id", spec = Equal.class),
                    @Spec(path = "season.id", params = "seasonId", spec = Equal.class),
                    @Spec(path = "season.season", params = "season", spec = Equal.class),
                    @Spec(path = "hillVersion.hill.venue.city.region.country.id", params = "countryId", spec = Equal.class),
                    @Spec(path = "seriesMajor.id", params = "seriesMajorId", spec = Equal.class),
                    @Spec(path = "seriesMinor.id", params = "seriesMinorId", spec = Equal.class),
                    @Spec(path = "hillVersion.hill.id", params = "hillId", spec = Equal.class),
                    @Spec(path = "hillVersion.hill.venue.id", params = "venueId", spec = Equal.class),
                    @Spec(path = "hillVersion.hill.sizeOfHill.id", params = "sizeOfHillId", spec = Equal.class),
                    @Spec(path = "r", params = "hasResults", spec = NotNull.class),
                    @Spec(path="date1", params= "after" ,spec= GreaterThanOrEqual.class)
            }) Specification<Competition> spec) {
        return competitionService.get(spec, Sort.by(Sort.Direction.DESC, "date1"));
    }

    @GetMapping("/series/{seriesId}")
    public List<Competition> getCompetitionsBySeries(@PathVariable("seriesId") int seriesId) {
        return competitionService.findAllBySeriesId(seriesId);
    }

    @GetMapping("/season/{seasonId}")
    public List<Competition> getCompetitionsBySeason(@PathVariable("seasonId") int seasonId) {
        return competitionService.findAllBySeasonId(seasonId);
    }

    @PostMapping("")
    public Competition addCompetition(@RequestBody Competition competition) {
        competitionService.save(competition);
        return competition;
    }

    @DeleteMapping("/{competitionId}")
    public void deleteCompetition(@PathVariable("competitionId") int competitionId) {
        competitionService.deleteById(competitionId);
    }

}

