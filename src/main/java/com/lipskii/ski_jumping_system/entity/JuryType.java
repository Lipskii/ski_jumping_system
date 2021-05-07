package com.lipskii.ski_jumping_system.entity;

import javax.persistence.*;

@Entity
@Table(name = "jury_type")
public class JuryType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idjury_type")
    private int id;

    @Column(name = "jury_type")
    private String juryType;


    public JuryType() {
    }

    public JuryType(String juryType) {
        this.juryType = juryType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJuryType() {
        return juryType;
    }

    public void setJuryType(String juryType) {
        this.juryType = juryType;
    }


    @Override
    public String toString() {
        return "JuryType{" +
                "id=" + id +
                ", juryType='" + juryType + '\'' +
                '}';
    }
}
