package com.lipskii.ski_jumping_system.service;

import com.lipskii.ski_jumping_system.dao.SeasonRepository;
import com.lipskii.ski_jumping_system.entity.Season;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeasonService implements ServiceInterface {

    private final SeasonRepository seasonRepository;

    @Autowired
    public SeasonService(SeasonRepository seasonRepository) {
        this.seasonRepository = seasonRepository;
    }

    @Override
    public List<Season> findAll() {
        return (List<Season>) seasonRepository.findAll();
    }

    @Override
    public Optional<Season> findById(int id) {
        return seasonRepository.findById(id);
    }

    @Override
    public void save(Object obj) {
        seasonRepository.save((Season) obj);
    }

    @Override
    public void deleteById(int id) {
        seasonRepository.deleteById(id);
    }
}
