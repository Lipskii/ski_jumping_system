package com.lipskii.ski_jumping_system.entity;


import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "overall_standings")
public class OverallStandings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idoverall_standings")
    private int id;

    @ManyToOne(cascade = {CascadeType.DETACH,  CascadeType.REFRESH})
    @JoinColumn(name = "series_idseries")
    private Series series;

    @ManyToOne(cascade = {CascadeType.DETACH,  CascadeType.REFRESH})
    @JoinColumn(name = "season_idseason")
    private Season season;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH})
   // @JsonIgnoreProperties(value = "results", allowSetters = true)
    @JoinColumn(name = "ski_jumper_idski_jumper")
    private SkiJumper skiJumper;

    @Column(name = "points")
    private BigDecimal points;

    public OverallStandings() {
    }

    public OverallStandings(Series series, Season season, SkiJumper skiJumper, BigDecimal points) {
        this.series = series;
        this.season = season;
        this.skiJumper = skiJumper;
        this.points = points;
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

    @Override
    public String toString() {
        return "OverallStandings{" +
                "id=" + id +
                ", series=" + series +
                ", season=" + season +
                ", skiJumper=" + skiJumper +
                ", points=" + points +
                '}';
    }
}
