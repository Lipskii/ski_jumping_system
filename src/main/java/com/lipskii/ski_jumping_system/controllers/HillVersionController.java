package com.lipskii.ski_jumping_system.controllers;

import com.lipskii.ski_jumping_system.dto.HillRecordDTO;
import com.lipskii.ski_jumping_system.dto.HillVersionDTO;
import com.lipskii.ski_jumping_system.entity.HillVersion;
import com.lipskii.ski_jumping_system.service.HillVersionService;
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

    @Transactional
    @GetMapping(value = "/hillRecord/{hillVersionId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<HillRecordDTO> getHillVersionRecord(@PathVariable("hillVersionId") int hillVersionId) {
        return hillVersionService.getHillRecords(hillVersionId);
    }



    @PostMapping("")
    public HillVersion addHillVersion(@RequestBody HillVersion hillVersion) {
        System.out.println(hillVersion);
        hillVersionService.save(hillVersion);
        return hillVersion;
    }

}
