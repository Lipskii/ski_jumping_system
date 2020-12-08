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


}
