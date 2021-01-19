package com.lipskii.ski_jumping_system.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "result")
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idresult")
    private int id;

    @JsonBackReference
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "competition_idcompetition")
    private Competition competition;

    @JsonBackReference
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
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


}
