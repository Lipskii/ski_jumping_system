package com.lipskii.ski_jumping_system.entity;

import javax.persistence.*;

//TODO Finish it after changes to db.
@Entity
@Table(name = "series")
public class Series {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idseries")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "all_time_points_system_idall_time_points_system")
    private AllTimePointsSystem allTimePointsSystem;

    public Series() {
    }

    public Series(String name, AllTimePointsSystem allTimePointsSystem) {
        this.name = name;
        this.allTimePointsSystem = allTimePointsSystem;
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

    public AllTimePointsSystem getAllTimePointsSystem() {
        return allTimePointsSystem;
    }

    public void setAllTimePointsSystem(AllTimePointsSystem allTimePointsSystem) {
        this.allTimePointsSystem = allTimePointsSystem;
    }

    @Override
    public String toString() {
        return "Series{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", allTimePointsSystem=" + allTimePointsSystem +
                '}';
    }
}
