package com.lipskii.ski_jumping_system.db_data;

public class FisSearchUri {

    private String code;
    private String decade;

    public FisSearchUri() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDecade() {
        return decade;
    }

    public void setDecade(String decade) {
        this.decade = decade;
    }

    @Override
    public String toString() {
        return "FisSearchUri{" +
                "code='" + code + '\'' +
                ", decade='" + decade + '\'' +
                '}';
    }
}
