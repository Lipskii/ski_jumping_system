package com.lipskii.ski_jumping_system.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "skis")
public class Skis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idskis")
    private int id;

    @Column(name = "brand")
    private String brand;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "skis", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<SkiJumper> skiJumpers;

    public Skis() {
    }

    public Skis(String brand) {
        this.brand = brand;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public List<SkiJumper> getSkiJumpers() {
        return skiJumpers;
    }

    public void setSkiJumpers(List<SkiJumper> skiJumpers) {
        this.skiJumpers = skiJumpers;
    }

    @Override
    public String toString() {
        return "Skis{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                '}';
    }
}
