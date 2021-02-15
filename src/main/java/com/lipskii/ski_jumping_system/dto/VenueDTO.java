package com.lipskii.ski_jumping_system.dto;

public class VenueDTO {

    private int id;
    private String name;
    private int yearOfOpening;
    private int capacity;
    private String city;
    private int cityId;
    private String region;
    private int regionId;
    private String country;
    private int countryId;
    private String skiClub;
    private int skiClubId;

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

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public int getSkiClubId() {
        return skiClubId;
    }

    public void setSkiClubId(int skiClubId) {
        this.skiClubId = skiClubId;
    }
}
