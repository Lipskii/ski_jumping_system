package com.lipskii.ski_jumping_system.controllers;

import com.lipskii.ski_jumping_system.entity.TeamResult;
import com.lipskii.ski_jumping_system.service.TeamResultService;
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
import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping("/api/teamResults")
@org.springframework.web.bind.annotation.RestController
public class TeamResultController {

    private final TeamResultService teamResultService;


    @Autowired
    public TeamResultController(TeamResultService teamResultService) {
        this.teamResultService = teamResultService;
    }


    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<TeamResult> getResults(
            @And({
                    @Spec(path = "id", params = "id", spec = Equal.class),
                    @Spec(path = "country.id", params = "countryId", spec = Equal.class),
                    @Spec(path = "skiJumper1.id", params = "skiJumper1Id", spec = Equal.class),
                    @Spec(path = "skiJumper2.id", params = "skiJumper2Id", spec = Equal.class),
                    @Spec(path = "skiJumper3.id", params = "skiJumper3Id", spec = Equal.class),
                    @Spec(path = "skiJumper4.id", params = "skiJumper4Id", spec = Equal.class),
                    @Spec(path = "competition.id", params = "competitionId", spec = Equal.class),
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
                    @Spec(path = "competition.date1", params = "after", spec = GreaterThanOrEqual.class)
            }) Specification<TeamResult> spec) {
        return teamResultService.get(spec, Sort.by(Sort.Direction.ASC, "competition.date1"));
    }

    @PostMapping("/link/{competitionId}")
    public void uploadResultsLink(@RequestBody String link, @PathVariable("competitionId") int competitionId) {
        teamResultService.saveFromLink(link, competitionId);
    }
}
