package com.lipskii.ski_jumping_system.controllers;


import com.lipskii.ski_jumping_system.entity.*;
import com.lipskii.ski_jumping_system.service.*;
import net.kaczmarzyk.spring.data.jpa.domain.*;
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
@RequestMapping("/api/jury")
@org.springframework.web.bind.annotation.RestController
public class JuryController {

    private final JuryService juryService;

    @Autowired
    public JuryController(JuryService juryService) {
        this.juryService = juryService;
    }


    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<Jury> getJury(
            @And({
                    @Spec(path = "id", params = "id", spec = Equal.class),
                    @Spec(path = "juryType.id", params = "juryTypeId", spec = Equal.class),
                    @Spec(path = "person.id", params = "personId", spec = Equal.class),
                    @Spec(path = "person.country.id", params = "countryId", spec = Equal.class),
                    @Spec(path = "person.gender.id", params = "genderId", spec = Equal.class),
            }) Specification<Jury> spec) {
        return juryService.get(spec, Sort.by("person.lastName"));
    }

    @PostMapping("")
    public Jury saveJury(@RequestBody Jury jury) {
        juryService.save(jury);
        return jury;
    }

    @DeleteMapping("/{juryId}")
    public void deleteJury(@PathVariable("juryId") int juryId) {
        juryService.deleteById(juryId);
    }


}
