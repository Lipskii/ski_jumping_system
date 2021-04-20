package com.lipskii.ski_jumping_system.entity;


import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "overall_standing")
public class OverallStanding {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idoverall_standing")
    private int id;

    @ManyToOne(cascade = {CascadeType.DETACH,  CascadeType.REFRESH})
    @JoinColumn(name = "series_idseries")
    private Series series;

    @ManyToOne(cascade = {CascadeType.DETACH,  CascadeType.REFRESH})
    @JoinColumn(name = "season_idseason")
    private Season season;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "ski_jumper_idski_jumper")
    private SkiJumper skiJumper;

    @Column(name = "points")
    private BigDecimal points;

    @Column(name = "ranking")
    private Integer ranking;

    public OverallStanding() {
    }

    public OverallStanding(Series series, Season season, SkiJumper skiJumper, BigDecimal points, int ranking) {
        this.series = series;
        this.season = season;
        this.skiJumper = skiJumper;
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

    public SkiJumper getSkiJumper() {
        return skiJumper;
    }

    public void setSkiJumper(SkiJumper skiJumper) {
        this.skiJumper = skiJumper;
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

    public void setRanking(Integer rank) {
        this.ranking = rank;
    }



    @Override
    public String toString() {
        return "OverallStanding{" +
                "id=" + id +
                ", series=" + series +
                ", season=" + season +
                ", skiJumper=" + skiJumper +
                ", points=" + points +
                ", rank=" + ranking +
                '}';
    }
}
