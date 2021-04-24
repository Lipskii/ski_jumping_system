package com.lipskii.ski_jumping_system.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "team_overall_standing")
public class TeamOverallStanding {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idteam_overall_standing")
    private int id;

    @ManyToOne(cascade = {CascadeType.DETACH,  CascadeType.REFRESH})
    @JoinColumn(name = "series_idseries")
    private Series series;

    @ManyToOne(cascade = {CascadeType.DETACH,  CascadeType.REFRESH})
    @JoinColumn(name = "season_idseason")
    private Season season;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "country_idcountry")
    private Country country;

    @Column(name = "points")
    private BigDecimal points;

    @Column(name = "ranking")
    private Integer ranking;

    public TeamOverallStanding() {
    }

    public TeamOverallStanding(Series series, Season season, Country country, BigDecimal points, Integer ranking) {
        this.series = series;
        this.season = season;
        this.country = country;
        this.points = points;
        this.ranking = ranking;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Series getSeries() {
        return series;
    }

    public void setSeries(Series series) {
        this.series = series;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public BigDecimal getPoints() {
        return points;
    }

    public void setPoints(BigDecimal points) {
        this.points = points;
    }

    public Integer getRanking() {
        return ranking;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }

    @Override
    public String toString() {
        return "TeamOverallStanding{" +
                "id=" + id +
                ", series=" + series +
                ", season=" + season +
                ", country=" + country +
                ", points=" + points +
                ", ranking=" + ranking +
                '}';
    }
}
