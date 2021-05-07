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
import java.util.*;


@CrossOrigin(origins = "*")
@RequestMapping("/api/skiClubs")
@org.springframework.web.bind.annotation.RestController
public class SkiClubController {


    private final SkiClubService skiClubService;

    @Autowired
    public SkiClubController(SkiClubService skiClubService) {
        this.skiClubService = skiClubService;
    }

    @Transactional
    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<SkiClub> getSkiClubs(
            @Join(path = "skiJumpers", alias = "o")
            @And({
                    @Spec(path = "id", params = "id", spec = Equal.class),
                    @Spec(path = "name", params = "name", spec = Equal.class),
                    @Spec(path = "city.id", params = "cityId", spec = Equal.class),
                    @Spec(path = "city.region.country.id", params = "countryId", spec = Equal.class),
                    @Spec(path = "o", params = "hasJumpers", spec = NotNull.class)
            }) Specification<SkiClub> spec) {
        return skiClubService.get(spec, Sort.by("name"));
    }

    @PostMapping("")
    public SkiClub addSkiClubs(@RequestBody SkiClub skiClub) {
        skiClubService.save(skiClub);
        return skiClub;
    }

    @DeleteMapping("/{skiClubId}")
    public void deleteSkiClub(@PathVariable("skiClubId") int skiClubId) {
        skiClubService.deleteById(skiClubId);
    }

    @PutMapping("/{skiClubId}")
    public SkiClub updateSkiClub(@PathVariable("skiClubId") int skiClubId, @RequestBody SkiClub skiClub){
        return skiClubService.updateSkiClub(skiClubId,skiClub);

    }


}
