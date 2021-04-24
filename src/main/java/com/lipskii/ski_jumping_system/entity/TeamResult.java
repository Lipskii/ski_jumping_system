package com.lipskii.ski_jumping_system.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "team_result")
public class TeamResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idteam_result")
    private int id;

    @ManyToOne//(cascade = {CascadeType.DETACH, CascadeType.REFRESH})
    @JsonIgnoreProperties(value = {"teamResults","hillVersion"}, allowSetters = true)
    @JoinColumn(name = "competition_idcompetition")
    private Competition competition;

    @ManyToOne//(cascade = {CascadeType.DETACH, CascadeType.REFRESH})
    @JsonIgnoreProperties(value = {"teamResults","people"}, allowSetters = true)
    @JoinColumn(name = "country_idcountry")
    private Country country;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH})
    @JsonIgnoreProperties(value = {"teamResults","skiClub","city","results"}, allowSetters = true)
    @JoinColumn(name = "ski_jumper_idski_jumper1")
    private SkiJumper skiJumper1;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH})
    @JsonIgnoreProperties(value = {"teamResults","skiClub","city","results"}, allowSetters = true)
    @JoinColumn(name = "ski_jumper_idski_jumper2")
    private SkiJumper skiJumper2;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH})
    @JsonIgnoreProperties(value = {"teamResults","skiClub","city","results"}, allowSetters = true)
    @JoinColumn(name = "ski_jumper_idski_jumper3")
    private SkiJumper skiJumper3;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH})
    @JsonIgnoreProperties(value = {"teamResults","skiClub","city","results"}, allowSetters = true)
    @JoinColumn(name = "ski_jumper_idski_jumper4")
    private SkiJumper skiJumper4;

    @Column(name = "total_points")
    private BigDecimal totalPoints;

    @Column(name = "total_rank")
    private int totalRank;

    public TeamResult() {
    }

    public TeamResult(Competition competition, Country country, SkiJumper skiJumper1, SkiJumper skiJumper2, SkiJumper skiJumper3, SkiJumper skiJumper4, BigDecimal totalPoints, int totalRank) {
        this.competition = competition;
        this.country = country;
        this.skiJumper1 = skiJumper1;
        this.skiJumper2 = skiJumper2;
        this.skiJumper3 = skiJumper3;
        this.skiJumper4 = skiJumper4;
        this.totalPoints = totalPoints;
        this.totalRank = totalRank;
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

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public SkiJumper getSkiJumper1() {
        return skiJumper1;
    }

    public void setSkiJumper1(SkiJumper skiJumper1) {
        this.skiJumper1 = skiJumper1;
    }

    public SkiJumper getSkiJumper2() {
        return skiJumper2;
    }

    public void setSkiJumper2(SkiJumper skiJumper2) {
        this.skiJumper2 = skiJumper2;
    }

    public SkiJumper getSkiJumper3() {
        return skiJumper3;
    }

    public void setSkiJumper3(SkiJumper skiJumper3) {
        this.skiJumper3 = skiJumper3;
    }

    public SkiJumper getSkiJumper4() {
        return skiJumper4;
    }

    public void setSkiJumper4(SkiJumper skiJumper4) {
        this.skiJumper4 = skiJumper4;
    }

    public BigDecimal getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(BigDecimal totalPoints) {
        this.totalPoints = totalPoints;
    }

    public int getTotalRank() {
        return totalRank;
    }

    public void setTotalRank(int totalRank) {
        this.totalRank = totalRank;
    }

    @Override
    public String toString() {
        return "TeamResult{" +
                "id=" + id +
                ", competition=" + competition +
                ", country=" + country +
                ", skiJumper1=" + skiJumper1 +
                ", skiJumper2=" + skiJumper2 +
                ", skiJumper3=" + skiJumper3 +
                ", skiJumper4=" + skiJumper4 +
                ", totalPoints=" + totalPoints +
                ", totalRank=" + totalRank +
                '}';
    }
}
