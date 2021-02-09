package com.lipskii.ski_jumping_system.dto;

import java.math.BigDecimal;

public class SkiJumperDTO {
    private int id;
    private String firstName;
    private String lastName;
    private String gender;
    private String city;
    private String country;
    private String skiClub;
    private String birthdate;
    private boolean isActive;
    private String skis;
    private BigDecimal allTimePoints;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSkiClub() {
        return skiClub;
    }

    public void setSkiClub(String skiClub) {
        this.skiClub = skiClub;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getSkis() {
        return skis;
    }

    public void setSkis(String skis) {
        this.skis = skis;
    }

    public BigDecimal getAllTimePoints() {
        return allTimePoints;
    }

    public void setAllTimePoints(BigDecimal allTimePoints) {
        this.allTimePoints = allTimePoints;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
