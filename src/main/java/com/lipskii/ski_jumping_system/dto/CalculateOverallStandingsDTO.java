package com.lipskii.ski_jumping_system.dto;

public class CalculateOverallStandingsDTO {

    private int seriesId;

    private int season;

    public CalculateOverallStandingsDTO() {
    }

    public CalculateOverallStandingsDTO(int seriesId, int season) {
        this.seriesId = seriesId;
        this.season = season;
    }

    public int getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(int seriesId) {
        this.seriesId = seriesId;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    @Override
    public String toString() {
        return "CalculateOverallStandingsDTO{" +
                "seriesId=" + seriesId +
                ", season=" + season +
                '}';
    }
}
