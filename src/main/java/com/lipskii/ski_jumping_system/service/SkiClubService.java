package com.lipskii.ski_jumping_system.service;

import com.lipskii.ski_jumping_system.dao.SkiClubRepository;
import com.lipskii.ski_jumping_system.dto.SkiClubDTO;
import com.lipskii.ski_jumping_system.dto.VenueDTO;
import com.lipskii.ski_jumping_system.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Override
    public void deleteById(int id) {
        skiClubRepository.deleteById(id);
    }

   public List<SkiClub> findAllByCountry(Country country){
        return skiClubRepository.findAllByCityRegionCountryOrderByName(country);
   }

    public List<SkiClub> findAllByCity(City city){
        return skiClubRepository.findAllByCityOrderByName(city);
    }



}
