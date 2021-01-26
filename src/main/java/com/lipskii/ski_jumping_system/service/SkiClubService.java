package com.lipskii.ski_jumping_system.service;

import com.lipskii.ski_jumping_system.dao.SkiClubRepository;
import com.lipskii.ski_jumping_system.dto.SkiClubDTO;
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

   public List<SkiClubDTO> getClubsByCountryDTO(Country country){
        return skiClubRepository.findAllByCityRegionCountryOrderByName(country).stream().map(this::convertToSkiClubDTO).collect(Collectors.toList());
   }

    public List<SkiClubDTO> getAllClubsDTO() {
        return skiClubRepository.findAll().stream().map(this::convertToSkiClubDTO).collect(Collectors.toList());
    }


    private SkiClubDTO convertToSkiClubDTO(SkiClub skiClub) {
        SkiClubDTO skiClubDTO = new SkiClubDTO();
        skiClubDTO.setId(skiClub.getId());
        skiClubDTO.setName(skiClub.getName());
        skiClubDTO.setCity(skiClub.getCity().getName());
        skiClubDTO.setCode(skiClub.getCity().getRegion().getCountry().getCode());
        return skiClubDTO;
    }

    public List<SkiClubDTO> findAllByCountryCode(String code){
        return skiClubRepository.findAllByCityRegionCountryCodeOrderByName(code).stream().map(this::convertToSkiClubDTO).collect(Collectors.toList());
    }
}
