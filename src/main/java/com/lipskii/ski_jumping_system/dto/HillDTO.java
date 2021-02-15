package com.lipskii.ski_jumping_system.dto;

import com.lipskii.ski_jumping_system.entity.HillVersion;

import java.util.List;

public class HillDTO {
    private int id;
    private String name;
    private String sizeOfHill;
    private int sizeOfHillId;
    private String venue;
    private String venueId;
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

    public String getSizeOfHill() {
        return sizeOfHill;
    }

    public void setSizeOfHill(String sizeOfHill) {
        this.sizeOfHill = sizeOfHill;
    }

    public int getSizeOfHillId() {
        return sizeOfHillId;
    }

    public void setSizeOfHillId(int sizeOfHillId) {
        this.sizeOfHillId = sizeOfHillId;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getVenueId() {
        return venueId;
    }

    public void setVenueId(String venueId) {
        this.venueId = venueId;
    }

    public List<HillVersion> getHillVersions() {
        return hillVersions;
    }

    public void setHillVersions(List<HillVersion> hillVersions) {
        this.hillVersions = hillVersions;
    }
}
