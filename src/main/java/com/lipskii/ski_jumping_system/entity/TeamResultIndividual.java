package com.lipskii.ski_jumping_system.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "team_result_individual")
public class TeamResultIndividual {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idteam_result_individual")
    private int id;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH})
    @JsonIgnoreProperties(value = {"teamResultsIndividual","skiClub","city","results"}, allowSetters = true)
    @JoinColumn(name = "ski_jumper_idski_jumper")
    private SkiJumper skiJumper;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH})
    @JsonIgnoreProperties(value = {"teamResultsIndividual","skiJumper1","skiJumper2","skiJumper3","skiJumper4"}, allowSetters = true)
    @JoinColumn(name = "team_result_idteam_result")
    private TeamResult teamResult;

    @Column(name = "first_round_distance")
    private BigDecimal firstRoundDistance;

    @Column(name = "second_round_distance")
    private BigDecimal secondRoundDistance;

    public TeamResultIndividual() {
    }

    public TeamResultIndividual(SkiJumper skiJumper, TeamResult teamResult, BigDecimal firstRoundDistance, BigDecimal secondRoundDistance) {
        this.skiJumper = skiJumper;
        this.teamResult = teamResult;
        this.firstRoundDistance = firstRoundDistance;
        this.secondRoundDistance = secondRoundDistance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SkiJumper getSkiJumper() {
        return skiJumper;
    }

    public void setSkiJumper(SkiJumper skiJumper) {
        this.skiJumper = skiJumper;
    }

    public TeamResult getTeamResult() {
        return teamResult;
    }

    public void setTeamResult(TeamResult teamResult) {
        this.teamResult = teamResult;
    }

    public BigDecimal getFirstRoundDistance() {
        return firstRoundDistance;
    }

    public void setFirstRoundDistance(BigDecimal firstRoundDistance) {
        this.firstRoundDistance = firstRoundDistance;
    }

    public BigDecimal getSecondRoundDistance() {
        return secondRoundDistance;
    }

    public void setSecondRoundDistance(BigDecimal secondRoundDistance) {
        this.secondRoundDistance = secondRoundDistance;
    }

    @Override
    public String toString() {
        return "TeamResultIndividual{" +
                "id=" + id +
                ", skiJumper=" + skiJumper +
                ", teamResult=" + teamResult +
                ", firstRoundDistance=" + firstRoundDistance +
                ", secondRoundDistance=" + secondRoundDistance +
                '}';
    }
}
