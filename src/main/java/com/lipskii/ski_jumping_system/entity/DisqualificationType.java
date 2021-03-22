package com.lipskii.ski_jumping_system.entity;

import javax.persistence.*;

@Entity
@Table(name = "disqualification_type")
public class DisqualificationType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iddisqualification_type")
    private int id;

    @Column(name = "disqualification_type")
    private String disqualificationType;

    public DisqualificationType() {
    }

    public DisqualificationType(String disqualificationType) {
        this.disqualificationType = disqualificationType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDisqualificationType() {
        return disqualificationType;
    }

    public void setDisqualificationType(String disqualificationType) {
        this.disqualificationType = disqualificationType;
    }

    @Override
    public String toString() {
        return "DisqualificationType{" +
                "id=" + id +
                ", disqualificationType=" + disqualificationType +
                '}';
    }
}
