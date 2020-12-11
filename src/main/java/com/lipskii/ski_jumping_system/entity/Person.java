package com.lipskii.ski_jumping_system.entity;

import javax.persistence.*;


@Entity
@Table(name = "person")
public class Person implements Comparable<Person> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idperson")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "gender_idgender")
    private Gender gender;

    @Column(name = "birthdate_day")
    private int birthdate_day;

    @Column(name = "birthdate_month")
    private int birthdate_month;

    @Column(name = "birthdate_year")
    private int birthdate_year;
    /**
     * Current country that athlete represents with his fis license.
     */
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "country_idcountry")
    private Country country;

    /**
     * Place of birth.
     */
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "city_idcity")
    private City city;

    public Person() {
    }


    public Person(int id, String firstName, String lastName, Gender gender, Country country, City city) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.country = country;
        this.city = city;
    }

    public Person(int id, String firstName, String lastName, Gender gender, int birthdate_year, Country country, City city) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthdate_year = birthdate_year;
        this.country = country;
        this.city = city;
    }

    public Person(int id, String firstName, String lastName, Gender gender, int birthdate_day, int birthdate_month, int birthdate_year, Country country, City city) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthdate_day = birthdate_day;
        this.birthdate_month = birthdate_month;
        this.birthdate_year = birthdate_year;
        this.country = country;
        this.city = city;
    }

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

    public Country getCountry() {
        return country;
    }


    public void setCountry(Country country) {
        this.country = country;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getBirthdate_day() {
        return birthdate_day;
    }

    public void setBirthdate_day(int birthdate_day) {
        this.birthdate_day = birthdate_day;
    }

    public int getBirthdate_month() {
        return birthdate_month;
    }

    public void setBirthdate_month(int birthdate_month) {
        this.birthdate_month = birthdate_month;
    }

    public int getBirthdate_year() {
        return birthdate_year;
    }

    public void setBirthdate_year(int birthdate_year) {
        this.birthdate_year = birthdate_year;
    }

    @Override
    public int compareTo(Person o) {
        if(!this.lastName.equals(o.lastName)){
            return this.lastName.compareTo(o.lastName);
        }
        return this.firstName.compareTo(o.firstName);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", birthdate_day=" + birthdate_day +
                ", birthdate_month=" + birthdate_month +
                ", birthdate_year=" + birthdate_year +
                ", country=" + country +
                ", city=" + city +
                '}';
    }
}
