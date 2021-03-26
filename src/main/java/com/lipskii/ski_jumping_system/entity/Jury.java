package com.lipskii.ski_jumping_system.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "jury")
public class Jury {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idjury")
    private int id;

    @JsonIgnoreProperties("jury")
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "jury_type_idjury_type")
    private JuryType juryType;

    @JsonIgnoreProperties("jury")
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "person_idperson")
    private Person person;

    public Jury() {
    }

    public Jury(JuryType juryType, Person person) {
        this.juryType = juryType;
        this.person = person;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public JuryType getJuryType() {
        return juryType;
    }

    public void setJuryType(JuryType juryType) {
        this.juryType = juryType;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Jury{" +
                "id=" + id +
                ", juryType=" + juryType +
                ", person=" + person +
                '}';
    }
}
