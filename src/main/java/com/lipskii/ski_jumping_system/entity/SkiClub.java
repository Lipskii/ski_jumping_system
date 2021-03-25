package com.lipskii.ski_jumping_system.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ski_club")
public class SkiClub implements Comparable<SkiClub> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idski_club")
    private int id;

    @Column(name = "name")
    private String name;

    @JsonBackReference(value = "city-club")
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinColumn(name = "city_idcity")
    private City city;

    @JsonManagedReference(value = "venue-skiClub")
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "skiClub", cascade = {CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Venue> venues;

    @JsonIgnoreProperties("skiClub")
    @OneToMany(mappedBy = "skiClub", cascade = {CascadeType.PERSIST})
    private List<SkiJumper> skiJumpers;

    public SkiClub() {
    }

    public SkiClub(String name, City city) {
        this.name = name;
        this.city = city;
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

    public List<Venue> getVenues() {
        return venues;
    }

    public void setVenues(List<Venue> venues) {
        this.venues = venues;
    }

    public List<SkiJumper> getSkiJumpers() {
        return skiJumpers;
    }

    public void setSkiJumpers(List<SkiJumper> skiJumpers) {
        this.skiJumpers = skiJumpers;
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
