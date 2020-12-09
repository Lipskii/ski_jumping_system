package com.lipskii.ski_jumping_system.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "all_time_points_system")
public class AllTimePointsSystem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idall_time_points_system")
    private int id;

    @Column(name = "pos_1")
    private BigDecimal pos1;

    @Column(name = "pos_2")
    private BigDecimal pos2;

    @Column(name = "pos_3")
    private BigDecimal pos3;

    @Column(name = "pos_4")
    private BigDecimal pos4;

    @Column(name = "pos_5")
    private BigDecimal pos5;

    @Column(name = "pos_6")
    private BigDecimal pos6;

    @Column(name = "pos_7")
    private BigDecimal pos7;

    @Column(name = "pos_8")
    private BigDecimal pos8;

    @Column(name = "pos_9")
    private BigDecimal pos9;

    @Column(name = "pos_10")
    private BigDecimal pos10;

    @Column(name = "pos_11")
    private BigDecimal pos11;

    @Column(name = "pos_12")
    private BigDecimal pos12;

    @Column(name = "pos_13")
    private BigDecimal pos13;

    @Column(name = "pos_14")
    private BigDecimal pos14;

    public AllTimePointsSystem() {
    }

    public AllTimePointsSystem(BigDecimal pos1, BigDecimal pos2, BigDecimal pos3, BigDecimal pos4,
                               BigDecimal pos5, BigDecimal pos6, BigDecimal pos7, BigDecimal pos8,
                               BigDecimal pos9, BigDecimal pos10, BigDecimal pos11, BigDecimal pos12,
                               BigDecimal pos13, BigDecimal pos14) {
        this.pos1 = pos1;
        this.pos2 = pos2;
        this.pos3 = pos3;
        this.pos4 = pos4;
        this.pos5 = pos5;
        this.pos6 = pos6;
        this.pos7 = pos7;
        this.pos8 = pos8;
        this.pos9 = pos9;
        this.pos10 = pos10;
        this.pos11 = pos11;
        this.pos12 = pos12;
        this.pos13 = pos13;
        this.pos14 = pos14;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getPos1() {
        return pos1;
    }

    public void setPos1(BigDecimal pos1) {
        this.pos1 = pos1;
    }

    public BigDecimal getPos2() {
        return pos2;
    }

    public void setPos2(BigDecimal pos2) {
        this.pos2 = pos2;
    }

    public BigDecimal getPos3() {
        return pos3;
    }

    public void setPos3(BigDecimal pos3) {
        this.pos3 = pos3;
    }

    public BigDecimal getPos4() {
        return pos4;
    }

    public void setPos4(BigDecimal pos4) {
        this.pos4 = pos4;
    }

    public BigDecimal getPos5() {
        return pos5;
    }

    public void setPos5(BigDecimal pos5) {
        this.pos5 = pos5;
    }

    public BigDecimal getPos6() {
        return pos6;
    }

    public void setPos6(BigDecimal pos6) {
        this.pos6 = pos6;
    }

    public BigDecimal getPos7() {
        return pos7;
    }

    public void setPos7(BigDecimal pos7) {
        this.pos7 = pos7;
    }

    public BigDecimal getPos8() {
        return pos8;
    }

    public void setPos8(BigDecimal pos8) {
        this.pos8 = pos8;
    }

    public BigDecimal getPos9() {
        return pos9;
    }

    public void setPos9(BigDecimal pos9) {
        this.pos9 = pos9;
    }

    public BigDecimal getPos10() {
        return pos10;
    }

    public void setPos10(BigDecimal pos10) {
        this.pos10 = pos10;
    }

    public BigDecimal getPos11() {
        return pos11;
    }

    public void setPos11(BigDecimal pos11) {
        this.pos11 = pos11;
    }

    public BigDecimal getPos12() {
        return pos12;
    }

    public void setPos12(BigDecimal pos12) {
        this.pos12 = pos12;
    }

    public BigDecimal getPos13() {
        return pos13;
    }

    public void setPos13(BigDecimal pos13) {
        this.pos13 = pos13;
    }

    public BigDecimal getPos14() {
        return pos14;
    }

    public void setPos14(BigDecimal pos14) {
        this.pos14 = pos14;
    }

    @Override
    public String toString() {
        return "AllTimePointsSystem{" +
                "id=" + id +
                ", pos1=" + pos1 +
                ", pos2=" + pos2 +
                ", pos3=" + pos3 +
                ", pos4=" + pos4 +
                ", pos5=" + pos5 +
                ", pos6=" + pos6 +
                ", pos7=" + pos7 +
                ", pos8=" + pos8 +
                ", pos9=" + pos9 +
                ", pos10=" + pos10 +
                ", pos11=" + pos11 +
                ", pos12=" + pos12 +
                ", pos13=" + pos13 +
                ", pos14=" + pos14 +
                '}';
    }
}
