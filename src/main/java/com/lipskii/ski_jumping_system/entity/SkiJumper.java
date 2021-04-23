package com.lipskii.ski_jumping_system.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "ski_jumper")
public class SkiJumper implements Comparable<SkiJumper> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idski_jumper")
    private int id;

    @OneToOne
    @JoinColumn(name = "person_idperson")
    private Person person;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "fis_code")
    private String fisCode;

    @JsonIgnoreProperties(value = "skiJumpers", allowSetters = true)
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "skis_idskis")
    private Skis skis;

    @JsonIgnoreProperties(value ="skiJumpers", allowSetters = true)
    @ManyToOne(cascade = {CascadeType.DETACH,  CascadeType.REFRESH})
    @JoinColumn(name = "ski_club_idski_club")
    private SkiClub skiClub;

    @Column(name = "all_time_points")
    private BigDecimal all_time_points;

    @JsonIgnoreProperties(value = "skiJumper", allowSetters = true)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "skiJumper")
    private List<Result> results;

//    @JsonIgnoreProperties(value = "skiJumper", allowSetters = true)
//    @OneToMany(fetch = FetchType.EAGER, mappedBy = "skiJumper")
//    private List<TeamResult> teamResults;



    public SkiJumper() {
    }

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

    public BigDecimal getAll_time_points() {
        return all_time_points;
    }

    public void setAll_time_points(BigDecimal all_time_points) {
        this.all_time_points = all_time_points;
    }

    public SkiClub getSkiClub() {
        return skiClub;
    }

    public void setSkiClub(SkiClub skiClub) {
        this.skiClub = skiClub;
    }

    public String getFisCode() {
        return fisCode;
    }

    public void setFisCode(String fisCode) {
        this.fisCode = fisCode;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }
//
//    public List<TeamResult> getTeamResults() {
//        return teamResults;
//    }
//
//    public void setTeamResults(List<TeamResult> teamResults) {
//        this.teamResults = teamResults;
//    }

    @Override
    public int compareTo(SkiJumper o) {
        return person.compareTo(o.person);
    }

    @Override
    public String toString() {
        return "SkiJumper{" +
                "id=" + id +
                ", person=" + person +
                ", isActive=" + isActive +
                ", fisCode='" + fisCode + '\'' +
                ", skis=" + skis +
                ", skiClub=" + skiClub +
                ", all_time_points=" + all_time_points +
                '}';
    }
}
