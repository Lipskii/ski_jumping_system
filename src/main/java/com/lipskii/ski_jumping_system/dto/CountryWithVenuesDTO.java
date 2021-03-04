package com.lipskii.ski_jumping_system.dto;

import com.lipskii.ski_jumping_system.entity.Venue;

import java.util.List;

public class CountryWithVenuesDTO {
    int id;
    String name;
    String code;
    List<Venue> venues;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Venue> getVenues() {
        return venues;
    }

    public void setVenues(List<Venue> venues) {
        this.venues = venues;
    }
}
