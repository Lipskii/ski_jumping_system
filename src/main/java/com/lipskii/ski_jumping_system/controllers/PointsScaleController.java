package com.lipskii.ski_jumping_system.controllers;


import com.lipskii.ski_jumping_system.entity.PointsScale;
import com.lipskii.ski_jumping_system.service.PointsScaleService;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.transaction.Transactional;
import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping("/api/pointsScales")
@org.springframework.web.bind.annotation.RestController
public class PointsScaleController {

    private final PointsScaleService pointsScaleService;

    @Autowired
    public PointsScaleController(PointsScaleService pointsScaleService) {
        this.pointsScaleService = pointsScaleService;
    }

    @Transactional
    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<PointsScale> getPointsScale(
            @And({
                    @Spec(path = "id", params = "id", spec = Equal.class),
                    @Spec(path = "maxValue", params = "maxValue", spec = Equal.class)
            }) Specification<PointsScale> spec) {
        return pointsScaleService.get(spec, Sort.by(Sort.Direction.ASC, "id"));
    }
}
