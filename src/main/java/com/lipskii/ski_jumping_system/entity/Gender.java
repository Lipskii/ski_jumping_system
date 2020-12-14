package com.lipskii.ski_jumping_system.entity;

import javax.persistence.*;

@Entity
@Table(name = "gender")
public class Gender {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idgender")
    private int id;

    @Column(name = "gender")
    private String gender;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Gender{" +
                "id=" + id +
                ", gender='" + gender + '\'' +
                '}';
    }
}
