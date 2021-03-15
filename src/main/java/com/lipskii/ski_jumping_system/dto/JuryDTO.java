package com.lipskii.ski_jumping_system.dto;

import com.lipskii.ski_jumping_system.entity.Country;
import com.lipskii.ski_jumping_system.entity.Gender;
import com.lipskii.ski_jumping_system.entity.JuryType;
import com.lipskii.ski_jumping_system.entity.Person;

public class JuryDTO implements Comparable<JuryDTO> {
    private int id;
    private Person person;
    private JuryType juryType;
    private Country country;
    private Gender gender;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public JuryType getJuryType() {
        return juryType;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public void setJuryType(JuryType juryType) {
        this.juryType = juryType;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public int compareTo(JuryDTO o) {
        return this.person.getLastName().compareTo(o.getPerson().getLastName());
    }
}
