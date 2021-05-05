package com.lipskii.ski_jumping_system.controllers;

import com.lipskii.ski_jumping_system.entity.*;
import com.lipskii.ski_jumping_system.service.*;
import net.kaczmarzyk.spring.data.jpa.domain.*;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.*;


@CrossOrigin(origins = "*")
@RequestMapping("/api/skiJumpers")
@org.springframework.web.bind.annotation.RestController
public class SkiJumperController {

    private final SkiJumperService skiJumperService;

    @Autowired
    public SkiJumperController(SkiJumperService skiJumperService) {
        this.skiJumperService = skiJumperService;
    }

    @Transactional
    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<SkiJumper> getSkiJumpers(
            @And({
                    @Spec(path = "id", params = "id", spec = Equal.class),
                    @Spec(path = "person.id", params = "personId", spec = Equal.class),
                    @Spec(path = "isActive", params = "isActive", spec = Equal.class),
                    @Spec(path = "fisCode", params = "fisCode", spec = Equal.class),
                    @Spec(path = "skis.id", params = "skisId", spec = Equal.class),
                    @Spec(path = "skiClub.id", params = "skiClubId", spec = Equal.class),
                    @Spec(path = "person.country.id", params = "countryId", spec = Equal.class),
                    @Spec(path = "person.city.id", params = "cityId", spec = Equal.class),
                    @Spec(path = "person.gender.id", params = "genderId", spec = Equal.class),
                    @Spec(path = "person.lastName", params = "lastNameLike=", spec = EqualIgnoreCase.class),
                    @Spec(path="person.birthdate", params={"bornAfter","bornBefore"}, spec=Between.class),
                    @Spec(path="person.birthdate", params="bornOn", spec=Equal.class)
            }) Specification<SkiJumper> spec) {
        return skiJumperService.get(spec, Sort.by("person.lastName"));
    }

    @PostMapping("")
    public SkiJumper addSkiJumper(@RequestBody SkiJumper skiJumper) {
        skiJumperService.save(skiJumper);
        return skiJumper;
    }

    @DeleteMapping("/{skiJumperId}")
    public void deleteSkiJumper(@PathVariable("skiJumperId") int skiJumperId) {
        skiJumperService.deleteById(skiJumperId);
    }

    @PutMapping(value = "/{skiJumperId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public SkiJumper updateSkiJumper(@RequestBody SkiJumper skiJumper, @PathVariable("skiJumperId") int skiJumperId) throws ResourceNotFoundException {

        if (skiJumperService.findById(skiJumperId).isPresent()) {
            skiJumper.setId(skiJumperId);
            skiJumperService.save(skiJumper);
        } else {
            throw new ResourceNotFoundException("No jumper found for id: " + skiJumperId);
        }

        return skiJumper;
    }


}
