package com.lipskii.ski_jumping_system.dto;

import com.lipskii.ski_jumping_system.entity.Competition;
import com.lipskii.ski_jumping_system.entity.SkiJumper;

import java.math.BigDecimal;

public class HillRecordDTO {
    private BigDecimal hillRecord;
    private SkiJumper skiJumper;
    private Competition competition;


    public BigDecimal getHillRecord() {
        return hillRecord;
    }

    public void setHillRecord(BigDecimal hillRecord) {
        this.hillRecord = hillRecord;
    }

    public SkiJumper getSkiJumper() {
        return skiJumper;
    }

    public void setSkiJumper(SkiJumper skiJumper) {
        this.skiJumper = skiJumper;
    }

    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }

    @Override
    public String toString() {
        return "HillRecordDTO{" +
                "hillRecord=" + hillRecord +
                ", skiJumper=" + skiJumper +
                ", competition=" + competition +
                '}';
    }
}
