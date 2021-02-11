package com.lipskii.ski_jumping_system.dto;

public class VenueDTO {

    private int id;
    private String name;
    private int yearOfOpening;
    private int capacity;
    private String city;
    private String skiClub;

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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSkiClub() {
        return skiClub;
    }

    public void setSkiClub(String skiClub) {
        this.skiClub = skiClub;
    }
}
