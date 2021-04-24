package com.lipskii.ski_jumping_system.controllers;

import com.lipskii.ski_jumping_system.dto.CalculateOverallStandingsDTO;
import com.lipskii.ski_jumping_system.entity.TeamOverallStanding;
import com.lipskii.ski_jumping_system.service.TeamOverallStandingService;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.domain.GreaterThan;
import net.kaczmarzyk.spring.data.jpa.domain.LessThan;
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
@RequestMapping("/api/teamOverallStandings")
@org.springframework.web.bind.annotation.RestController
public class TeamOverallStandingController {

    private final TeamOverallStandingService teamOverallStandingService;

    @Autowired
    public TeamOverallStandingController(TeamOverallStandingService teamOverallStandingService) {
        this.teamOverallStandingService =  teamOverallStandingService;
    }

    @Transactional
    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<TeamOverallStanding> geTeamOverallStandings(
            @And({
                    @Spec(path = "id", params = "id", spec = Equal.class),
                    @Spec(path = "skiJumper.id", params = "skiJumperId", spec = Equal.class),
                    @Spec(path = "skiJumper.person.country.id", params = "skiJumperCountryId", spec = Equal.class),
                    @Spec(path = "season.id", params = "seasonId", spec = Equal.class),
                    @Spec(path = "season.season", params = "season", spec = Equal.class),
                    @Spec(path = "series.id", params = "seriesId", spec = Equal.class),
                    @Spec(path = "ranking", params = "rankingLessThan", spec = LessThan.class),
                    @Spec(path = "ranking", params = "rankingGreaterThan", spec = GreaterThan.class),
            }) Specification<TeamOverallStanding> spec) {
        return teamOverallStandingService.get(spec, Sort.by(Sort.Direction.DESC, "points"));
    }

    @PostMapping("")
    public TeamOverallStanding addCompetition(@RequestBody TeamOverallStanding teamOverallStanding) {
        teamOverallStandingService.save(teamOverallStanding);
        return teamOverallStanding;
    }

    @PostMapping("/calculate")
    public void calculateTeamOverallStandings(@RequestBody CalculateOverallStandingsDTO dto) {
        teamOverallStandingService.calculateNationsCupStandings(dto.getSeriesId(), dto.getSeason());
    }


    @DeleteMapping("/{teamOverallStandingsId}")
    public void deleteCompetition(@PathVariable("teamOverallStandingsId") int teamOverallStandingId) {
        teamOverallStandingService.deleteById(teamOverallStandingId);
    }
}
