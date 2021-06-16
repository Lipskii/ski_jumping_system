package com.lipskii.ski_jumping_system.controllers;

import com.lipskii.ski_jumping_system.entity.JuryCompetition;
import com.lipskii.ski_jumping_system.service.JuryCompetitionService;
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
@RequestMapping("/api/juryCompetition")
@org.springframework.web.bind.annotation.RestController
public class JuryCompetitionController {

    private final JuryCompetitionService juryCompetitionService;

    @Autowired
    public JuryCompetitionController(JuryCompetitionService juryCompetitionService) {
        this.juryCompetitionService = juryCompetitionService;
    }



    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<JuryCompetition> getJuryCompetition(
            @And({
                    @Spec(path = "id", params = "id", spec = Equal.class),
                    @Spec(path = "competition.id", params = "competitionId", spec = Equal.class),
            }) Specification<JuryCompetition> spec) {
        return juryCompetitionService.get(spec, Sort.by("jury.person.lastName"));
    }

    @PostMapping("")
    public JuryCompetition addJuryCompetition(@RequestBody JuryCompetition juryCompetition) {
        juryCompetitionService.save(juryCompetition);
        return juryCompetition;
    }

    @DeleteMapping("/{juryCompetitionId}")
    public void deleteHill(@PathVariable("juryCompetitionId") int juryCompetitionId){

        juryCompetitionService.deleteById(juryCompetitionId);
    }

}

