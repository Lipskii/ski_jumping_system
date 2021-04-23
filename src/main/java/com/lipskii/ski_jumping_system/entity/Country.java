package com.lipskii.ski_jumping_system.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "country")
@JsonIgnoreProperties({"regions"})
public class Country implements Comparable<Country> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcountry")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @JsonIgnoreProperties(value = {"country"}, allowSetters = true)
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "country", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Region> regions;

    @JsonIgnoreProperties(value = "country", allowSetters = true )
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "country", cascade = {CascadeType.PERSIST})
    private List<Person> people;

    @JsonIgnoreProperties(value = {"country","skiJumper1","skiJumper2","skiJumper3","skiJumper4"}, allowSetters = true)
    @OrderBy("totalRank")
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "country") //, cascade = {CascadeType.PERSIST,CascadeType.REMOVE}
    private List<TeamResult> teamResults;

    public Country() {
    }

    public Country(String name, String code) {
        this.name = name;
        this.code = code;
    }


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

    public List<Region> getRegions() {
        return regions;
    }

    public void setRegions(List<Region> regions) {
        this.regions = regions;
    }

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }

    public List<TeamResult> getTeamResults() {
        return teamResults;
    }

    public void setTeamResults(List<TeamResult> teamResults) {
        this.teamResults = teamResults;
    }

    @Override
    public int compareTo(Country o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
