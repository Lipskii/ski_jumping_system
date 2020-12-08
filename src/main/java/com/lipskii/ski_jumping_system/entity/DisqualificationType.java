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
    private int disqualificationType;

    public DisqualificationType() {
    }

    public DisqualificationType(int disqualificationType) {
        this.disqualificationType = disqualificationType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDisqualificationType() {
        return disqualificationType;
    }

    public void setDisqualificationType(int disqualificationType) {
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
