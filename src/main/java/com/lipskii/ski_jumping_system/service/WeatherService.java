package com.lipskii.ski_jumping_system.service;

import com.lipskii.ski_jumping_system.dao.WeatherRepository;
import com.lipskii.ski_jumping_system.entity.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WeatherService implements ServiceInterface {

    private final WeatherRepository weatherRepository;

    @Autowired
    public WeatherService(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    @Override
    public List<Weather> findAll() {
        return weatherRepository.findAll();
    }

    @Override
    public Optional<Weather> findById(int id) {
        return weatherRepository.findById(id);
    }

    @Override
    public Weather save(Object obj) {
        return weatherRepository.save((Weather) obj);
    }

    @Override
    public void deleteById(int id) {
        weatherRepository.deleteById(id);
    }
}
