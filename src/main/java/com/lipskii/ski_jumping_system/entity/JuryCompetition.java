package com.lipskii.ski_jumping_system.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "jury_competition")
public class JuryCompetition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idjury_competition")
    private int id;

    @ManyToOne//(cascade = {CascadeType.DETACH, CascadeType.REFRESH})
//    @JsonIgnoreProperties(value = {}, allowSetters = true)
    @JoinColumn(name = "competition_idcompetition")
    private Competition competition;

    @ManyToOne//(cascade = {CascadeType.DETACH, CascadeType.REFRESH})
    @JsonIgnoreProperties(value = {"juryCompetition"}, allowSetters = true)
    @JoinColumn(name = "jury_idjury")
    private Jury jury;

    public JuryCompetition() {
    }

    public JuryCompetition(Competition competition, Jury jury) {
        this.competition = competition;
        this.jury = jury;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }

    public Jury getJury() {
        return jury;
    }

    public void setJury(Jury jury) {
        this.jury = jury;
    }

    @Override
    public String toString() {
        return "JuryCompetition{" +
                "id=" + id +
                ", competition=" + competition +
                ", jury=" + jury +
                '}';
    }
}
