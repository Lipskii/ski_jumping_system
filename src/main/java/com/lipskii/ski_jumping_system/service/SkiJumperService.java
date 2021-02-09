package com.lipskii.ski_jumping_system.service;

import com.lipskii.ski_jumping_system.dao.SkiJumperRepository;
import com.lipskii.ski_jumping_system.dto.CityDTO;
import com.lipskii.ski_jumping_system.dto.SkiJumperDTO;
import com.lipskii.ski_jumping_system.entity.City;
import com.lipskii.ski_jumping_system.entity.SkiJumper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SkiJumperService implements ServiceInterface {

    private final SkiJumperRepository skiJumperRepository;

    @Autowired
    public SkiJumperService(SkiJumperRepository skiJumperRepository) {
        this.skiJumperRepository = skiJumperRepository;
    }

    @Override
    public List<SkiJumper> findAll() {
        return skiJumperRepository.findAll();
    }

    @Override
    public Optional<SkiJumper> findById(int id) {
        return skiJumperRepository.findById(id);
    }

    @Override
    public void save(Object obj) {
        skiJumperRepository.save((SkiJumper) obj);
    }

    @Override
    public void deleteById(int id) {
        skiJumperRepository.deleteById(id);
    }

    public List<SkiJumperDTO> getSkiJumpersByCountry(String country) {
        return skiJumperRepository.findAllByPersonCountryName(country).stream().map(this::convertToSkiJumperDTO).collect(Collectors.toList());
    }


    private SkiJumperDTO convertToSkiJumperDTO(SkiJumper skiJumper) {
        SkiJumperDTO skiJumperDTO = new SkiJumperDTO();
        skiJumperDTO.setId(skiJumper.getId());
        skiJumperDTO.setFirstName(skiJumper.getPerson().getFirstName());
        skiJumperDTO.setLastName(skiJumper.getPerson().getLastName());
        skiJumperDTO.setGender(skiJumper.getPerson().getGender().getGender());
        skiJumperDTO.setCity(skiJumper.getPerson().getCity().getName());
        skiJumperDTO.setCountry(skiJumper.getPerson().getCountry().getName());
        skiJumperDTO.setSkiClub(skiJumper.getSkiClub().getName());
        String birthdate = skiJumper.getPerson().getBirthdate_day()
                + "-" + (skiJumper.getPerson().getBirthdate_month())
                + "-" + (skiJumper.getPerson().getBirthdate_year());
        skiJumperDTO.setBirthdate(birthdate);
        skiJumperDTO.setActive(skiJumper.isActive());
        skiJumperDTO.setSkis(skiJumper.getSkis().getBrand());
        skiJumperDTO.setAllTimePoints(skiJumper.getAll_time_points());

        return skiJumperDTO;
    }
}
