package com.lipskii.ski_jumping_system.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "jury_type")
public class JuryType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idjury_type")
    private int id;

    @Column(name = "jury_type")
    private String juryType;

    @JsonIgnoreProperties("juryType")
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "juryType", cascade = {CascadeType.PERSIST})
    private List<Jury> juryList;

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

    public List<Jury> getJuryList() {
        return juryList;
    }

    public void setJuryList(List<Jury> juryList) {
        this.juryList = juryList;
    }

    @Override
    public String toString() {
        return "JuryType{" +
                "id=" + id +
                ", juryType='" + juryType + '\'' +
                '}';
    }
}
