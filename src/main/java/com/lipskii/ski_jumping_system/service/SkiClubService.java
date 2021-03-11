package com.lipskii.ski_jumping_system.service;

import com.lipskii.ski_jumping_system.dao.SkiClubRepository;
import com.lipskii.ski_jumping_system.dto.SkiClubDTO;
import com.lipskii.ski_jumping_system.entity.City;
import com.lipskii.ski_jumping_system.entity.Country;
import com.lipskii.ski_jumping_system.entity.SkiClub;
import org.springframework.beans.factory.annotation.Autowired;
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

    public List<SkiClub> findAllOrderByName(){
        return skiClubRepository.findAllByOrderByName();
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

   public List<SkiClub> findAllByCountryId(int countryId){
        return skiClubRepository.findAllByCityRegionCountryIdOrderByName(countryId);
   }

   public List<SkiClub> findAllByCountry(Country country){
        return skiClubRepository.findAllByCityRegionCountryOrderByName(country);
   }

    public List<SkiClub> findAllByCity(City city){
        return skiClubRepository.findAllByCityOrderByName(city);
    }

    public List<SkiClub> findAllByCityId(int cityId){
        return skiClubRepository.findAllByCityIdOrderByName(cityId);
    }

}
