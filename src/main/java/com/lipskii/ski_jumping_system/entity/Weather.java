package com.lipskii.ski_jumping_system.entity;

import javax.persistence.*;

@Entity
@Table(name = "weather")
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idweather")
    private int id;

    @Column(name = "weather")
    private String weather;

    public Weather() {
    }

    public Weather(String weather) {
        this.weather = weather;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "id=" + id +
                ", weather='" + weather + '\'' +
                '}';
    }
}
