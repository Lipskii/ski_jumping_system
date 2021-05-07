package com.lipskii.ski_jumping_system.controllers;

import com.lipskii.ski_jumping_system.entity.PointsScaleValue;
import com.lipskii.ski_jumping_system.service.PointsScaleValueService;
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
@RequestMapping("/api/pointsScaleValues")
@org.springframework.web.bind.annotation.RestController
public class PointsScaleValueController {

    private final PointsScaleValueService pointsScaleValueService;

    @Autowired
    public PointsScaleValueController(PointsScaleValueService pointsScaleValueService) {
        this.pointsScaleValueService = pointsScaleValueService;
    }

    @Transactional
    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<PointsScaleValue> getPointsScale(
            @And({
                    @Spec(path = "id", params = "id", spec = Equal.class),
                    @Spec(path = "rank", params = "rank", spec = Equal.class),
                    @Spec(path = "points", params = "points", spec = Equal.class),
            }) Specification<PointsScaleValue> spec) {
        return pointsScaleValueService.get(spec, Sort.by(Sort.Direction.ASC, "rank"));
    }
}