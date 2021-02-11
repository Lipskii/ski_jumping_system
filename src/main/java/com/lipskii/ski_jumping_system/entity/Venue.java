package com.lipskii.ski_jumping_system.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "venue")
public class Venue implements Comparable<Venue> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idvenue")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "year_of_opening")
    private int yearOfOpening;

    @Column(name = "capacity")
    private int capacity;

    @JsonBackReference
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "ski_club_idski_club")
    private SkiClub skiClub;

    @JsonBackReference
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "city_idcity")
    private City city;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "venue", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Hill> hills;

    public Venue() {
    }

    public Venue(String name, int yearOfOpening, int capacity, SkiClub skiClub, City city) {
        this.name = name;
        this.yearOfOpening = yearOfOpening;
        this.capacity = capacity;
        this.skiClub = skiClub;
        this.city = city;
    }

    public Venue(String name, int yearOfOpening, SkiClub skiClub, City city) {
        this.name = name;
        this.yearOfOpening = yearOfOpening;
        this.skiClub = skiClub;
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

    public int getYearOfOpening() {
        return yearOfOpening;
    }

    public void setYearOfOpening(int yearOfOpening) {
        this.yearOfOpening = yearOfOpening;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public SkiClub getSkiClub() {
        return skiClub;
    }

    public void setSkiClub(SkiClub skiClub) {
        this.skiClub = skiClub;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<Hill> getHills() {
        return hills;
    }

    public void setHills(List<Hill> hills) {
        this.hills = hills;
    }

    @Override
    public int compareTo(Venue o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return "Venue{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", yearOfOpening=" + yearOfOpening +
                ", capacity=" + capacity +
                ", skiClub=" + skiClub +
                ", city=" + city +
                '}';
    }
}
