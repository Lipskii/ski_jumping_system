package com.lipskii.ski_jumping_system.entity;

import javax.persistence.*;

@Entity
@Table(name = "judge")
public class Judge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idjudge")
    private int id;

    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "person_idperson")
    private Person person;

    public Judge() {
    }

    public Judge(Person person) {
        this.person = person;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Judge{" +
                "id=" + id +
                ", person=" + person +
                '}';
    }
}
