package com.lipskii.ski_jumping_system.dao;

import com.lipskii.ski_jumping_system.entity.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WeatherRepository extends JpaRepository<Weather,Integer> {
    List<Weather> findAllByOrderByWeather();
}
