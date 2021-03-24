package com.lipskii.ski_jumping_system.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "result")
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idresult")
    private int id;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH})
    @JsonIgnoreProperties("results")
    @JoinColumn(name = "competition_idcompetition")
    private Competition competition;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH})
    @JsonIgnoreProperties("results")
    @JoinColumn(name = "ski_jumper_idski_jumper")
    private SkiJumper skiJumper;

    @JsonBackReference
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "disqualification_type_iddisqualification_type")
    private DisqualificationType disqualificationType;

    @Column(name = "first_round_speed")
    private BigDecimal firstRoundSpeed;

    @Column(name = "first_round_distance")
    private BigDecimal firstRoundDistance;

    @Column(name = "first_round_distance_points")
    private BigDecimal firstRoundDistancePoints;

    @Column(name = "first_round_judge_a")
    private BigDecimal firstRoundJudgeA;

    @Column(name = "first_round_judge_b")
    private BigDecimal firstRoundJudgeB;

    @Column(name = "first_round_judge_c")
    private BigDecimal firstRoundJudgeC;

    @Column(name = "first_round_judge_d")
    private BigDecimal firstRoundJudgeD;

    @Column(name = "first_round_judge_e")
    private BigDecimal firstRoundJudgeE;

    @Column(name = "first_round_judge_points")
    private BigDecimal firstRoundJudgePoints;

    @Column(name = "first_round_gate")
    private BigDecimal firstRoundGate;

    @Column(name = "first_round_gate_coach_request")
    private boolean firstRoundGateCoachRequest;

    @Column(name = "first_round_gate_points")
    private BigDecimal firstRoundGatePoints;

    @Column(name = "first_round_total")
    private BigDecimal firstRoundTotal;

    @Column(name = "first_round_rank")
    private int firstRoundRank;

    @Column(name = "second_round_speed")
    private BigDecimal secondRoundSpeed;

    @Column(name = "second_round_distance")
    private BigDecimal secondRoundDistance;

    @Column(name = "second_round_distance_points")
    private BigDecimal secondRoundDistancePoints;

    @Column(name = "second_round_judge_a")
    private BigDecimal secondRoundJudgeA;

    @Column(name = "second_round_judge_b")
    private BigDecimal secondRoundJudgeB;

    @Column(name = "second_round_judge_c")
    private BigDecimal secondRoundJudgeC;

    @Column(name = "second_round_judge_d")
    private BigDecimal secondRoundJudgeD;

    @Column(name = "second_round_judge_e")
    private BigDecimal secondRoundJudgeE;

    @Column(name = "second_round_judge_points")
    private BigDecimal secondRoundJudgePoints;

    @Column(name = "second_round_gate")
    private BigDecimal secondRoundGate;

    @Column(name = "second_round_gate_coach_request")
    private boolean secondRoundGateCoachRequest;

    @Column(name = "second_round_gate_points")
    private BigDecimal secondRoundGatePoints;

    @Column(name = "second_round_total")
    private BigDecimal secondRoundTotal;

    @Column(name = "second_round_rank")
    private int secondRoundRank;

    @Column(name = "third_round_speed")
    private BigDecimal thirdRoundSpeed;

    @Column(name = "third_round_distance")
    private BigDecimal thirdRoundDistance;

    @Column(name = "third_round_distance_points")
    private BigDecimal thirdRoundDistancePoints;

    @Column(name = "third_round_judge_a")
    private BigDecimal thirdRoundJudgeA;

    @Column(name = "third_round_judge_b")
    private BigDecimal thirdRoundJudgeB;

    @Column(name = "third_round_judge_c")
    private BigDecimal thirdRoundJudgeC;

    @Column(name = "third_round_judge_d")
    private BigDecimal thirdRoundJudgeD;

    @Column(name = "third_round_judge_e")
    private BigDecimal thirdRoundJudgeE;

    @Column(name = "third_round_judge_points")
    private BigDecimal thirdRoundJudgePoints;

    @Column(name = "third_round_gate")
    private BigDecimal thirdRoundGate;

    @Column(name = "third_round_gate_coach_request")
    private boolean thirdRoundGateCoachRequest;

    @Column(name = "third_round_gate_points")
    private BigDecimal thirdRoundGatePoints;

    @Column(name = "third_round_total")
    private BigDecimal thirdRoundTotal;

    @Column(name = "third_round_rank")
    private int thirdRoundRank;

    @Column(name = "fourth_round_speed")
    private BigDecimal fourthRoundSpeed;

    @Column(name = "fourth_round_distance")
    private BigDecimal fourthRoundDistance;

    @Column(name = "fourth_round_distance_points")
    private BigDecimal fourthRoundDistancePoints;

    @Column(name = "fourth_round_judge_a")
    private BigDecimal fourthRoundJudgeA;

    @Column(name = "fourth_round_judge_b")
    private BigDecimal fourthRoundJudgeB;

    @Column(name = "fourth_round_judge_c")
    private BigDecimal fourthRoundJudgeC;

    @Column(name = "fourth_round_judge_d")
    private BigDecimal fourthRoundJudgeD;

    @Column(name = "fourth_round_judge_e")
    private BigDecimal fourthRoundJudgeE;

    @Column(name = "fourth_round_judge_points")
    private BigDecimal fourthRoundJudgePoints;

    @Column(name = "fourth_round_gate")
    private BigDecimal fourthRoundGate;

    @Column(name = "fourth_round_gate_coach_request")
    private boolean fourthRoundGateCoachRequest;

    @Column(name = "fourth_round_gate_points")
    private BigDecimal fourthRoundGatePoints;

    @Column(name = "fourth_round_total")
    private BigDecimal fourthRoundTotal;

    @Column(name = "fourth_round_rank")
    private int fourthRoundRank;

    @Column(name = "total_points")
    private BigDecimal totalPoints;

    @Column(name = "total_rank")
    private int totalRank;

    public Result() {
    }

    public Result(Competition competition, SkiJumper skiJumper, DisqualificationType disqualificationType, BigDecimal firstRoundSpeed, BigDecimal firstRoundDistance, BigDecimal firstRoundDistancePoints, BigDecimal firstRoundJudgeA, BigDecimal firstRoundJudgeB, BigDecimal firstRoundJudgeC, BigDecimal firstRoundJudgeD, BigDecimal firstRoundJudgeE, BigDecimal firstRoundJudgePoints, BigDecimal firstRoundGate, boolean firstRoundGateCoachRequest, BigDecimal firstRoundGatePoints, BigDecimal firstRoundTotal, int firstRoundRank, BigDecimal secondRoundSpeed, BigDecimal secondRoundDistance, BigDecimal secondRoundDistancePoints, BigDecimal secondRoundJudgeA, BigDecimal secondRoundJudgeB, BigDecimal secondRoundJudgeC, BigDecimal secondRoundJudgeD, BigDecimal secondRoundJudgeE, BigDecimal secondRoundJudgePoints, BigDecimal secondRoundGate, boolean secondRoundGateCoachRequest, BigDecimal secondRoundGatePoints, BigDecimal secondRoundTotal, int secondRoundRank, BigDecimal thirdRoundSpeed, BigDecimal thirdRoundDistance, BigDecimal thirdRoundDistancePoints, BigDecimal thirdRoundJudgeA, BigDecimal thirdRoundJudgeB, BigDecimal thirdRoundJudgeC, BigDecimal thirdRoundJudgeD, BigDecimal thirdRoundJudgeE, BigDecimal thirdRoundJudgePoints, BigDecimal thirdRoundGate, boolean thirdRoundGateCoachRequest, BigDecimal thirdRoundGatePoints, BigDecimal thirdRoundTotal, int thirdRoundRank, BigDecimal fourthRoundSpeed, BigDecimal fourthRoundDistance, BigDecimal fourthRoundDistancePoints, BigDecimal fourthRoundJudgeA, BigDecimal fourthRoundJudgeB, BigDecimal fourthRoundJudgeC, BigDecimal fourthRoundJudgeD, BigDecimal fourthRoundJudgeE, BigDecimal fourthRoundJudgePoints, BigDecimal fourthRoundGate, boolean fourthRoundGateCoachRequest, BigDecimal fourthRoundGatePoints, BigDecimal fourthRoundTotal, int fourthRoundRank, BigDecimal totalPoints, int totalRank) {
        this.competition = competition;
        this.skiJumper = skiJumper;
        this.disqualificationType = disqualificationType;
        this.firstRoundSpeed = firstRoundSpeed;
        this.firstRoundDistance = firstRoundDistance;
        this.firstRoundDistancePoints = firstRoundDistancePoints;
        this.firstRoundJudgeA = firstRoundJudgeA;
        this.firstRoundJudgeB = firstRoundJudgeB;
        this.firstRoundJudgeC = firstRoundJudgeC;
        this.firstRoundJudgeD = firstRoundJudgeD;
        this.firstRoundJudgeE = firstRoundJudgeE;
        this.firstRoundJudgePoints = firstRoundJudgePoints;
        this.firstRoundGate = firstRoundGate;
        this.firstRoundGateCoachRequest = firstRoundGateCoachRequest;
        this.firstRoundGatePoints = firstRoundGatePoints;
        this.firstRoundTotal = firstRoundTotal;
        this.firstRoundRank = firstRoundRank;
        this.secondRoundSpeed = secondRoundSpeed;
        this.secondRoundDistance = secondRoundDistance;
        this.secondRoundDistancePoints = secondRoundDistancePoints;
        this.secondRoundJudgeA = secondRoundJudgeA;
        this.secondRoundJudgeB = secondRoundJudgeB;
        this.secondRoundJudgeC = secondRoundJudgeC;
        this.secondRoundJudgeD = secondRoundJudgeD;
        this.secondRoundJudgeE = secondRoundJudgeE;
        this.secondRoundJudgePoints = secondRoundJudgePoints;
        this.secondRoundGate = secondRoundGate;
        this.secondRoundGateCoachRequest = secondRoundGateCoachRequest;
        this.secondRoundGatePoints = secondRoundGatePoints;
        this.secondRoundTotal = secondRoundTotal;
        this.secondRoundRank = secondRoundRank;
        this.thirdRoundSpeed = thirdRoundSpeed;
        this.thirdRoundDistance = thirdRoundDistance;
        this.thirdRoundDistancePoints = thirdRoundDistancePoints;
        this.thirdRoundJudgeA = thirdRoundJudgeA;
        this.thirdRoundJudgeB = thirdRoundJudgeB;
        this.thirdRoundJudgeC = thirdRoundJudgeC;
        this.thirdRoundJudgeD = thirdRoundJudgeD;
        this.thirdRoundJudgeE = thirdRoundJudgeE;
        this.thirdRoundJudgePoints = thirdRoundJudgePoints;
        this.thirdRoundGate = thirdRoundGate;
        this.thirdRoundGateCoachRequest = thirdRoundGateCoachRequest;
        this.thirdRoundGatePoints = thirdRoundGatePoints;
        this.thirdRoundTotal = thirdRoundTotal;
        this.thirdRoundRank = thirdRoundRank;
        this.fourthRoundSpeed = fourthRoundSpeed;
        this.fourthRoundDistance = fourthRoundDistance;
        this.fourthRoundDistancePoints = fourthRoundDistancePoints;
        this.fourthRoundJudgeA = fourthRoundJudgeA;
        this.fourthRoundJudgeB = fourthRoundJudgeB;
        this.fourthRoundJudgeC = fourthRoundJudgeC;
        this.fourthRoundJudgeD = fourthRoundJudgeD;
        this.fourthRoundJudgeE = fourthRoundJudgeE;
        this.fourthRoundJudgePoints = fourthRoundJudgePoints;
        this.fourthRoundGate = fourthRoundGate;
        this.fourthRoundGateCoachRequest = fourthRoundGateCoachRequest;
        this.fourthRoundGatePoints = fourthRoundGatePoints;
        this.fourthRoundTotal = fourthRoundTotal;
        this.fourthRoundRank = fourthRoundRank;
        this.totalPoints = totalPoints;
        this.totalRank = totalRank;
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

    public SkiJumper getSkiJumper() {
        return skiJumper;
    }

    public void setSkiJumper(SkiJumper skiJumper) {
        this.skiJumper = skiJumper;
    }

    public DisqualificationType getDisqualificationType() {
        return disqualificationType;
    }

    public void setDisqualificationType(DisqualificationType disqualificationType) {
        this.disqualificationType = disqualificationType;
    }

    public BigDecimal getFirstRoundSpeed() {
        return firstRoundSpeed;
    }

    public void setFirstRoundSpeed(BigDecimal firstRoundSpeed) {
        this.firstRoundSpeed = firstRoundSpeed;
    }

    public BigDecimal getFirstRoundDistance() {
        return firstRoundDistance;
    }

    public void setFirstRoundDistance(BigDecimal firstRoundDistance) {
        this.firstRoundDistance = firstRoundDistance;
    }

    public BigDecimal getFirstRoundDistancePoints() {
        return firstRoundDistancePoints;
    }

    public void setFirstRoundDistancePoints(BigDecimal firstRoundDistancePoints) {
        this.firstRoundDistancePoints = firstRoundDistancePoints;
    }

    public BigDecimal getFirstRoundJudgeA() {
        return firstRoundJudgeA;
    }

    public void setFirstRoundJudgeA(BigDecimal firstRoundJudgeA) {
        this.firstRoundJudgeA = firstRoundJudgeA;
    }

    public BigDecimal getFirstRoundJudgeB() {
        return firstRoundJudgeB;
    }

    public void setFirstRoundJudgeB(BigDecimal firstRoundJudgeB) {
        this.firstRoundJudgeB = firstRoundJudgeB;
    }

    public BigDecimal getFirstRoundJudgeC() {
        return firstRoundJudgeC;
    }

    public void setFirstRoundJudgeC(BigDecimal firstRoundJudgeC) {
        this.firstRoundJudgeC = firstRoundJudgeC;
    }

    public BigDecimal getFirstRoundJudgeD() {
        return firstRoundJudgeD;
    }

    public void setFirstRoundJudgeD(BigDecimal firstRoundJudgeD) {
        this.firstRoundJudgeD = firstRoundJudgeD;
    }

    public BigDecimal getFirstRoundJudgeE() {
        return firstRoundJudgeE;
    }

    public void setFirstRoundJudgeE(BigDecimal firstRoundJudgeE) {
        this.firstRoundJudgeE = firstRoundJudgeE;
    }

    public BigDecimal getFirstRoundJudgePoints() {
        return firstRoundJudgePoints;
    }

    public void setFirstRoundJudgePoints(BigDecimal firstRoundJudgePoints) {
        this.firstRoundJudgePoints = firstRoundJudgePoints;
    }

    public BigDecimal getFirstRoundGate() {
        return firstRoundGate;
    }

    public void setFirstRoundGate(BigDecimal firstRoundGate) {
        this.firstRoundGate = firstRoundGate;
    }

    public boolean isFirstRoundGateCoachRequest() {
        return firstRoundGateCoachRequest;
    }

    public void setFirstRoundGateCoachRequest(boolean firstRoundGateCoachRequest) {
        this.firstRoundGateCoachRequest = firstRoundGateCoachRequest;
    }

    public BigDecimal getFirstRoundGatePoints() {
        return firstRoundGatePoints;
    }

    public void setFirstRoundGatePoints(BigDecimal firstRoundGatePoints) {
        this.firstRoundGatePoints = firstRoundGatePoints;
    }

    public BigDecimal getFirstRoundTotal() {
        return firstRoundTotal;
    }

    public void setFirstRoundTotal(BigDecimal firstRoundTotal) {
        this.firstRoundTotal = firstRoundTotal;
    }

    public int getFirstRoundRank() {
        return firstRoundRank;
    }

    public void setFirstRoundRank(int firstRoundRank) {
        this.firstRoundRank = firstRoundRank;
    }

    public BigDecimal getSecondRoundSpeed() {
        return secondRoundSpeed;
    }

    public void setSecondRoundSpeed(BigDecimal secondRoundSpeed) {
        this.secondRoundSpeed = secondRoundSpeed;
    }

    public BigDecimal getSecondRoundDistance() {
        return secondRoundDistance;
    }

    public void setSecondRoundDistance(BigDecimal secondRoundDistance) {
        this.secondRoundDistance = secondRoundDistance;
    }

    public BigDecimal getSecondRoundDistancePoints() {
        return secondRoundDistancePoints;
    }

    public void setSecondRoundDistancePoints(BigDecimal secondRoundDistancePoints) {
        this.secondRoundDistancePoints = secondRoundDistancePoints;
    }

    public BigDecimal getSecondRoundJudgeA() {
        return secondRoundJudgeA;
    }

    public void setSecondRoundJudgeA(BigDecimal secondRoundJudgeA) {
        this.secondRoundJudgeA = secondRoundJudgeA;
    }

    public BigDecimal getSecondRoundJudgeB() {
        return secondRoundJudgeB;
    }

    public void setSecondRoundJudgeB(BigDecimal secondRoundJudgeB) {
        this.secondRoundJudgeB = secondRoundJudgeB;
    }

    public BigDecimal getSecondRoundJudgeC() {
        return secondRoundJudgeC;
    }

    public void setSecondRoundJudgeC(BigDecimal secondRoundJudgeC) {
        this.secondRoundJudgeC = secondRoundJudgeC;
    }

    public BigDecimal getSecondRoundJudgeD() {
        return secondRoundJudgeD;
    }

    public void setSecondRoundJudgeD(BigDecimal secondRoundJudgeD) {
        this.secondRoundJudgeD = secondRoundJudgeD;
    }

    public BigDecimal getSecondRoundJudgeE() {
        return secondRoundJudgeE;
    }

    public void setSecondRoundJudgeE(BigDecimal secondRoundJudgeE) {
        this.secondRoundJudgeE = secondRoundJudgeE;
    }

    public BigDecimal getSecondRoundJudgePoints() {
        return secondRoundJudgePoints;
    }

    public void setSecondRoundJudgePoints(BigDecimal secondRoundJudgePoints) {
        this.secondRoundJudgePoints = secondRoundJudgePoints;
    }

    public BigDecimal getSecondRoundGate() {
        return secondRoundGate;
    }

    public void setSecondRoundGate(BigDecimal secondRoundGate) {
        this.secondRoundGate = secondRoundGate;
    }

    public boolean isSecondRoundGateCoachRequest() {
        return secondRoundGateCoachRequest;
    }

    public void setSecondRoundGateCoachRequest(boolean secondRoundGateCoachRequest) {
        this.secondRoundGateCoachRequest = secondRoundGateCoachRequest;
    }

    public BigDecimal getSecondRoundGatePoints() {
        return secondRoundGatePoints;
    }

    public void setSecondRoundGatePoints(BigDecimal secondRoundGatePoints) {
        this.secondRoundGatePoints = secondRoundGatePoints;
    }

    public BigDecimal getSecondRoundTotal() {
        return secondRoundTotal;
    }

    public void setSecondRoundTotal(BigDecimal secondRoundTotal) {
        this.secondRoundTotal = secondRoundTotal;
    }

    public int getSecondRoundRank() {
        return secondRoundRank;
    }

    public void setSecondRoundRank(int secondRoundRank) {
        this.secondRoundRank = secondRoundRank;
    }

    public BigDecimal getThirdRoundSpeed() {
        return thirdRoundSpeed;
    }

    public void setThirdRoundSpeed(BigDecimal thirdRoundSpeed) {
        this.thirdRoundSpeed = thirdRoundSpeed;
    }

    public BigDecimal getThirdRoundDistance() {
        return thirdRoundDistance;
    }

    public void setThirdRoundDistance(BigDecimal thirdRoundDistance) {
        this.thirdRoundDistance = thirdRoundDistance;
    }

    public BigDecimal getThirdRoundDistancePoints() {
        return thirdRoundDistancePoints;
    }

    public void setThirdRoundDistancePoints(BigDecimal thirdRoundDistancePoints) {
        this.thirdRoundDistancePoints = thirdRoundDistancePoints;
    }

    public BigDecimal getThirdRoundJudgeA() {
        return thirdRoundJudgeA;
    }

    public void setThirdRoundJudgeA(BigDecimal thirdRoundJudgeA) {
        this.thirdRoundJudgeA = thirdRoundJudgeA;
    }

    public BigDecimal getThirdRoundJudgeB() {
        return thirdRoundJudgeB;
    }

    public void setThirdRoundJudgeB(BigDecimal thirdRoundJudgeB) {
        this.thirdRoundJudgeB = thirdRoundJudgeB;
    }

    public BigDecimal getThirdRoundJudgeC() {
        return thirdRoundJudgeC;
    }

    public void setThirdRoundJudgeC(BigDecimal thirdRoundJudgeC) {
        this.thirdRoundJudgeC = thirdRoundJudgeC;
    }

    public BigDecimal getThirdRoundJudgeD() {
        return thirdRoundJudgeD;
    }

    public void setThirdRoundJudgeD(BigDecimal thirdRoundJudgeD) {
        this.thirdRoundJudgeD = thirdRoundJudgeD;
    }

    public BigDecimal getThirdRoundJudgeE() {
        return thirdRoundJudgeE;
    }

    public void setThirdRoundJudgeE(BigDecimal thirdRoundJudgeE) {
        this.thirdRoundJudgeE = thirdRoundJudgeE;
    }

    public BigDecimal getThirdRoundJudgePoints() {
        return thirdRoundJudgePoints;
    }

    public void setThirdRoundJudgePoints(BigDecimal thirdRoundJudgePoints) {
        this.thirdRoundJudgePoints = thirdRoundJudgePoints;
    }

    public BigDecimal getThirdRoundGate() {
        return thirdRoundGate;
    }

    public void setThirdRoundGate(BigDecimal thirdRoundGate) {
        this.thirdRoundGate = thirdRoundGate;
    }

    public boolean isThirdRoundGateCoachRequest() {
        return thirdRoundGateCoachRequest;
    }

    public void setThirdRoundGateCoachRequest(boolean thirdRoundGateCoachRequest) {
        this.thirdRoundGateCoachRequest = thirdRoundGateCoachRequest;
    }

    public BigDecimal getThirdRoundGatePoints() {
        return thirdRoundGatePoints;
    }

    public void setThirdRoundGatePoints(BigDecimal thirdRoundGatePoints) {
        this.thirdRoundGatePoints = thirdRoundGatePoints;
    }

    public BigDecimal getThirdRoundTotal() {
        return thirdRoundTotal;
    }

    public void setThirdRoundTotal(BigDecimal thirdRoundTotal) {
        this.thirdRoundTotal = thirdRoundTotal;
    }

    public int getThirdRoundRank() {
        return thirdRoundRank;
    }

    public void setThirdRoundRank(int thirdRoundRank) {
        this.thirdRoundRank = thirdRoundRank;
    }

    public BigDecimal getFourthRoundSpeed() {
        return fourthRoundSpeed;
    }

    public void setFourthRoundSpeed(BigDecimal fourthRoundSpeed) {
        this.fourthRoundSpeed = fourthRoundSpeed;
    }

    public BigDecimal getFourthRoundDistance() {
        return fourthRoundDistance;
    }

    public void setFourthRoundDistance(BigDecimal fourthRoundDistance) {
        this.fourthRoundDistance = fourthRoundDistance;
    }

    public BigDecimal getFourthRoundDistancePoints() {
        return fourthRoundDistancePoints;
    }

    public void setFourthRoundDistancePoints(BigDecimal fourthRoundDistancePoints) {
        this.fourthRoundDistancePoints = fourthRoundDistancePoints;
    }

    public BigDecimal getFourthRoundJudgeA() {
        return fourthRoundJudgeA;
    }

    public void setFourthRoundJudgeA(BigDecimal fourthRoundJudgeA) {
        this.fourthRoundJudgeA = fourthRoundJudgeA;
    }

    public BigDecimal getFourthRoundJudgeB() {
        return fourthRoundJudgeB;
    }

    public void setFourthRoundJudgeB(BigDecimal fourthRoundJudgeB) {
        this.fourthRoundJudgeB = fourthRoundJudgeB;
    }

    public BigDecimal getFourthRoundJudgeC() {
        return fourthRoundJudgeC;
    }

    public void setFourthRoundJudgeC(BigDecimal fourthRoundJudgeC) {
        this.fourthRoundJudgeC = fourthRoundJudgeC;
    }

    public BigDecimal getFourthRoundJudgeD() {
        return fourthRoundJudgeD;
    }

    public void setFourthRoundJudgeD(BigDecimal fourthRoundJudgeD) {
        this.fourthRoundJudgeD = fourthRoundJudgeD;
    }

    public BigDecimal getFourthRoundJudgeE() {
        return fourthRoundJudgeE;
    }

    public void setFourthRoundJudgeE(BigDecimal fourthRoundJudgeE) {
        this.fourthRoundJudgeE = fourthRoundJudgeE;
    }

    public BigDecimal getFourthRoundJudgePoints() {
        return fourthRoundJudgePoints;
    }

    public void setFourthRoundJudgePoints(BigDecimal fourthRoundJudgePoints) {
        this.fourthRoundJudgePoints = fourthRoundJudgePoints;
    }

    public BigDecimal getFourthRoundGate() {
        return fourthRoundGate;
    }

    public void setFourthRoundGate(BigDecimal fourthRoundGate) {
        this.fourthRoundGate = fourthRoundGate;
    }

    public boolean isFourthRoundGateCoachRequest() {
        return fourthRoundGateCoachRequest;
    }

    public void setFourthRoundGateCoachRequest(boolean fourthRoundGateCoachRequest) {
        this.fourthRoundGateCoachRequest = fourthRoundGateCoachRequest;
    }

    public BigDecimal getFourthRoundGatePoints() {
        return fourthRoundGatePoints;
    }

    public void setFourthRoundGatePoints(BigDecimal fourthRoundGatePoints) {
        this.fourthRoundGatePoints = fourthRoundGatePoints;
    }

    public BigDecimal getFourthRoundTotal() {
        return fourthRoundTotal;
    }

    public void setFourthRoundTotal(BigDecimal fourthRoundTotal) {
        this.fourthRoundTotal = fourthRoundTotal;
    }

    public int getFourthRoundRank() {
        return fourthRoundRank;
    }

    public void setFourthRoundRank(int fourthRoundRank) {
        this.fourthRoundRank = fourthRoundRank;
    }

    public BigDecimal getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(BigDecimal totalPoints) {
        this.totalPoints = totalPoints;
    }

    public int getTotalRank() {
        return totalRank;
    }

    public void setTotalRank(int totalRank) {
        this.totalRank = totalRank;
    }


}
