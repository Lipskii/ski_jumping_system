package com.lipskii.ski_jumping_system.entity;

import javax.persistence.*;

@Entity
@Table(name = "ski_club")
public class SkiClub implements Comparable<SkiClub> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idski_club")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "city_idcity")
    private City city;

    @Column(name="established")
    private int established;

    public SkiClub() {
    }

    public SkiClub(String name, City city) {
        this.name = name;
        this.city = city;
    }

    public SkiClub(String name, City city, int established) {
        this.name = name;
        this.city = city;
        this.established = established;
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

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public int getEstablished() {
        return established;
    }

    public void setEstablished(int established) {
        this.established = established;
    }

    @Override
    public int compareTo(SkiClub o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return "SkiClub{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city=" + city +
                '}';
    }
}
