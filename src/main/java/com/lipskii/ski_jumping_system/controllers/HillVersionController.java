package com.lipskii.ski_jumping_system.controllers;

import com.lipskii.ski_jumping_system.entity.Hill;
import com.lipskii.ski_jumping_system.entity.HillVersion;
import com.lipskii.ski_jumping_system.entity.Result;
import com.lipskii.ski_jumping_system.service.HillService;
import com.lipskii.ski_jumping_system.service.HillVersionService;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.domain.GreaterThanOrEqual;
import net.kaczmarzyk.spring.data.jpa.domain.LessThanOrEqual;
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

import javax.transaction.Transactional;
import java.util.List;


@CrossOrigin(origins = "*")
@RequestMapping("/api/hillVersions")
@RestController
public class HillVersionController {

    private final HillVersionService hillVersionService;

    @Autowired
    public HillVersionController(HillVersionService hillVersionService) {
        this.hillVersionService = hillVersionService;
    }

    @Transactional
    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<HillVersion> getHillVersions(
            @And({
                    @Spec(path = "id", params = "id", spec = Equal.class),
                    @Spec(path = "hill.id", params = "hillId", spec = Equal.class),
            }) Specification<HillVersion> spec) {
        return hillVersionService.get(spec, Sort.by(Sort.Direction.ASC, "id"));
    }


    @PostMapping("")
    public HillVersion addHillVersion(@RequestBody HillVersion hillVersion) {
        System.out.println(hillVersion);
        hillVersionService.save(hillVersion);
        return hillVersion;
    }

}
