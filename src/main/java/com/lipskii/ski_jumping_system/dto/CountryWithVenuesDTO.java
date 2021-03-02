package com.lipskii.ski_jumping_system.dto;

import java.util.List;

public class CountryWithVenuesDTO {
    int id;
    String name;
    String code;
    List<VenueDTO> venues;

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

    public List<VenueDTO> getVenues() {
        return venues;
    }

    public void setVenues(List<VenueDTO> venues) {
        this.venues = venues;
    }
}
