package com.lipskii.ski_jumping_system.dto;

import com.lipskii.ski_jumping_system.entity.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public class SkiJumperDTO implements Comparable<SkiJumperDTO> {
    private int id;
    private int idPerson;
    private String firstName;
    private String lastName;
    private Gender gender;
    private City city;
    private Country country;
    private SkiClub skiClub;
    private LocalDate birthdate;
    private boolean isActive;
    private Skis skis;
    private BigDecimal allTimePoints;
    private String fisCode;

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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public SkiClub getSkiClub() {
        return skiClub;
    }

    public void setSkiClub(SkiClub skiClub) {
        this.skiClub = skiClub;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Skis getSkis() {
        return skis;
    }

    public void setSkis(Skis skis) {
        this.skis = skis;
    }

    public BigDecimal getAllTimePoints() {
        return allTimePoints;
    }

    public void setAllTimePoints(BigDecimal allTimePoints) {
        this.allTimePoints = allTimePoints;
    }

    public String getFisCode() {
        return fisCode;
    }

    public void setFisCode(String fisCode) {
        this.fisCode = fisCode;
    }

    @Override
    public int compareTo(SkiJumperDTO o) {
        return this.lastName.compareTo(o.lastName);
    }
}
