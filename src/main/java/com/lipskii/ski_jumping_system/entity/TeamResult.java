package com.lipskii.ski_jumping_system.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

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

    @JsonIgnoreProperties(value = "teamResult", allowSetters = true)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "teamResult")
    private List<TeamResultIndividual> teamResultsIndividual;

    @Column(name = "total_points")
    private BigDecimal totalPoints;

    @Column(name = "total_rank")
    private int totalRank;

    public TeamResult() {
    }

    public TeamResult(Competition competition, Country country, BigDecimal totalPoints, int totalRank) {
        this.competition = competition;
        this.country = country;
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

    public List<TeamResultIndividual> getTeamResultsIndividual() {
        return teamResultsIndividual;
    }

    public void setTeamResultsIndividual(List<TeamResultIndividual> teamResultsIndividual) {
        this.teamResultsIndividual = teamResultsIndividual;
    }

    @Override
    public String toString() {
        return "TeamResult{" +
                "id=" + id +
                ", competition=" + competition +
                ", country=" + country +
                ", teamResultsIndividual=" + teamResultsIndividual +
                ", totalPoints=" + totalPoints +
                ", totalRank=" + totalRank +
                '}';
    }
}
