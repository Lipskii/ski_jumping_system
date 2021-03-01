package com.lipskii.ski_jumping_system.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "hill_version")
public class HillVersion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idhill_version")
    private int id;

    @JsonBackReference
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "hill_idhill")
    private Hill hill;

    @Column(name = "first_year")
    private Integer first_year;

    @Column(name = "last_year")
    private Integer last_year;

    @Column(name = "k_point")
    private BigDecimal kPoint;

    @Column(name = "hill_size")
    private BigDecimal hillSize;

    /**
     * Length of the inrun from the lowest to the highest start.
     */
    @Column(name = "es")
    private BigDecimal es;

    /**
     * Length of the inrun from the highest start
     */
    @Column(name = "e1")
    private BigDecimal e1;

    @Column(name = "e2")
    private BigDecimal e2;

    @Column(name = "gamma")
    private BigDecimal gamma;

    /**
     * Radius of the transition curve in E2 (End of the transition curve; beginning of the table).
     */
    @Column(name = "r1")
    private BigDecimal r1;

    @Column(name = "t")
    private BigDecimal t;

    @Column(name = "alpha")
    private BigDecimal alpha;

    @Column(name = "s")
    private BigDecimal s;

    /**
     * Speed at the end of the inrun.
     */
    @Column(name = "v0")
    private BigDecimal v0;

    /**
     * Height difference between take-off and K-point.
     */
    @Column(name = "h")
    private BigDecimal h;

    /**
     * Horizontal distance between take-off and K-point.
     */
    @Column(name = "n")
    private BigDecimal n;

    /**
     * Beginning of the landing area.
     */
    @Column(name = "P")
    private BigDecimal p;

    /**
     * Length of the curve between beginning of the landing area (P) and K.
     */
    @Column(name = "l1")
    private BigDecimal l1;

    /**
     * Length of the curve between K and end of the landing area (L).
     */
    @Column(name = "l2")
    private BigDecimal l2;

    /**
     * Angle at P.
     */
    @Column(name = "beta_p")
    private BigDecimal betaP;

    @Column(name = "beta")
    private BigDecimal beta;

    /**
     * Angle at the end of the landing area (L).
     */
    @Column(name = "beta_l")
    private BigDecimal betaL;

    /**
     * End of the landing area.
     */
    @Column(name = "L")
    private BigDecimal l;

    /**
     * Radius of the circular landing area.
     */
    @Column(name = "rl")
    private BigDecimal rl;

    /**
     * Radius of the transition curve from L to U at L.
     */
    @Column(name = "r2l")
    private BigDecimal r2l;

    /**
     * Difference in Height between the takeoff and the lowest point U
     */
    @Column(name = "zu")
    private BigDecimal zu;

    /**
     * Radius of the transition curve from L to U
     * at U (end of the transition curve to the outrun).
     */
    @Column(name = "r2")
    private BigDecimal r2;

    /**
     * Length of the outrun after the end of the transition curve to the outrun.
     */
    @Column(name = "a")
    private BigDecimal a;

    /**
     * Prepared width of the inrun.
     */
    @Column(name = "b1")
    private BigDecimal b1;

    /**
     * Width of the knoll at the base of the takeoff.
     */
    @Column(name = "b2")
    private BigDecimal b2;

    /**
     * Width at K.
     */
    @Column(name = "bk")
    private BigDecimal bk;

    /**
     * Width at the end of the transition curve to the outrun (U).
     */
    @Column(name = "bu")
    private BigDecimal bu;

    /**
     * Horizontal distance between the takeoff and the projected middle of the lowest
     * judge cabin along the jumping hill axis line.
     */
    @Column(name = "d")
    private BigDecimal d;

    /**
     * Horizontal distance between the front of the judge tower
     * and the jumping hill axis line.
     */
    @Column(name = "q")
    private BigDecimal q;

    /**
     * Link to a fis certificate pdf of this version of a hill.
     */
    @Column(name = "fis_certificate")
    private String fisCertificate;

    /**
     * Beginning of fis certificate validity period.
     */
    @Column(name = "valid_since")
    private LocalDate validSince;

    /**
     * Ending of fis certificate validity period.
     */
    @Column(name = "valid_until")
    private LocalDate validUntil;

    public HillVersion() {
    }


    public HillVersion(Hill hill, Integer first_year, Integer last_year, BigDecimal kPoint, BigDecimal hillSize, BigDecimal es, BigDecimal e1, BigDecimal e2, BigDecimal gamma, BigDecimal r1, BigDecimal t, BigDecimal alpha, BigDecimal s, BigDecimal v0, BigDecimal h, BigDecimal n, BigDecimal p, BigDecimal l1, BigDecimal l2, BigDecimal betaP, BigDecimal beta, BigDecimal betaL, BigDecimal l, BigDecimal rl, BigDecimal r2l, BigDecimal zu, BigDecimal r2, BigDecimal a, BigDecimal b1, BigDecimal b2, BigDecimal bk, BigDecimal bu, BigDecimal d, BigDecimal q, String fisCertificate, LocalDate validSince, LocalDate validUntil) {
        this.hill = hill;
        this.first_year = first_year;
        this.last_year = last_year;
        this.kPoint = kPoint;
        this.hillSize = hillSize;
        this.es = es;
        this.e1 = e1;
        this.e2 = e2;
        this.gamma = gamma;
        this.r1 = r1;
        this.t = t;
        this.alpha = alpha;
        this.s = s;
        this.v0 = v0;
        this.h = h;
        this.n = n;
        this.p = p;
        this.l1 = l1;
        this.l2 = l2;
        this.betaP = betaP;
        this.beta = beta;
        this.betaL = betaL;
        this.l = l;
        this.rl = rl;
        this.r2l = r2l;
        this.zu = zu;
        this.r2 = r2;
        this.a = a;
        this.b1 = b1;
        this.b2 = b2;
        this.bk = bk;
        this.bu = bu;
        this.d = d;
        this.q = q;
        this.fisCertificate = fisCertificate;
        this.validSince = validSince;
        this.validUntil = validUntil;
    }

    public HillVersion(Hill hill, Integer first_year, Integer last_year, BigDecimal kPoint, BigDecimal hillSize, BigDecimal es, BigDecimal e1, BigDecimal e2, BigDecimal gamma, BigDecimal r1, BigDecimal t, BigDecimal alpha, BigDecimal s, BigDecimal v0, BigDecimal h, BigDecimal n, BigDecimal p, BigDecimal l1, BigDecimal l2, BigDecimal betaP, BigDecimal beta, BigDecimal betaL, BigDecimal l, BigDecimal rl, BigDecimal zu, BigDecimal r2, BigDecimal a, BigDecimal b1, BigDecimal b2, BigDecimal bk, BigDecimal bu, BigDecimal d, BigDecimal q, String fisCertificate, LocalDate validSince, LocalDate validUntil) {
        this.hill = hill;
        this.first_year = first_year;
        this.last_year = last_year;
        this.kPoint = kPoint;
        this.hillSize = hillSize;
        this.es = es;
        this.e1 = e1;
        this.e2 = e2;
        this.gamma = gamma;
        this.r1 = r1;
        this.t = t;
        this.alpha = alpha;
        this.s = s;
        this.v0 = v0;
        this.h = h;
        this.n = n;
        this.p = p;
        this.l1 = l1;
        this.l2 = l2;
        this.betaP = betaP;
        this.beta = beta;
        this.betaL = betaL;
        this.l = l;
        this.rl = rl;
        this.zu = zu;
        this.r2 = r2;
        this.a = a;
        this.b1 = b1;
        this.b2 = b2;
        this.bk = bk;
        this.bu = bu;
        this.d = d;
        this.q = q;
        this.fisCertificate = fisCertificate;
        this.validSince = validSince;
        this.validUntil = validUntil;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Hill getHill() {
        return hill;
    }

    public void setHill(Hill hill) {
        this.hill = hill;
    }

    public Integer getFirst_year() {
        return first_year;
    }

    public void setFirst_year(Integer first_year) {
        this.first_year = first_year;
    }

    public BigDecimal getR2l() {
        return r2l;
    }

    public void setR2l(BigDecimal r2l) {
        this.r2l = r2l;
    }

    public BigDecimal getZu() {
        return zu;
    }

    public void setZu(BigDecimal zu) {
        this.zu = zu;
    }

    public Integer getLast_year() {
        return last_year;
    }

    public void setLast_year(Integer last_year) {
        this.last_year = last_year;
    }

    public BigDecimal getkPoint() {
        return kPoint;
    }

    public void setkPoint(BigDecimal kPoint) {
        this.kPoint = kPoint;
    }

    public BigDecimal getHillSize() {
        return hillSize;
    }

    public void setHillSize(BigDecimal hillSize) {
        this.hillSize = hillSize;
    }

    public BigDecimal getEs() {
        return es;
    }

    public void setEs(BigDecimal e) {
        this.es = e;
    }

    public BigDecimal getE1() {
        return e1;
    }

    public void setE1(BigDecimal e1) {
        this.e1 = e1;
    }

    public BigDecimal getE2() {
        return e2;
    }

    public void setE2(BigDecimal e2) {
        this.e2 = e2;
    }

    public BigDecimal getGamma() {
        return gamma;
    }

    public void setGamma(BigDecimal inrunAngle) {
        this.gamma = inrunAngle;
    }

    public BigDecimal getR1() {
        return r1;
    }

    public void setR1(BigDecimal r1) {
        this.r1 = r1;
    }

    public BigDecimal getT() {
        return t;
    }

    public void setT(BigDecimal takeOffLength) {
        this.t = takeOffLength;
    }

    public BigDecimal getAlpha() {
        return alpha;
    }

    public void setAlpha(BigDecimal takeOffAngle) {
        this.alpha = takeOffAngle;
    }

    public BigDecimal getS() {
        return s;
    }

    public void setS(BigDecimal takeOffHeight) {
        this.s = takeOffHeight;
    }

    public BigDecimal getV0() {
        return v0;
    }

    public void setV0(BigDecimal v0) {
        this.v0 = v0;
    }

    public BigDecimal getH() {
        return h;
    }

    public void setH(BigDecimal h) {
        this.h = h;
    }

    public BigDecimal getN() {
        return n;
    }

    public void setN(BigDecimal n) {
        this.n = n;
    }

    public BigDecimal getP() {
        return p;
    }

    public void setP(BigDecimal p) {
        this.p = p;
    }

    public BigDecimal getL1() {
        return l1;
    }

    public void setL1(BigDecimal l1) {
        this.l1 = l1;
    }

    public BigDecimal getL2() {
        return l2;
    }

    public void setL2(BigDecimal l2) {
        this.l2 = l2;
    }

    public BigDecimal getBetaP() {
        return betaP;
    }

    public void setBetaP(BigDecimal betaP) {
        this.betaP = betaP;
    }

    public BigDecimal getBeta() {
        return beta;
    }

    public void setBeta(BigDecimal landingAngle) {
        this.beta = landingAngle;
    }

    public BigDecimal getBetaL() {
        return betaL;
    }

    public void setBetaL(BigDecimal betaL) {
        this.betaL = betaL;
    }

    public BigDecimal getL() {
        return l;
    }

    public void setL(BigDecimal l) {
        this.l = l;
    }

    public BigDecimal getRl() {
        return rl;
    }

    public void setRl(BigDecimal rl) {
        this.rl = rl;
    }

    public BigDecimal getR2() {
        return r2;
    }

    public void setR2(BigDecimal r2) {
        this.r2 = r2;
    }

    public BigDecimal getA() {
        return a;
    }

    public void setA(BigDecimal a) {
        this.a = a;
    }

    public BigDecimal getB1() {
        return b1;
    }

    public void setB1(BigDecimal b1) {
        this.b1 = b1;
    }

    public BigDecimal getB2() {
        return b2;
    }

    public void setB2(BigDecimal b2) {
        this.b2 = b2;
    }

    public BigDecimal getBk() {
        return bk;
    }

    public void setBk(BigDecimal bk) {
        this.bk = bk;
    }

    public BigDecimal getBu() {
        return bu;
    }

    public void setBu(BigDecimal bu) {
        this.bu = bu;
    }

    public BigDecimal getD() {
        return d;
    }

    public void setD(BigDecimal d) {
        this.d = d;
    }

    public BigDecimal getQ() {
        return q;
    }

    public void setQ(BigDecimal q) {
        this.q = q;
    }

    public String getFisCertificate() {
        return fisCertificate;
    }

    public void setFisCertificate(String fisCertificate) {
        this.fisCertificate = fisCertificate;
    }

    public LocalDate getValidSince() {
        return validSince;
    }

    public void setValidSince(LocalDate validSince) {
        this.validSince = validSince;
    }

    public LocalDate getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(LocalDate validUntil) {
        this.validUntil = validUntil;
    }

}


