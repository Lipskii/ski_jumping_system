package com.lipskii.ski_jumping_system.service;

import com.lipskii.ski_jumping_system.dao.SkiClubRepository;
import com.lipskii.ski_jumping_system.entity.SkiClub;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkiClubService implements ServiceInterface {

    private final SkiClubRepository skiClubRepository;

    @Autowired
    public SkiClubService(SkiClubRepository skiClubRepository) {
        this.skiClubRepository = skiClubRepository;
    }

    @Override
    public List<SkiClub> findAll() {
        return skiClubRepository.findAll();
    }

    @Override
    public Optional<SkiClub> findById(int id) {
        return skiClubRepository.findById(id);
    }

    @Override
    public void save(Object obj) {
        skiClubRepository.save((SkiClub) obj);
    }

    @Override
    public void deleteById(int id) {
        skiClubRepository.deleteById(id);
    }

    public List<SkiClub> findAllByCountryCode(String code){
        return skiClubRepository.findAllByCityRegionCountryCodeOrderByName(code);
    }
}
