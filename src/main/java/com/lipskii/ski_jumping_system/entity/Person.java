package com.lipskii.ski_jumping_system.entity;

import javax.persistence.*;
import java.sql.Date;


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

    @Column(name = "birthday")
    private Date birthday;

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

    public Person(String firstName, String lastName, Date birthday, Country country, City city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
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
                ", birthday=" + birthday +
                ", country=" + country +
                ", city=" + city +
                '}';
    }
}
