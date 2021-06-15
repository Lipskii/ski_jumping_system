package com.lipskii.ski_jumping_system.entity;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;


@Entity
@Table(name = "hill")
public class Hill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idhill")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "photo")
    private String photo;

    @JsonIgnoreProperties(value = {"hills","skiClub"}, allowSetters = true)
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "venue_idvenue")
    private Venue venue;

    @JsonIgnoreProperties(value = "hills", allowSetters = true)
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "size_of_hill_idsize_of_hill")
    private SizeOfHill sizeOfHill;

    @JsonIgnoreProperties(value = "hill", allowSetters = true)
    @OrderBy("validSince DESC ")
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "hill")
    private List<HillVersion> hillVersions;

    public Hill() {
    }

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

    public Optional<String> getPhoto() {
        return Optional.ofNullable(photo);
    }

    public void setPhoto(String photo) {
        this.photo = photo;
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
