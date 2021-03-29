package com.lipskii.ski_jumping_system.dto;

import com.lipskii.ski_jumping_system.entity.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class CompetitionDTO {
    private int id;

    private Season season;

    private LocalDate date1;

    private LocalDate date2;

    private Series seriesMajor;

    private Series seriesMinor;

    private Country country;

    private City city;

    private Venue venue;

    private Hill hill;

    private HillVersion hillVersion;

    private Jury judgeA;

    private Jury judgeB;

    private Jury judgeC;

    private Jury judgeD;

    private Jury judgeE;

    private Jury judgeSC;

    private Jury raceDirector;

    private Jury technicalDelegate;

    private Jury chiefOfCompetition;

    private Jury assistantTD;

    private Jury assistantRD;

    private Jury equipmentController1;

    private Jury equipmentController2;

    private BigDecimal meterValue;

    private BigDecimal gateFactor;

    private BigDecimal windFactorTail;

    private BigDecimal windFactorFront;

    private LocalDateTime firstRoundStartTime;

    private LocalDateTime firstRoundEndTime;

    private int firstRoundBaseGate;

    private Weather firstRoundWeather;

    private BigDecimal firstRoundAirTempStart;

    private BigDecimal firstRoundAirTempFinish;

    private BigDecimal firstRoundSnowTempStart;

    private BigDecimal firstRoundSnowTempFinish;

    private BigDecimal firstRoundHumidityStart;

    private BigDecimal firstRoundHumidityFinish;

    private BigDecimal firstRoundMinWind;

    private BigDecimal firstRoundMaxWind;

    private BigDecimal firstRoundAvgWind;

    private LocalDateTime secondRoundStartTime;

    private LocalDateTime secondRoundEndTime;

    private int secondRoundBaseGate;

    private Weather secondRoundWeather;

    private BigDecimal secondRoundAirTempStart;

    private BigDecimal secondRoundAirTempFinish;

    private BigDecimal secondRoundSnowTempStart;

    private BigDecimal secondRoundSnowTempFinish;

    private BigDecimal secondRoundHumidityStart;

    private BigDecimal secondRoundHumidityFinish;

    private BigDecimal secondRoundMinWind;

    private BigDecimal secondRoundMaxWind;

    private BigDecimal secondRoundAvgWind;

    private LocalDateTime thirdRoundStartTime;

    private LocalDateTime thirdRoundEndTime;

    private int thirdRoundBaseGate;

    private Weather thirdRoundWeather;

    private BigDecimal thirdRoundAirTempStart;

    private BigDecimal thirdRoundAirTempFinish;

    private BigDecimal thirdRoundSnowTempStart;

    private BigDecimal thirdRoundSnowTempFinish;

    private BigDecimal thirdRoundHumidityStart;

    private BigDecimal thirdRoundHumidityFinish;

    private BigDecimal thirdRoundMinWind;

    private BigDecimal thirdRoundMaxWind;

    private BigDecimal thirdRoundAvgWind;

    private LocalDateTime fourthRoundStartTime;

    private LocalDateTime fourthRoundEndTime;

    private int fourthRoundBaseGate;

    private Weather fourthRoundWeather;

    private BigDecimal fourthRoundAirTempStart;

    private BigDecimal fourthRoundAirTempFinish;

    private BigDecimal fourthRoundSnowTempStart;

    private BigDecimal fourthRoundSnowTempFinish;

    private BigDecimal fourthRoundHumidityStart;

    private BigDecimal fourthRoundHumidityFinish;

    private BigDecimal fourthRoundMinWind;

    private BigDecimal fourthRoundMaxWind;

    private BigDecimal fourthRoundAvgWind;

    private String pdfFile;

    private String csvFile;

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

    public LocalDate getDate1() {
        return date1;
    }

    public void setDate1(LocalDate date1) {
        this.date1 = date1;
    }

    public LocalDate getDate2() {
        return date2;
    }

    public void setDate2(LocalDate date2) {
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

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public Hill getHill() {
        return hill;
    }

    public void setHill(Hill hill) {
        this.hill = hill;
    }

    public HillVersion getHillVersion() {
        return hillVersion;
    }

    public void setHillVersion(HillVersion hillVersion) {
        this.hillVersion = hillVersion;
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

    public LocalDateTime getFirstRoundStartTime() {
        return firstRoundStartTime;
    }

    public void setFirstRoundStartTime(LocalDateTime firstRoundStartTime) {
        this.firstRoundStartTime = firstRoundStartTime;
    }

    public LocalDateTime getFirstRoundEndTime() {
        return firstRoundEndTime;
    }

    public void setFirstRoundEndTime(LocalDateTime firstRoundEndTime) {
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

    public LocalDateTime getSecondRoundStartTime() {
        return secondRoundStartTime;
    }

    public void setSecondRoundStartTime(LocalDateTime secondRoundStartTime) {
        this.secondRoundStartTime = secondRoundStartTime;
    }

    public LocalDateTime getSecondRoundEndTime() {
        return secondRoundEndTime;
    }

    public void setSecondRoundEndTime(LocalDateTime secondRoundEndTime) {
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

    public LocalDateTime getThirdRoundStartTime() {
        return thirdRoundStartTime;
    }

    public void setThirdRoundStartTime(LocalDateTime thirdRoundStartTime) {
        this.thirdRoundStartTime = thirdRoundStartTime;
    }

    public LocalDateTime getThirdRoundEndTime() {
        return thirdRoundEndTime;
    }

    public void setThirdRoundEndTime(LocalDateTime thirdRoundEndTime) {
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

    public LocalDateTime getFourthRoundStartTime() {
        return fourthRoundStartTime;
    }

    public void setFourthRoundStartTime(LocalDateTime fourthRoundStartTime) {
        this.fourthRoundStartTime = fourthRoundStartTime;
    }

    public LocalDateTime getFourthRoundEndTime() {
        return fourthRoundEndTime;
    }

    public void setFourthRoundEndTime(LocalDateTime fourthRoundEndTime) {
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

    public String getPdfFile() {
        return pdfFile;
    }

    public void setPdfFile(String pdfFile) {
        this.pdfFile = pdfFile;
    }

    public String getCsvFile() {
        return csvFile;
    }

    public void setCsvFile(String csvFile) {
        this.csvFile = csvFile;
    }
}
