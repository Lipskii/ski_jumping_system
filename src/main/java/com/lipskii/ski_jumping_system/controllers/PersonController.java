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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;


@CrossOrigin(origins = "*")
@RequestMapping("/api/people")
@org.springframework.web.bind.annotation.RestController
public class PersonController {

    private final PersonService personService;


    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }


    @Transactional
    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<Person> getPeople(
            @And({
                    @Spec(path = "id", params = "id", spec = Equal.class),
                    @Spec(path = "firstName", params = "firstName", spec = Equal.class),
                    @Spec(path = "lastName", params = "lastName", spec = Equal.class),
                    @Spec(path = "gender.id", params = "genderId", spec = Equal.class),
                    @Spec(path = "country.id", params = "countryId", spec = Equal.class),
                    @Spec(path = "city.id", params = "cityId", spec = Equal.class),
            }) Specification<Person> spec) {
        return personService.get(spec, Sort.by("lastName"));
    }

    @PostMapping("")
    public Person addPerson(@RequestBody Person person) {
        personService.save(person);
        return person;
    }

    @PostMapping(value = "/photo/{personId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity uploadPersonPhoto(@RequestPart MultipartFile file, @PathVariable("personId") int personId)
            throws ResourceNotFoundException {
        Person person = personService.findById(personId).orElseThrow(() -> new ResourceNotFoundException("No person found for id " + personId));
        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(FilesPaths.ATHLETES_PHOTOS_PATH + personId + "_"
                    + person.getFirstName() + "_" + person.getLastName());
            Files.write(path, bytes);
            person.setPhoto(file.getOriginalFilename());
            personService.save(person);
        } catch (IOException e) {
            System.out.println(e.getCause().getMessage());
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{personId}")
    public Person updatePerson(@RequestBody Person person, @PathVariable("personId") int personId) throws ResourceNotFoundException {

        if (personService.findById(personId).isPresent()) {
            person.setId(personId);
            personService.save(person);
        } else {
            throw new ResourceNotFoundException("No person found for id: " + personId);
        }

        return person;
    }

}
