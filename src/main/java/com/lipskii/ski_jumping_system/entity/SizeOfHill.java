package com.lipskii.ski_jumping_system.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "size_of_hill")
public class SizeOfHill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idsize_of_hill")
    private int id;

    @Column(name = "designation")
    private String designation;

    @Column(name = "min_hs")
    private int minHS;

    @Column(name = "max_hs")
    private int maxHS;

    /**
     * Minimal distance between the takeoff and the construction point K.
     */
    @Column(name = "min_distance_t_k")
    private int minDistanceTK;

    /**
     * Maximal distance between the takeoff and the construction point K.
     */
    @Column(name = "max_distance_t_k")
    private int maxDistanceTK;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "size_of_hill", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Hill> hills;

    public SizeOfHill() {
    }

    public SizeOfHill(String designation, int minHS, int maxHS, int minDistanceTK, int maxDistanceTK) {
        this.designation = designation;
        this.minHS = minHS;
        this.maxHS = maxHS;
        this.minDistanceTK = minDistanceTK;
        this.maxDistanceTK = maxDistanceTK;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public int getMinHS() {
        return minHS;
    }

    public void setMinHS(int minHS) {
        this.minHS = minHS;
    }

    public int getMaxHS() {
        return maxHS;
    }

    public void setMaxHS(int maxHS) {
        this.maxHS = maxHS;
    }

    public int getMinDistanceTK() {
        return minDistanceTK;
    }

    public void setMinDistanceTK(int minDistanceTK) {
        this.minDistanceTK = minDistanceTK;
    }

    public int getMaxDistanceTK() {
        return maxDistanceTK;
    }

    public void setMaxDistanceTK(int maxDistanceTK) {
        this.maxDistanceTK = maxDistanceTK;
    }

    public List<Hill> getHills() {
        return hills;
    }

    public void setHills(List<Hill> hills) {
        this.hills = hills;
    }

    @Override
    public String toString() {
        return "SizeOfHill{" +
                "id=" + id +
                ", designation='" + designation + '\'' +
                ", minHS=" + minHS +
                ", maxHS=" + maxHS +
                ", minDistanceTK=" + minDistanceTK +
                ", maxDistanceTK=" + maxDistanceTK +
                '}';
    }
}
