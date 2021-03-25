package com.lipskii.ski_jumping_system.service;

import com.lipskii.ski_jumping_system.dao.SkiJumperRepository;
import com.lipskii.ski_jumping_system.dto.SkiJumperDTO;
import com.lipskii.ski_jumping_system.entity.City;
import com.lipskii.ski_jumping_system.entity.Competition;
import com.lipskii.ski_jumping_system.entity.Country;
import com.lipskii.ski_jumping_system.entity.SkiJumper;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
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

    public List<SkiJumper> get(Specification<SkiJumper> spec, Sort sort) {
        return skiJumperRepository.findAll(spec, sort);
    }

    public List<SkiJumperDTO> findAllDTO(){
        List<SkiJumperDTO> skiJumperDTOList = skiJumperRepository.findAll()
                .stream()
                .map(this::convertToSkiJumperDTO)
                .collect(Collectors.toList());
        Collections.sort(skiJumperDTOList);
        return skiJumperDTOList;
    }

    public List<SkiJumper> findAllByCity(City city) {
        return skiJumperRepository.findAllByPersonCityOrderByPerson(city);
    }

    public List<SkiJumper> findAllByCountry(Country country){
        return skiJumperRepository.findAllByPersonCountryOrderByPerson(country);
    }

    public List<SkiJumperDTO> findAllByCountryIdDTO(int countryId){
       List<SkiJumperDTO> skiJumperDTOList = skiJumperRepository.findAllByPersonCountryId(countryId)
               .stream().map(this::convertToSkiJumperDTO).collect(Collectors.toList());
       Collections.sort(skiJumperDTOList);
       return skiJumperDTOList;
    }

    public List<SkiJumperDTO> findAllByCityIdDTO(int cityId) {
        List<SkiJumperDTO> skiJumperDTOList = skiJumperRepository.findAllByPersonCityId(cityId)
                .stream().map(this::convertToSkiJumperDTO).collect(Collectors.toList());
        Collections.sort(skiJumperDTOList);
        return skiJumperDTOList;
    }

    @Override
    public Optional<SkiJumper> findById(int id) {
        return skiJumperRepository.findById(id);
    }

    @Override
    public SkiJumper save(Object obj) {
        return skiJumperRepository.save((SkiJumper) obj);
    }

    @Override
    public void deleteById(int id) {
        skiJumperRepository.deleteById(id);
    }


    private SkiJumperDTO convertToSkiJumperDTO(SkiJumper skiJumper) {
        SkiJumperDTO skiJumperDTO = new SkiJumperDTO();
        skiJumperDTO.setId(skiJumper.getId());
        skiJumperDTO.setPerson(skiJumper.getPerson());
        skiJumperDTO.setFirstName(skiJumper.getPerson().getFirstName());
        skiJumperDTO.setLastName(skiJumper.getPerson().getLastName());
        skiJumperDTO.setGender(skiJumper.getPerson().getGender());
        skiJumperDTO.setCity(skiJumper.getPerson().getCity());
        skiJumperDTO.setCountry(skiJumper.getPerson().getCountry());
        skiJumperDTO.setSkiClub(skiJumper.getSkiClub());
        skiJumperDTO.setBirthdate(skiJumper.getPerson().getBirthdate());
        skiJumperDTO.setActive(skiJumper.isActive());
        skiJumperDTO.setSkis(skiJumper.getSkis());
        skiJumperDTO.setFisCode(skiJumper.getFisCode());
        skiJumperDTO.setAllTimePoints(skiJumper.getAll_time_points());
        return skiJumperDTO;
    }
}
