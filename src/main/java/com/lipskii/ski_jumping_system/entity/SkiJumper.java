package com.lipskii.ski_jumping_system.entity;

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

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "skis_idskis")
    private Skis skis;

    @Column(name = "all_time_points")
    private BigDecimal all_time_points;

    public SkiJumper() {
    }

    public SkiJumper(Person person, boolean isActive, Skis skis) {
        this.person = person;
        this.isActive = isActive;
        this.skis = skis;
        this.all_time_points = BigDecimal.valueOf(0);
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
                ", all_time_points=" + all_time_points +
                '}';
    }
}
