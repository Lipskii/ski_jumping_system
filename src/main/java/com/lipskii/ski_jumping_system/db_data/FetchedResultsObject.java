package com.lipskii.ski_jumping_system.db_data;

public class FetchedResultsObject {
    private int rank;
    private int code;
    private float firstRoundDistance;
    private float firstRoundPoints;
    private float secondRoundDistance;
    private float secondRoundPoints;
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
                ", totalPoints=" + totalPoints +
                '}';
    }
}
