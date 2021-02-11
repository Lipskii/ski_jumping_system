package com.lipskii.ski_jumping_system.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "ski_jumper")
public class SkiJumper implements Comparable<SkiJumper> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idski_jumper")
    private int id;

    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "person_idperson")
    private Person person;

    @Column(name = "is_active")
    private boolean isActive;

    @JsonBackReference
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "skis_idskis")
    private Skis skis;

    @JsonBackReference
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "ski_club_idski_club")
    private SkiClub skiClub;

    @Column(name = "all_time_points")
    private BigDecimal all_time_points;

    public SkiJumper() {
    }

    public SkiJumper(Person person, boolean isActive, Skis skis, SkiClub skiClub, BigDecimal all_time_points) {
        this.person = person;
        this.isActive = isActive;
        this.skis = skis;
        this.skiClub = skiClub;
        this.all_time_points = all_time_points;
    }

    public SkiJumper(Person person, boolean isActive, Skis skis, BigDecimal all_time_points) {
        this.person = person;
        this.isActive = isActive;
        this.skis = skis;
        this.all_time_points = all_time_points;
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
                ", skis=" + skis +
                ", skiClub=" + skiClub +
                ", all_time_points=" + all_time_points +
                '}';
    }
}
