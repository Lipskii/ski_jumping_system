package com.lipskii.ski_jumping_system.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "competition")
public class Competition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcompetition")
    private int id;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "season_idseason")
    private Season season;

    @Column(name = "date_1")
    private Date date1;

    @Column(name = "date_2")
    private Date date2;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "series_idseries_major")
    private Series seriesMajor;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "series_idseries_minor")
    private Series seriesMinor;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "hill_version_idhill_version")
    private HillVersion hillVersion;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "judge_idjudge_a")
    private Judge judgeA;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "judge_idjudge_b")
    private Judge judgeB;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "judge_idjudge_c")
    private Judge judgeC;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "judge_idjudge_d")
    private Judge judgeD;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "judge_idjudge_e")
    private Judge judgeE;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "judge_idjudge_sc")
    private Judge judgeSC;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "jury_idrace_director")
    private Jury raceDirector;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "jury_idtechnical_delegate")
    private Jury technicalDelegate;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "jury_idchief_of_competition")
    private Jury chiefOfCompetition;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "jury_idassistant_td")
    private Jury assistantTD;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "jury_idassistant_rd")
    private Jury assistantRD;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "jury_idequipment_controller1")
    private Jury equipmentController1;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "jury_idequipment_controller2")
    private Jury equipmentController2;

    @Column(name = "meter_value")
    private BigDecimal meterValue;

    @Column(name = "gate_factor")
    private BigDecimal gateFactor;

    @Column(name = "wind_factor_tail")
    private BigDecimal windFactorTail;

    @Column(name = "wind_factor_front")
    private BigDecimal windFactorFront;

    @Column(name = "first_round_start_time")
    private Timestamp firstRoundStartTime;

    @Column(name = "first_round_end_time")
    private Timestamp firstRoundEndTime;

    @Column(name = "first_round_base_gate")
    private int firstRoundBaseGate;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "weather_idfirst_round_weather")
    private Weather firstRoundWeather;

    @Column(name = "first_round_air_temp_start")
    private BigDecimal firstRoundAirTempStart;

    @Column(name = "first_round_air_temp_finish")
    private BigDecimal firstRoundAirTempFinish;

    @Column(name = "first_round_snow_temp_start")
    private BigDecimal firstRoundSnowTempStart;

    @Column(name = "first_round_snow_temp_finish")
    private BigDecimal firstRoundSnowTempFinish;

    @Column(name = "first_round_humidity_start")
    private BigDecimal firstRoundHumidityStart;

    @Column(name = "first_round_humidity_finish")
    private BigDecimal firstRoundHumidityFinish;

    @Column(name = "first_round_min_wind")
    private BigDecimal firstRoundMinWind;

    @Column(name = "first_round_max_wind")
    private BigDecimal firstRoundMaxWind;

    @Column(name = "first_round_avg_wind")
    private BigDecimal firstRoundAvgWind;

    @Column(name = "second_round_start_time")
    private Timestamp secondRoundStartTime;

    @Column(name = "second_round_end_time")
    private Timestamp secondRoundEndTime;

    @Column(name = "second_round_base_gate")
    private int secondRoundBaseGate;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "weather_idsecond_round_weather")
    private Weather secondRoundWeather;

    @Column(name = "first_round_air_temp_start")
    private BigDecimal secondRoundAirTempStart;

    @Column(name = "first_round_air_temp_finish")
    private BigDecimal secondRoundAirTempFinish;

    @Column(name = "first_round_snow_temp_start")
    private BigDecimal secondRoundSnowTempStart;

    @Column(name = "first_round_snow_temp_finish")
    private BigDecimal secondRoundSnowTempFinish;

    @Column(name = "first_round_humidity_start")
    private BigDecimal secondRoundHumidityStart;

    @Column(name = "first_round_humidity_finish")
    private BigDecimal secondRoundHumidityFinish;

    @Column(name = "first_round_min_wind")
    private BigDecimal secondRoundMinWind;

    @Column(name = "first_round_max_wind")
    private BigDecimal secondRoundMaxWind;

    @Column(name = "first_round_avg_wind")
    private BigDecimal secondRoundAvgWind;

    @Column(name = "third_round_start_time")
    private Timestamp thirdRoundStartTime;

    @Column(name = "third_round_end_time")
    private Timestamp thirdRoundEndTime;

    @Column(name = "third_round_base_gate")
    private int thirdRoundBaseGate;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "weather_idthird_round_weather")
    private Weather thirdRoundWeather;

    @Column(name = "third_round_air_temp_start")
    private BigDecimal thirdRoundAirTempStart;

    @Column(name = "third_round_air_temp_finish")
    private BigDecimal thirdRoundAirTempFinish;

    @Column(name = "third_round_snow_temp_start")
    private BigDecimal thirdRoundSnowTempStart;

    @Column(name = "third_round_snow_temp_finish")
    private BigDecimal thirdRoundSnowTempFinish;

    @Column(name = "third_round_humidity_start")
    private BigDecimal thirdRoundHumidityStart;

    @Column(name = "third_round_humidity_finish")
    private BigDecimal thirdRoundHumidityFinish;

    @Column(name = "third_round_min_wind")
    private BigDecimal thirdRoundMinWind;

    @Column(name = "third_round_max_wind")
    private BigDecimal thirdRoundMaxWind;

    @Column(name = "third_round_avg_wind")
    private BigDecimal thirdRoundAvgWind;

    @Column(name = "fourth_round_start_time")
    private Timestamp fourthRoundStartTime;

    @Column(name = "fourth_round_end_time")
    private Timestamp fourthRoundEndTime;

    @Column(name = "fourth_round_base_gate")
    private int fourthRoundBaseGate;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "weather_idfourth_round_weather")
    private Weather fourthRoundWeather;

    @Column(name = "fourth_round_air_temp_start")
    private BigDecimal fourthRoundAirTempStart;

    @Column(name = "fourth_round_air_temp_finish")
    private BigDecimal fourthRoundAirTempFinish;

    @Column(name = "fourth_round_snow_temp_start")
    private BigDecimal fourthRoundSnowTempStart;

    @Column(name = "fourth_round_snow_temp_finish")
    private BigDecimal fourthRoundSnowTempFinish;

    @Column(name = "fourth_round_humidity_start")
    private BigDecimal fourthRoundHumidityStart;

    @Column(name = "fourth_round_humidity_finish")
    private BigDecimal fourthRoundHumidityFinish;

    @Column(name = "fourth_round_min_wind")
    private BigDecimal fourthRoundMinWind;

    @Column(name = "fourth_round_max_wind")
    private BigDecimal fourthRoundMaxWind;

    @Column(name = "fourth_round_avg_wind")
    private BigDecimal fourthRoundAvgWind;

    public Competition() {
    }

    //1 round competition constructor
    public Competition(int id, Season season, Date date1, Date date2, Series seriesMajor, Series seriesMinor, HillVersion hillVersion, Judge judgeA, Judge judgeB, Judge judgeC, Judge judgeD, Judge judgeE, Judge judgeSC, Jury raceDirector, Jury technicalDelegate, Jury chiefOfCompetition, Jury assistantTD, Jury assistantRD, Jury equipmentController1, Jury equipmentController2, BigDecimal meterValue, BigDecimal gateFactor, BigDecimal windFactorTail, BigDecimal windFactorFront, Timestamp firstRoundStartTime, Timestamp firstRoundEndTime, int firstRoundBaseGate, Weather firstRoundWeather, BigDecimal firstRoundAirTempStart, BigDecimal firstRoundAirTempFinish, BigDecimal firstRoundSnowTempStart, BigDecimal firstRoundSnowTempFinish, BigDecimal firstRoundHumidityStart, BigDecimal firstRoundHumidityFinish, BigDecimal firstRoundMinWind, BigDecimal firstRoundMaxWind, BigDecimal firstRoundAvgWind) {
        this.id = id;
        this.season = season;
        this.date1 = date1;
        this.date2 = date2;
        this.seriesMajor = seriesMajor;
        this.seriesMinor = seriesMinor;
        this.hillVersion = hillVersion;
        this.judgeA = judgeA;
        this.judgeB = judgeB;
        this.judgeC = judgeC;
        this.judgeD = judgeD;
        this.judgeE = judgeE;
        this.judgeSC = judgeSC;
        this.raceDirector = raceDirector;
        this.technicalDelegate = technicalDelegate;
        this.chiefOfCompetition = chiefOfCompetition;
        this.assistantTD = assistantTD;
        this.assistantRD = assistantRD;
        this.equipmentController1 = equipmentController1;
        this.equipmentController2 = equipmentController2;
        this.meterValue = meterValue;
        this.gateFactor = gateFactor;
        this.windFactorTail = windFactorTail;
        this.windFactorFront = windFactorFront;
        this.firstRoundStartTime = firstRoundStartTime;
        this.firstRoundEndTime = firstRoundEndTime;
        this.firstRoundBaseGate = firstRoundBaseGate;
        this.firstRoundWeather = firstRoundWeather;
        this.firstRoundAirTempStart = firstRoundAirTempStart;
        this.firstRoundAirTempFinish = firstRoundAirTempFinish;
        this.firstRoundSnowTempStart = firstRoundSnowTempStart;
        this.firstRoundSnowTempFinish = firstRoundSnowTempFinish;
        this.firstRoundHumidityStart = firstRoundHumidityStart;
        this.firstRoundHumidityFinish = firstRoundHumidityFinish;
        this.firstRoundMinWind = firstRoundMinWind;
        this.firstRoundMaxWind = firstRoundMaxWind;
        this.firstRoundAvgWind = firstRoundAvgWind;
    }

    //2 round competition constructor
    public Competition(int id, Season season, Date date1, Date date2, Series seriesMajor, Series seriesMinor, HillVersion hillVersion, Judge judgeA, Judge judgeB, Judge judgeC, Judge judgeD, Judge judgeE, Judge judgeSC, Jury raceDirector, Jury technicalDelegate, Jury chiefOfCompetition, Jury assistantTD, Jury assistantRD, Jury equipmentController1, Jury equipmentController2, BigDecimal meterValue, BigDecimal gateFactor, BigDecimal windFactorTail, BigDecimal windFactorFront, Timestamp firstRoundStartTime, Timestamp firstRoundEndTime, int firstRoundBaseGate, Weather firstRoundWeather, BigDecimal firstRoundAirTempStart, BigDecimal firstRoundAirTempFinish, BigDecimal firstRoundSnowTempStart, BigDecimal firstRoundSnowTempFinish, BigDecimal firstRoundHumidityStart, BigDecimal firstRoundHumidityFinish, BigDecimal firstRoundMinWind, BigDecimal firstRoundMaxWind, BigDecimal firstRoundAvgWind, Timestamp secondRoundStartTime, Timestamp secondRoundEndTime, int secondRoundBaseGate, Weather secondRoundWeather, BigDecimal secondRoundAirTempStart, BigDecimal secondRoundAirTempFinish, BigDecimal secondRoundSnowTempStart, BigDecimal secondRoundSnowTempFinish, BigDecimal secondRoundHumidityStart, BigDecimal secondRoundHumidityFinish, BigDecimal secondRoundMinWind, BigDecimal secondRoundMaxWind, BigDecimal secondRoundAvgWind) {
        this.id = id;
        this.season = season;
        this.date1 = date1;
        this.date2 = date2;
        this.seriesMajor = seriesMajor;
        this.seriesMinor = seriesMinor;
        this.hillVersion = hillVersion;
        this.judgeA = judgeA;
        this.judgeB = judgeB;
        this.judgeC = judgeC;
        this.judgeD = judgeD;
        this.judgeE = judgeE;
        this.judgeSC = judgeSC;
        this.raceDirector = raceDirector;
        this.technicalDelegate = technicalDelegate;
        this.chiefOfCompetition = chiefOfCompetition;
        this.assistantTD = assistantTD;
        this.assistantRD = assistantRD;
        this.equipmentController1 = equipmentController1;
        this.equipmentController2 = equipmentController2;
        this.meterValue = meterValue;
        this.gateFactor = gateFactor;
        this.windFactorTail = windFactorTail;
        this.windFactorFront = windFactorFront;
        this.firstRoundStartTime = firstRoundStartTime;
        this.firstRoundEndTime = firstRoundEndTime;
        this.firstRoundBaseGate = firstRoundBaseGate;
        this.firstRoundWeather = firstRoundWeather;
        this.firstRoundAirTempStart = firstRoundAirTempStart;
        this.firstRoundAirTempFinish = firstRoundAirTempFinish;
        this.firstRoundSnowTempStart = firstRoundSnowTempStart;
        this.firstRoundSnowTempFinish = firstRoundSnowTempFinish;
        this.firstRoundHumidityStart = firstRoundHumidityStart;
        this.firstRoundHumidityFinish = firstRoundHumidityFinish;
        this.firstRoundMinWind = firstRoundMinWind;
        this.firstRoundMaxWind = firstRoundMaxWind;
        this.firstRoundAvgWind = firstRoundAvgWind;
        this.secondRoundStartTime = secondRoundStartTime;
        this.secondRoundEndTime = secondRoundEndTime;
        this.secondRoundBaseGate = secondRoundBaseGate;
        this.secondRoundWeather = secondRoundWeather;
        this.secondRoundAirTempStart = secondRoundAirTempStart;
        this.secondRoundAirTempFinish = secondRoundAirTempFinish;
        this.secondRoundSnowTempStart = secondRoundSnowTempStart;
        this.secondRoundSnowTempFinish = secondRoundSnowTempFinish;
        this.secondRoundHumidityStart = secondRoundHumidityStart;
        this.secondRoundHumidityFinish = secondRoundHumidityFinish;
        this.secondRoundMinWind = secondRoundMinWind;
        this.secondRoundMaxWind = secondRoundMaxWind;
        this.secondRoundAvgWind = secondRoundAvgWind;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public Date getDate1() {
        return date1;
    }

    public void setDate1(Date date1) {
        this.date1 = date1;
    }

    public Date getDate2() {
        return date2;
    }

    public void setDate2(Date date2) {
        this.date2 = date2;
    }

    public Series getSeriesMajor() {
        return seriesMajor;
    }

    public void setSeriesMajor(Series seriesMajor) {
        this.seriesMajor = seriesMajor;
    }

    public Series getSeriesMinor() {
        return seriesMinor;
    }

    public void setSeriesMinor(Series seriesMinor) {
        this.seriesMinor = seriesMinor;
    }

    public HillVersion getHillVersion() {
        return hillVersion;
    }

    public void setHillVersion(HillVersion hillVersion) {
        this.hillVersion = hillVersion;
    }

    public Judge getJudgeA() {
        return judgeA;
    }

    public void setJudgeA(Judge judgeA) {
        this.judgeA = judgeA;
    }

    public Judge getJudgeB() {
        return judgeB;
    }

    public void setJudgeB(Judge judgeB) {
        this.judgeB = judgeB;
    }

    public Judge getJudgeC() {
        return judgeC;
    }

    public void setJudgeC(Judge judgeC) {
        this.judgeC = judgeC;
    }

    public Judge getJudgeD() {
        return judgeD;
    }

    public void setJudgeD(Judge judgeD) {
        this.judgeD = judgeD;
    }

    public Judge getJudgeE() {
        return judgeE;
    }

    public void setJudgeE(Judge judgeE) {
        this.judgeE = judgeE;
    }

    public Judge getJudgeSC() {
        return judgeSC;
    }

    public void setJudgeSC(Judge judgeSC) {
        this.judgeSC = judgeSC;
    }

    public Jury getRaceDirector() {
        return raceDirector;
    }

    public void setRaceDirector(Jury raceDirector) {
        this.raceDirector = raceDirector;
    }

    public Jury getTechnicalDelegate() {
        return technicalDelegate;
    }

    public void setTechnicalDelegate(Jury technicalDelegate) {
        this.technicalDelegate = technicalDelegate;
    }

    public Jury getChiefOfCompetition() {
        return chiefOfCompetition;
    }

    public void setChiefOfCompetition(Jury chiefOfCompetition) {
        this.chiefOfCompetition = chiefOfCompetition;
    }

    public Jury getAssistantTD() {
        return assistantTD;
    }

    public void setAssistantTD(Jury assistantTD) {
        this.assistantTD = assistantTD;
    }

    public Jury getAssistantRD() {
        return assistantRD;
    }

    public void setAssistantRD(Jury assistantRD) {
        this.assistantRD = assistantRD;
    }

    public Jury getEquipmentController1() {
        return equipmentController1;
    }

    public void setEquipmentController1(Jury equipmentController1) {
        this.equipmentController1 = equipmentController1;
    }

    public Jury getEquipmentController2() {
        return equipmentController2;
    }

    public void setEquipmentController2(Jury equipmentController2) {
        this.equipmentController2 = equipmentController2;
    }

    public BigDecimal getMeterValue() {
        return meterValue;
    }

    public void setMeterValue(BigDecimal meterValue) {
        this.meterValue = meterValue;
    }

    public BigDecimal getGateFactor() {
        return gateFactor;
    }

    public void setGateFactor(BigDecimal gateFactor) {
        this.gateFactor = gateFactor;
    }

    public BigDecimal getWindFactorTail() {
        return windFactorTail;
    }

    public void setWindFactorTail(BigDecimal windFactorTail) {
        this.windFactorTail = windFactorTail;
    }

    public BigDecimal getWindFactorFront() {
        return windFactorFront;
    }

    public void setWindFactorFront(BigDecimal windFactorFront) {
        this.windFactorFront = windFactorFront;
    }

    public Timestamp getFirstRoundStartTime() {
        return firstRoundStartTime;
    }

    public void setFirstRoundStartTime(Timestamp firstRoundStartTime) {
        this.firstRoundStartTime = firstRoundStartTime;
    }

    public Timestamp getFirstRoundEndTime() {
        return firstRoundEndTime;
    }

    public void setFirstRoundEndTime(Timestamp firstRoundEndTime) {
        this.firstRoundEndTime = firstRoundEndTime;
    }

    public int getFirstRoundBaseGate() {
        return firstRoundBaseGate;
    }

    public void setFirstRoundBaseGate(int firstRoundBaseGate) {
        this.firstRoundBaseGate = firstRoundBaseGate;
    }

    public Weather getFirstRoundWeather() {
        return firstRoundWeather;
    }

    public void setFirstRoundWeather(Weather firstRoundWeather) {
        this.firstRoundWeather = firstRoundWeather;
    }

    public BigDecimal getFirstRoundAirTempStart() {
        return firstRoundAirTempStart;
    }

    public void setFirstRoundAirTempStart(BigDecimal firstRoundAirTempStart) {
        this.firstRoundAirTempStart = firstRoundAirTempStart;
    }

    public BigDecimal getFirstRoundAirTempFinish() {
        return firstRoundAirTempFinish;
    }

    public void setFirstRoundAirTempFinish(BigDecimal firstRoundAirTempFinish) {
        this.firstRoundAirTempFinish = firstRoundAirTempFinish;
    }

    public BigDecimal getFirstRoundSnowTempStart() {
        return firstRoundSnowTempStart;
    }

    public void setFirstRoundSnowTempStart(BigDecimal firstRoundSnowTempStart) {
        this.firstRoundSnowTempStart = firstRoundSnowTempStart;
    }

    public BigDecimal getFirstRoundSnowTempFinish() {
        return firstRoundSnowTempFinish;
    }

    public void setFirstRoundSnowTempFinish(BigDecimal firstRoundSnowTempFinish) {
        this.firstRoundSnowTempFinish = firstRoundSnowTempFinish;
    }

    public BigDecimal getFirstRoundHumidityStart() {
        return firstRoundHumidityStart;
    }

    public void setFirstRoundHumidityStart(BigDecimal firstRoundHumidityStart) {
        this.firstRoundHumidityStart = firstRoundHumidityStart;
    }

    public BigDecimal getFirstRoundHumidityFinish() {
        return firstRoundHumidityFinish;
    }

    public void setFirstRoundHumidityFinish(BigDecimal firstRoundHumidityFinish) {
        this.firstRoundHumidityFinish = firstRoundHumidityFinish;
    }

    public BigDecimal getFirstRoundMinWind() {
        return firstRoundMinWind;
    }

    public void setFirstRoundMinWind(BigDecimal firstRoundMinWind) {
        this.firstRoundMinWind = firstRoundMinWind;
    }

    public BigDecimal getFirstRoundMaxWind() {
        return firstRoundMaxWind;
    }

    public void setFirstRoundMaxWind(BigDecimal firstRoundMaxWind) {
        this.firstRoundMaxWind = firstRoundMaxWind;
    }

    public BigDecimal getFirstRoundAvgWind() {
        return firstRoundAvgWind;
    }

    public void setFirstRoundAvgWind(BigDecimal firstRoundAvgWind) {
        this.firstRoundAvgWind = firstRoundAvgWind;
    }

    public Timestamp getSecondRoundStartTime() {
        return secondRoundStartTime;
    }

    public void setSecondRoundStartTime(Timestamp secondRoundStartTime) {
        this.secondRoundStartTime = secondRoundStartTime;
    }

    public Timestamp getSecondRoundEndTime() {
        return secondRoundEndTime;
    }

    public void setSecondRoundEndTime(Timestamp secondRoundEndTime) {
        this.secondRoundEndTime = secondRoundEndTime;
    }

    public int getSecondRoundBaseGate() {
        return secondRoundBaseGate;
    }

    public void setSecondRoundBaseGate(int secondRoundBaseGate) {
        this.secondRoundBaseGate = secondRoundBaseGate;
    }

    public Weather getSecondRoundWeather() {
        return secondRoundWeather;
    }

    public void setSecondRoundWeather(Weather secondRoundWeather) {
        this.secondRoundWeather = secondRoundWeather;
    }

    public BigDecimal getSecondRoundAirTempStart() {
        return secondRoundAirTempStart;
    }

    public void setSecondRoundAirTempStart(BigDecimal secondRoundAirTempStart) {
        this.secondRoundAirTempStart = secondRoundAirTempStart;
    }

    public BigDecimal getSecondRoundAirTempFinish() {
        return secondRoundAirTempFinish;
    }

    public void setSecondRoundAirTempFinish(BigDecimal secondRoundAirTempFinish) {
        this.secondRoundAirTempFinish = secondRoundAirTempFinish;
    }

    public BigDecimal getSecondRoundSnowTempStart() {
        return secondRoundSnowTempStart;
    }

    public void setSecondRoundSnowTempStart(BigDecimal secondRoundSnowTempStart) {
        this.secondRoundSnowTempStart = secondRoundSnowTempStart;
    }

    public BigDecimal getSecondRoundSnowTempFinish() {
        return secondRoundSnowTempFinish;
    }

    public void setSecondRoundSnowTempFinish(BigDecimal secondRoundSnowTempFinish) {
        this.secondRoundSnowTempFinish = secondRoundSnowTempFinish;
    }

    public BigDecimal getSecondRoundHumidityStart() {
        return secondRoundHumidityStart;
    }

    public void setSecondRoundHumidityStart(BigDecimal secondRoundHumidityStart) {
        this.secondRoundHumidityStart = secondRoundHumidityStart;
    }

    public BigDecimal getSecondRoundHumidityFinish() {
        return secondRoundHumidityFinish;
    }

    public void setSecondRoundHumidityFinish(BigDecimal secondRoundHumidityFinish) {
        this.secondRoundHumidityFinish = secondRoundHumidityFinish;
    }

    public BigDecimal getSecondRoundMinWind() {
        return secondRoundMinWind;
    }

    public void setSecondRoundMinWind(BigDecimal secondRoundMinWind) {
        this.secondRoundMinWind = secondRoundMinWind;
    }

    public BigDecimal getSecondRoundMaxWind() {
        return secondRoundMaxWind;
    }

    public void setSecondRoundMaxWind(BigDecimal secondRoundMaxWind) {
        this.secondRoundMaxWind = secondRoundMaxWind;
    }

    public BigDecimal getSecondRoundAvgWind() {
        return secondRoundAvgWind;
    }

    public void setSecondRoundAvgWind(BigDecimal secondRoundAvgWind) {
        this.secondRoundAvgWind = secondRoundAvgWind;
    }

    public Timestamp getThirdRoundStartTime() {
        return thirdRoundStartTime;
    }

    public void setThirdRoundStartTime(Timestamp thirdRoundStartTime) {
        this.thirdRoundStartTime = thirdRoundStartTime;
    }

    public Timestamp getThirdRoundEndTime() {
        return thirdRoundEndTime;
    }

    public void setThirdRoundEndTime(Timestamp thirdRoundEndTime) {
        this.thirdRoundEndTime = thirdRoundEndTime;
    }

    public int getThirdRoundBaseGate() {
        return thirdRoundBaseGate;
    }

    public void setThirdRoundBaseGate(int thirdRoundBaseGate) {
        this.thirdRoundBaseGate = thirdRoundBaseGate;
    }

    public Weather getThirdRoundWeather() {
        return thirdRoundWeather;
    }

    public void setThirdRoundWeather(Weather thirdRoundWeather) {
        this.thirdRoundWeather = thirdRoundWeather;
    }

    public BigDecimal getThirdRoundAirTempStart() {
        return thirdRoundAirTempStart;
    }

    public void setThirdRoundAirTempStart(BigDecimal thirdRoundAirTempStart) {
        this.thirdRoundAirTempStart = thirdRoundAirTempStart;
    }

    public BigDecimal getThirdRoundAirTempFinish() {
        return thirdRoundAirTempFinish;
    }

    public void setThirdRoundAirTempFinish(BigDecimal thirdRoundAirTempFinish) {
        this.thirdRoundAirTempFinish = thirdRoundAirTempFinish;
    }

    public BigDecimal getThirdRoundSnowTempStart() {
        return thirdRoundSnowTempStart;
    }

    public void setThirdRoundSnowTempStart(BigDecimal thirdRoundSnowTempStart) {
        this.thirdRoundSnowTempStart = thirdRoundSnowTempStart;
    }

    public BigDecimal getThirdRoundSnowTempFinish() {
        return thirdRoundSnowTempFinish;
    }

    public void setThirdRoundSnowTempFinish(BigDecimal thirdRoundSnowTempFinish) {
        this.thirdRoundSnowTempFinish = thirdRoundSnowTempFinish;
    }

    public BigDecimal getThirdRoundHumidityStart() {
        return thirdRoundHumidityStart;
    }

    public void setThirdRoundHumidityStart(BigDecimal thirdRoundHumidityStart) {
        this.thirdRoundHumidityStart = thirdRoundHumidityStart;
    }

    public BigDecimal getThirdRoundHumidityFinish() {
        return thirdRoundHumidityFinish;
    }

    public void setThirdRoundHumidityFinish(BigDecimal thirdRoundHumidityFinish) {
        this.thirdRoundHumidityFinish = thirdRoundHumidityFinish;
    }

    public BigDecimal getThirdRoundMinWind() {
        return thirdRoundMinWind;
    }

    public void setThirdRoundMinWind(BigDecimal thirdRoundMinWind) {
        this.thirdRoundMinWind = thirdRoundMinWind;
    }

    public BigDecimal getThirdRoundMaxWind() {
        return thirdRoundMaxWind;
    }

    public void setThirdRoundMaxWind(BigDecimal thirdRoundMaxWind) {
        this.thirdRoundMaxWind = thirdRoundMaxWind;
    }

    public BigDecimal getThirdRoundAvgWind() {
        return thirdRoundAvgWind;
    }

    public void setThirdRoundAvgWind(BigDecimal thirdRoundAvgWind) {
        this.thirdRoundAvgWind = thirdRoundAvgWind;
    }

    public Timestamp getFourthRoundStartTime() {
        return fourthRoundStartTime;
    }

    public void setFourthRoundStartTime(Timestamp fourthRoundStartTime) {
        this.fourthRoundStartTime = fourthRoundStartTime;
    }

    public Timestamp getFourthRoundEndTime() {
        return fourthRoundEndTime;
    }

    public void setFourthRoundEndTime(Timestamp fourthRoundEndTime) {
        this.fourthRoundEndTime = fourthRoundEndTime;
    }

    public int getFourthRoundBaseGate() {
        return fourthRoundBaseGate;
    }

    public void setFourthRoundBaseGate(int fourthRoundBaseGate) {
        this.fourthRoundBaseGate = fourthRoundBaseGate;
    }

    public Weather getFourthRoundWeather() {
        return fourthRoundWeather;
    }

    public void setFourthRoundWeather(Weather fourthRoundWeather) {
        this.fourthRoundWeather = fourthRoundWeather;
    }

    public BigDecimal getFourthRoundAirTempStart() {
        return fourthRoundAirTempStart;
    }

    public void setFourthRoundAirTempStart(BigDecimal fourthRoundAirTempStart) {
        this.fourthRoundAirTempStart = fourthRoundAirTempStart;
    }

    public BigDecimal getFourthRoundAirTempFinish() {
        return fourthRoundAirTempFinish;
    }

    public void setFourthRoundAirTempFinish(BigDecimal fourthRoundAirTempFinish) {
        this.fourthRoundAirTempFinish = fourthRoundAirTempFinish;
    }

    public BigDecimal getFourthRoundSnowTempStart() {
        return fourthRoundSnowTempStart;
    }

    public void setFourthRoundSnowTempStart(BigDecimal fourthRoundSnowTempStart) {
        this.fourthRoundSnowTempStart = fourthRoundSnowTempStart;
    }

    public BigDecimal getFourthRoundSnowTempFinish() {
        return fourthRoundSnowTempFinish;
    }

    public void setFourthRoundSnowTempFinish(BigDecimal fourthRoundSnowTempFinish) {
        this.fourthRoundSnowTempFinish = fourthRoundSnowTempFinish;
    }

    public BigDecimal getFourthRoundHumidityStart() {
        return fourthRoundHumidityStart;
    }

    public void setFourthRoundHumidityStart(BigDecimal fourthRoundHumidityStart) {
        this.fourthRoundHumidityStart = fourthRoundHumidityStart;
    }

    public BigDecimal getFourthRoundHumidityFinish() {
        return fourthRoundHumidityFinish;
    }

    public void setFourthRoundHumidityFinish(BigDecimal fourthRoundHumidityFinish) {
        this.fourthRoundHumidityFinish = fourthRoundHumidityFinish;
    }

    public BigDecimal getFourthRoundMinWind() {
        return fourthRoundMinWind;
    }

    public void setFourthRoundMinWind(BigDecimal fourthRoundMinWind) {
        this.fourthRoundMinWind = fourthRoundMinWind;
    }

    public BigDecimal getFourthRoundMaxWind() {
        return fourthRoundMaxWind;
    }

    public void setFourthRoundMaxWind(BigDecimal fourthRoundMaxWind) {
        this.fourthRoundMaxWind = fourthRoundMaxWind;
    }

    public BigDecimal getFourthRoundAvgWind() {
        return fourthRoundAvgWind;
    }

    public void setFourthRoundAvgWind(BigDecimal fourthRoundAvgWind) {
        this.fourthRoundAvgWind = fourthRoundAvgWind;
    }

    @Override
    public String toString() {
        return "Competition{" +
                "id=" + id +
                ", season=" + season +
                ", date1=" + date1 +
                ", date2=" + date2 +
                ", seriesMajor=" + seriesMajor +
                ", seriesMinor=" + seriesMinor +
                ", hillVersion=" + hillVersion +
                ", judgeA=" + judgeA +
                ", judgeB=" + judgeB +
                ", judgeC=" + judgeC +
                ", judgeD=" + judgeD +
                ", judgeE=" + judgeE +
                ", judgeSC=" + judgeSC +
                ", raceDirector=" + raceDirector +
                ", technicalDelegate=" + technicalDelegate +
                ", chiefOfCompetition=" + chiefOfCompetition +
                ", assistantTD=" + assistantTD +
                ", assistantRD=" + assistantRD +
                ", equipmentController1=" + equipmentController1 +
                ", equipmentController2=" + equipmentController2 +
                ", meterValue=" + meterValue +
                ", gateFactor=" + gateFactor +
                ", windFactorTail=" + windFactorTail +
                ", windFactorFront=" + windFactorFront +
                ", firstRoundStartTime=" + firstRoundStartTime +
                ", firstRoundEndTime=" + firstRoundEndTime +
                ", firstRoundBaseGate=" + firstRoundBaseGate +
                ", firstRoundWeather=" + firstRoundWeather +
                ", firstRoundAirTempStart=" + firstRoundAirTempStart +
                ", firstRoundAirTempFinish=" + firstRoundAirTempFinish +
                ", firstRoundSnowTempStart=" + firstRoundSnowTempStart +
                ", firstRoundSnowTempFinish=" + firstRoundSnowTempFinish +
                ", firstRoundHumidityStart=" + firstRoundHumidityStart +
                ", firstRoundHumidityFinish=" + firstRoundHumidityFinish +
                ", firstRoundMinWind=" + firstRoundMinWind +
                ", firstRoundMaxWind=" + firstRoundMaxWind +
                ", firstRoundAvgWind=" + firstRoundAvgWind +
                ", secondRoundStartTime=" + secondRoundStartTime +
                ", secondRoundEndTime=" + secondRoundEndTime +
                ", secondRoundBaseGate=" + secondRoundBaseGate +
                ", secondRoundWeather=" + secondRoundWeather +
                ", secondRoundAirTempStart=" + secondRoundAirTempStart +
                ", secondRoundAirTempFinish=" + secondRoundAirTempFinish +
                ", secondRoundSnowTempStart=" + secondRoundSnowTempStart +
                ", secondRoundSnowTempFinish=" + secondRoundSnowTempFinish +
                ", secondRoundHumidityStart=" + secondRoundHumidityStart +
                ", secondRoundHumidityFinish=" + secondRoundHumidityFinish +
                ", secondRoundMinWind=" + secondRoundMinWind +
                ", secondRoundMaxWind=" + secondRoundMaxWind +
                ", secondRoundAvgWind=" + secondRoundAvgWind +
                ", thirdRoundStartTime=" + thirdRoundStartTime +
                ", thirdRoundEndTime=" + thirdRoundEndTime +
                ", thirdRoundBaseGate=" + thirdRoundBaseGate +
                ", thirdRoundWeather=" + thirdRoundWeather +
                ", thirdRoundAirTempStart=" + thirdRoundAirTempStart +
                ", thirdRoundAirTempFinish=" + thirdRoundAirTempFinish +
                ", thirdRoundSnowTempStart=" + thirdRoundSnowTempStart +
                ", thirdRoundSnowTempFinish=" + thirdRoundSnowTempFinish +
                ", thirdRoundHumidityStart=" + thirdRoundHumidityStart +
                ", thirdRoundHumidityFinish=" + thirdRoundHumidityFinish +
                ", thirdRoundMinWind=" + thirdRoundMinWind +
                ", thirdRoundMaxWind=" + thirdRoundMaxWind +
                ", thirdRoundAvgWind=" + thirdRoundAvgWind +
                ", fourthRoundStartTime=" + fourthRoundStartTime +
                ", fourthRoundEndTime=" + fourthRoundEndTime +
                ", fourthRoundBaseGate=" + fourthRoundBaseGate +
                ", fourthRoundWeather=" + fourthRoundWeather +
                ", fourthRoundAirTempStart=" + fourthRoundAirTempStart +
                ", fourthRoundAirTempFinish=" + fourthRoundAirTempFinish +
                ", fourthRoundSnowTempStart=" + fourthRoundSnowTempStart +
                ", fourthRoundSnowTempFinish=" + fourthRoundSnowTempFinish +
                ", fourthRoundHumidityStart=" + fourthRoundHumidityStart +
                ", fourthRoundHumidityFinish=" + fourthRoundHumidityFinish +
                ", fourthRoundMinWind=" + fourthRoundMinWind +
                ", fourthRoundMaxWind=" + fourthRoundMaxWind +
                ", fourthRoundAvgWind=" + fourthRoundAvgWind +
                '}';
    }
}
