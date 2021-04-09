package com.lipskii.ski_jumping_system.dto;

import com.lipskii.ski_jumping_system.entity.Result;

import java.math.BigDecimal;

public class HillRecordDTO {
    private Result result;
    private BigDecimal hillRecord;

    public HillRecordDTO() {
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public BigDecimal getHillRecord() {
        return hillRecord;
    }

    public void setHillRecord(BigDecimal hillRecord) {
        this.hillRecord = hillRecord;
    }

    @Override
    public String toString() {
        return "HillRecordDTO{" +
                "result=" + result.getSkiJumper().getPerson().getLastName() +
                ", hillRecord=" + hillRecord +
                '}';
    }
}
