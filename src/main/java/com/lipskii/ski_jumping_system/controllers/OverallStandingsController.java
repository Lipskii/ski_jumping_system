package com.lipskii.ski_jumping_system.controllers;

import com.lipskii.ski_jumping_system.entity.OverallStandings;
import com.lipskii.ski_jumping_system.service.OverallStandingsService;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
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
@RequestMapping("/api/overallStandings")
@org.springframework.web.bind.annotation.RestController
public class OverallStandingsController {

    private final OverallStandingsService overallStandingsService;

    @Autowired
    public OverallStandingsController(OverallStandingsService overallStandingsService) {
        this.overallStandingsService = overallStandingsService;
    }

    @Transactional
    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<OverallStandings> getOverallStandings(
            @And({
                    @Spec(path = "id", params = "id", spec = Equal.class),
                    @Spec(path = "skiJumper.id", params = "skiJumperId", spec = Equal.class),
                    @Spec(path = "skiJumper.person.country.id", params = "skiJumperCountryId", spec = Equal.class),
                    @Spec(path = "season.id", params = "seasonId", spec = Equal.class),
                    @Spec(path = "season.season", params = "season", spec = Equal.class),
                    @Spec(path = "series.id", params = "seriesId", spec = Equal.class),
            }) Specification<OverallStandings> spec) {
        return overallStandingsService.get(spec, Sort.by(Sort.Direction.DESC, "points"));
    }

    @PostMapping("")
    public OverallStandings addCompetition(@RequestBody OverallStandings overallStandings) {
        overallStandingsService.save(overallStandings);
        return overallStandings;
    }

    @DeleteMapping("/{overallStandingsId}")
    public void deleteCompetition(@PathVariable("overallStandingsId") int competitionId) {
        overallStandingsService.deleteById(competitionId);
    }
}
