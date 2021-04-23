package com.lipskii.ski_jumping_system.db_data;

public class FetchedTeamResultObject {
    private int rank;
    private String countryCode;
    private float totalPoints;
    private int skiJumper1Code;
    private int skiJumper2Code;
    private int skiJumper3Code;
    private int skiJumper4Code;

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public float getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(float totalPoints) {
        this.totalPoints = totalPoints;
    }

    public int getSkiJumper1Code() {
        return skiJumper1Code;
    }

    public void setSkiJumper1Code(int skiJumper1Code) {
        this.skiJumper1Code = skiJumper1Code;
    }

    public int getSkiJumper2Code() {
        return skiJumper2Code;
    }

    public void setSkiJumper2Code(int skiJumper2Code) {
        this.skiJumper2Code = skiJumper2Code;
    }

    public int getSkiJumper3Code() {
        return skiJumper3Code;
    }

    public void setSkiJumper3Code(int skiJumper3Code) {
        this.skiJumper3Code = skiJumper3Code;
    }

    public int getSkiJumper4Code() {
        return skiJumper4Code;
    }

    public void setSkiJumper4Code(int skiJumper4Code) {
        this.skiJumper4Code = skiJumper4Code;
    }

    @Override
    public String toString() {
        return "FetchedTeamResultObject{" +
                "rank=" + rank +
                ", countryCode='" + countryCode + '\'' +
                ", totalPoints=" + totalPoints +
                ", skiJumper1Code=" + skiJumper1Code +
                ", skiJumper2Code=" + skiJumper2Code +
                ", skiJumper3Code=" + skiJumper3Code +
                ", skiJumper4Code=" + skiJumper4Code +
                '}';
    }
}
