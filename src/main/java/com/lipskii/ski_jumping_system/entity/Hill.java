package com.lipskii.ski_jumping_system.entity;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "hill")
public class Hill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idhill")
    private int id;

    @Column(name = "name")
    private String name;

    @JsonBackReference(value = "venue-hill")
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "venue_idvenue")
    private Venue venue;

    @JsonBackReference(value = "size_hill")
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "size_of_hill_idsize_of_hill")
    private SizeOfHill sizeOfHill;

    @JsonManagedReference(value = "hill-hillVersion")
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "hill", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<HillVersion> hillVersions;


    public Hill() {
    }

    @JsonCreator
    public Hill(String name, Venue venue, SizeOfHill sizeOfHill) {
        this.name = name;
        this.venue = venue;
        this.sizeOfHill = sizeOfHill;
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

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public SizeOfHill getSizeOfHill() {
        return sizeOfHill;
    }

    public void setSizeOfHill(SizeOfHill sizeOfHill) {
        this.sizeOfHill = sizeOfHill;
    }

    public List<HillVersion> getHillVersions() {
        return hillVersions;
    }

    public void setHillVersions(List<HillVersion> hillVersions) {
        this.hillVersions = hillVersions;
    }

    @Override
    public String toString() {
        return "Hill{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", venue=" + venue +
                ", sizeOfHill=" + sizeOfHill +
                '}';
    }
}
