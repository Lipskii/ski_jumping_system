package com.lipskii.ski_jumping_system.entity;

import javax.persistence.*;

@Entity
@Table(name = "season")
public class Season {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idseason")
    private int id;

    @Column(name = "season")
    private int season;

    public Season() {
    }

    public Season(int season) {
        this.season = season;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    @Override
    public String toString() {
        return "Season{" +
                "id=" + id +
                ", season=" + season +
                '}';
    }
}
