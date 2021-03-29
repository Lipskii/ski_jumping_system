package com.lipskii.ski_jumping_system.service;

import com.lipskii.ski_jumping_system.dao.SkiClubRepository;
import com.lipskii.ski_jumping_system.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    public List<SkiClub> get(Specification<SkiClub> spec, Sort sort){
        return skiClubRepository.findAll(spec,sort);
    }




    @Override
    public Optional<SkiClub> findById(int id) {
        return skiClubRepository.findById(id);
    }

    @Override
    public SkiClub save(Object obj) {
        return skiClubRepository.save((SkiClub) obj);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        SkiClub skiClub = skiClubRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("ski clubs does not exist!"));
        skiClubRepository.delete(skiClub);
    }

   public List<SkiClub> findAllByCountry(Country country){
        return skiClubRepository.findAllByCityRegionCountryOrderByName(country);
   }

    public List<SkiClub> findAllByCity(City city){
        return skiClubRepository.findAllByCityOrderByName(city);
    }



}
