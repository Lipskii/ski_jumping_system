package com.lipskii.ski_jumping_system.db_data;

public class FetchedResultsObject {
    private int rank;
    private int code;
    private float firstRoundDistance;
    private float firstRoundPoints;
    private float secondRoundDistance;
    private float secondRoundPoints;
    private float thirdRoundDistance;
    private float thirdRoundPoints;
    private float fourthRoundDistance;
    private float fourthRoundPoints;
    private float totalPoints;


    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public float getFirstRoundDistance() {
        return firstRoundDistance;
    }

    public void setFirstRoundDistance(float firstRoundDistance) {
        this.firstRoundDistance = firstRoundDistance;
    }

    public float getFirstRoundPoints() {
        return firstRoundPoints;
    }

    public void setFirstRoundPoints(float firstRoundPoints) {
        this.firstRoundPoints = firstRoundPoints;
    }

    public float getSecondRoundDistance() {
        return secondRoundDistance;
    }

    public void setSecondRoundDistance(float secondRoundDistance) {
        this.secondRoundDistance = secondRoundDistance;
    }

    public float getSecondRoundPoints() {
        return secondRoundPoints;
    }

    public void setSecondRoundPoints(float secondRoundPoints) {
        this.secondRoundPoints = secondRoundPoints;
    }

    public float getThirdRoundDistance() {
        return thirdRoundDistance;
    }

    public void setThirdRoundDistance(float thirdRoundDistance) {
        this.thirdRoundDistance = thirdRoundDistance;
    }

    public float getThirdRoundPoints() {
        return thirdRoundPoints;
    }

    public void setThirdRoundPoints(float thirdRoundPoints) {
        this.thirdRoundPoints = thirdRoundPoints;
    }

    public float getFourthRoundDistance() {
        return fourthRoundDistance;
    }

    public void setFourthRoundDistance(float fourthRoundDistance) {
        this.fourthRoundDistance = fourthRoundDistance;
    }

    public float getFourthRoundPoints() {
        return fourthRoundPoints;
    }

    public void setFourthRoundPoints(float fourthRoundPoints) {
        this.fourthRoundPoints = fourthRoundPoints;
    }

    public float getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(float totalPoints) {
        this.totalPoints = totalPoints;
    }

    @Override
    public String toString() {
        return "FetchedResultsObject{" +
                "rank=" + rank +
                ", code=" + code +
                ", firstRoundDistance=" + firstRoundDistance +
                ", firstRoundPoints=" + firstRoundPoints +
                ", secondRoundDistance=" + secondRoundDistance +
                ", secondRoundPoints=" + secondRoundPoints +
                ", thirdRoundDistance=" + thirdRoundDistance +
                ", thirdRoundPoints=" + thirdRoundPoints +
                ", fourthRoundDistance=" + fourthRoundDistance +
                ", fourthRoundPoints=" + fourthRoundPoints +
                ", totalPoints=" + totalPoints +
                '}';
    }
}
