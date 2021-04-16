package com.lipskii.ski_jumping_system.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "qualification")
public class Qualification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idqualification")
    private int id;

    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH, CascadeType.REMOVE},orphanRemoval = true)
    @JoinColumn(name = "competition_idcompetition")
    private Competition competition;

    @Column(name = "date1")
    private LocalDate date1;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "judge_idjudge_a")
    private Jury judgeA;


    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "judge_idjudge_b")
    private Jury judgeB;


    @ManyToOne(cascade = {CascadeType.DETACH,  CascadeType.REFRESH})
    @JoinColumn(name = "judge_idjudge_c")
    private Jury judgeC;


    @ManyToOne(cascade = {CascadeType.DETACH,  CascadeType.REFRESH})
    @JoinColumn(name = "judge_idjudge_d")
    private Jury judgeD;


    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "judge_idjudge_e")
    private Jury judgeE;


    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "judge_idjudge_sc")
    private Jury judgeSC;

    @Column(name = "start_time")
    private LocalDateTime startTime;

    @Column(name = "end_time")
    private LocalDateTime endTime;

    @Column(name = "base_gate")
    private int baseGate;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "weather_idweather")
    private Weather weather;

    @Column(name = "air_temp_start")
    private BigDecimal airTempStart;

    @Column(name = "air_temp_finish")
    private BigDecimal airTempFinish;

    @Column(name = "snow_temp_start")
    private BigDecimal snowTempStart;

    @Column(name = "snow_temp_finish")
    private BigDecimal snowTempFinish;

    @Column(name = "humidity_start")
    private BigDecimal humidityStart;

    @Column(name = "humidity_finish")
    private BigDecimal humidityFinish;

    @Column(name = "min_wind")
    private BigDecimal minWind;

    @Column(name = "max_wind")
    private BigDecimal maxWind;

    @Column(name = "avg_wind")
    private BigDecimal avgWind;

    public Qualification() {
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

    public LocalDate getDate1() {
        return date1;
    }

    public void setDate1(LocalDate date1) {
        this.date1 = date1;
    }

    public Jury getJudgeA() {
        return judgeA;
    }

    public void setJudgeA(Jury judgeA) {
        this.judgeA = judgeA;
    }

    public Jury getJudgeB() {
        return judgeB;
    }

    public void setJudgeB(Jury judgeB) {
        this.judgeB = judgeB;
    }

    public Jury getJudgeC() {
        return judgeC;
    }

    public void setJudgeC(Jury judgeC) {
        this.judgeC = judgeC;
    }

    public Jury getJudgeD() {
        return judgeD;
    }

    public void setJudgeD(Jury judgeD) {
        this.judgeD = judgeD;
    }

    public Jury getJudgeE() {
        return judgeE;
    }

    public void setJudgeE(Jury judgeE) {
        this.judgeE = judgeE;
    }

    public Jury getJudgeSC() {
        return judgeSC;
    }

    public void setJudgeSC(Jury judgeSC) {
        this.judgeSC = judgeSC;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public int getBaseGate() {
        return baseGate;
    }

    public void setBaseGate(int baseGate) {
        this.baseGate = baseGate;
    }

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    public BigDecimal getAirTempStart() {
        return airTempStart;
    }

    public void setAirTempStart(BigDecimal airTempStart) {
        this.airTempStart = airTempStart;
    }

    public BigDecimal getAirTempFinish() {
        return airTempFinish;
    }

    public void setAirTempFinish(BigDecimal airTempFinish) {
        this.airTempFinish = airTempFinish;
    }

    public BigDecimal getSnowTempStart() {
        return snowTempStart;
    }

    public void setSnowTempStart(BigDecimal snowTempStart) {
        this.snowTempStart = snowTempStart;
    }

    public BigDecimal getSnowTempFinish() {
        return snowTempFinish;
    }

    public void setSnowTempFinish(BigDecimal snowTempFinish) {
        this.snowTempFinish = snowTempFinish;
    }

    public BigDecimal getHumidityStart() {
        return humidityStart;
    }

    public void setHumidityStart(BigDecimal humidityStart) {
        this.humidityStart = humidityStart;
    }

    public BigDecimal getHumidityFinish() {
        return humidityFinish;
    }

    public void setHumidityFinish(BigDecimal humidityFinish) {
        this.humidityFinish = humidityFinish;
    }

    public BigDecimal getMinWind() {
        return minWind;
    }

    public void setMinWind(BigDecimal minWind) {
        this.minWind = minWind;
    }

    public BigDecimal getMaxWind() {
        return maxWind;
    }

    public void setMaxWind(BigDecimal maxWind) {
        this.maxWind = maxWind;
    }

    public BigDecimal getAvgWind() {
        return avgWind;
    }

    public void setAvgWind(BigDecimal avgWind) {
        this.avgWind = avgWind;
    }
}
