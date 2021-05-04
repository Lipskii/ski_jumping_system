package com.lipskii.ski_jumping_system.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "points_scale")
public class PointsScale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpoints_scale")
    private int id;

    @Column(name = "max_value")
    private int maxValue;

    @JsonIgnoreProperties(value = {"pointsScale"}, allowSetters = true)
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "pointsScale", cascade = {CascadeType.PERSIST})
    private List<PointsScaleValue> pointsScaleValues;

    public PointsScale() {
    }

    public PointsScale(int maxValue) {
        this.maxValue = maxValue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

    public List<PointsScaleValue> getPointsScaleValues() {
        return pointsScaleValues;
    }

    public void setPointsScaleValues(List<PointsScaleValue> pointsScaleValues) {
        this.pointsScaleValues = pointsScaleValues;
    }

    @Override
    public String toString() {
        return "PointsScale{" +
                "id=" + id +
                ", maxValue=" + maxValue +
                ", pointsScaleValues=" + pointsScaleValues +
                '}';
    }
}
