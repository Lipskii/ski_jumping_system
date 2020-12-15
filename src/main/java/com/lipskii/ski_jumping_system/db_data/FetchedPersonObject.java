package com.lipskii.ski_jumping_system.db_data;

public class FetchedPersonObject {

    private final String firstName;
    private final String lastName;
    private final String country;
    private final String city;
    private final String birthdate_day;
    private final String birthdate_month;
    private final String birthdate_year;

    public FetchedPersonObject(String firstName, String lastName, String country, String city, String birthdate_day, String birthdate_month, String birthdate_year) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.city = city;
        this.birthdate_day = birthdate_day;
        this.birthdate_month = birthdate_month;
        this.birthdate_year = birthdate_year;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getBirthdate_day() {
        return birthdate_day;
    }

    public String getBirthdate_month() {
        return birthdate_month;
    }

    public String getBirthdate_year() {
        return birthdate_year;
    }
}
