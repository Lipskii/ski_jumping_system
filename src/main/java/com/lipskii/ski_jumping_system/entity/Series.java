package com.lipskii.ski_jumping_system.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "series")
public class Series {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idseries")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "points_scale_idpoints_scale")
    private PointsScale pointsScale;


    public Series() {
    }


    public Series(String name, PointsScale pointsScale) {
        this.name = name;
        this.pointsScale = pointsScale;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PointsScale getPointsScale() {
        return pointsScale;
    }

    public void setPointsScale(PointsScale pointsScale) {
        this.pointsScale = pointsScale;
    }


    @Override
    public String toString() {
        return "Series{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pointsScale=" + pointsScale +
                '}';
    }
}
