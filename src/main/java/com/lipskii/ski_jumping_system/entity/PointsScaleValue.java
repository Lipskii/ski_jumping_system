package com.lipskii.ski_jumping_system.entity;

import javax.persistence.*;

@Entity
@Table(name = "points_scale_value")
public class PointsScaleValue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpoints_scale_value")
    private int id;

    @Column(name = "rank")
    private int rank;

    @Column(name = "points")
    private int points;

    public PointsScaleValue() {
    }

    public PointsScaleValue(int rank, int points) {
        this.rank = rank;
        this.points = points;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "PointsScaleValue{" +
                "id=" + id +
                ", rank=" + rank +
                ", points=" + points +
                '}';
    }
}
