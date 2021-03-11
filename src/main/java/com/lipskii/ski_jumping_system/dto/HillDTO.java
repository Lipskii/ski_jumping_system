package com.lipskii.ski_jumping_system.dto;

import com.lipskii.ski_jumping_system.entity.City;
import com.lipskii.ski_jumping_system.entity.Country;
import com.lipskii.ski_jumping_system.entity.HillVersion;
import com.lipskii.ski_jumping_system.entity.SizeOfHill;

import java.util.List;

public class HillDTO {
    private int id;
    private String name;
    private SizeOfHill sizeOfHill;
    private VenueDTO venue;
    private Country country;
    private List<HillVersion> hillVersions;

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

    public SizeOfHill getSizeOfHill() {
        return sizeOfHill;
    }

    public void setSizeOfHill(SizeOfHill sizeOfHill) {
        this.sizeOfHill = sizeOfHill;
    }

    public VenueDTO getVenue() {
        return venue;
    }

    public void setVenue(VenueDTO venue) {
        this.venue = venue;
    }


    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public List<HillVersion> getHillVersions() {
        return hillVersions;
    }

    public void setHillVersions(List<HillVersion> hillVersions) {
        this.hillVersions = hillVersions;
    }
}
