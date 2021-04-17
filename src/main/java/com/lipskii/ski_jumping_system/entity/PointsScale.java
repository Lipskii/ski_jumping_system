package com.lipskii.ski_jumping_system.entity;

import javax.persistence.*;

@Entity
@Table(name = "points_scale")
public class PointsScale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpoints_scale")
    private int id;

    @Column(name = "max_value")
    private int maxValue;

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

    @Override
    public String toString() {
        return "PointsScale{" +
                "id=" + id +
                ", maxValue=" + maxValue +
                '}';
    }
}
