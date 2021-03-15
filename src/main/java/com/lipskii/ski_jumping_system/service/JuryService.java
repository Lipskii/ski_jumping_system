package com.lipskii.ski_jumping_system.service;

import com.lipskii.ski_jumping_system.dao.JuryRepository;
import com.lipskii.ski_jumping_system.dto.JuryDTO;
import com.lipskii.ski_jumping_system.dto.SkiJumperDTO;
import com.lipskii.ski_jumping_system.entity.Country;
import com.lipskii.ski_jumping_system.entity.Jury;
import com.lipskii.ski_jumping_system.entity.SkiJumper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JuryService implements ServiceInterface {

    private final JuryRepository juryRepository;

    @Autowired
    public JuryService(JuryRepository juryRepository) {
        this.juryRepository = juryRepository;
    }

    @Override
    public List<Jury> findAll() {
        return juryRepository.findAll();
    }

    public List<JuryDTO> findAllDTO() {
        List<JuryDTO> juryDTOS = juryRepository.findAll().stream().map(this::convertToJuryDTO).collect(Collectors.toList());
        Collections.sort(juryDTOS);
        return juryDTOS;
    }

    public List<Jury> findAllByCountry(Country country) {
        return juryRepository.findAllByPersonCountry(country);
    }

    //TODO change those next functions (into one?)
    public List<JuryDTO> findAllRaceDirectors() {
        List<JuryDTO> juryDTOS = juryRepository.findAllByJuryTypeId(1).stream().map(this::convertToJuryDTO).collect(Collectors.toList());
        Collections.sort(juryDTOS);
        return juryDTOS;
    }

    public List<JuryDTO> findAllTechnicalDelegates() {
        List<JuryDTO> juryDTOS = juryRepository.findAllByJuryTypeId(2).stream().map(this::convertToJuryDTO).collect(Collectors.toList());
        Collections.sort(juryDTOS);
        return juryDTOS;
    }

    public List<JuryDTO> findAllTDAssistants() {
        List<JuryDTO> juryDTOS = juryRepository.findAllByJuryTypeId(4).stream().map(this::convertToJuryDTO).collect(Collectors.toList());
        Collections.sort(juryDTOS);
        return juryDTOS;
    }

    public List<JuryDTO> findAllRDAssistants() {
        List<JuryDTO> juryDTOS = juryRepository.findAllByJuryTypeId(5).stream().map(this::convertToJuryDTO).collect(Collectors.toList());
        Collections.sort(juryDTOS);
        return juryDTOS;
    }

    public List<JuryDTO> findAllEquipmentControllers() {
        List<JuryDTO> juryDTOS = juryRepository.findAllByJuryTypeId(6).stream().map(this::convertToJuryDTO).collect(Collectors.toList());
        Collections.sort(juryDTOS);
        return juryDTOS;
    }

    public List<JuryDTO> findAllChiefsOfCompetitions() {
        List<JuryDTO> juryDTOS = juryRepository.findAllByJuryTypeId(3).stream().map(this::convertToJuryDTO).collect(Collectors.toList());
        Collections.sort(juryDTOS);
        return juryDTOS;
    }

    public List<JuryDTO> findAllJudges() {
        List<JuryDTO> juryDTOS = juryRepository.findAllByJuryTypeId(7).stream().map(this::convertToJuryDTO).collect(Collectors.toList());
        Collections.sort(juryDTOS);
        return juryDTOS;
    }


    @Override
    public Optional<Jury> findById(int id) {
        return juryRepository.findById(id);
    }

    @Override
    public Jury save(Object obj) {
        return juryRepository.save((Jury) obj);
    }

    @Override
    public void deleteById(int id) {
        juryRepository.deleteById(id);
    }

    private JuryDTO convertToJuryDTO(Jury jury) {
        JuryDTO juryDTO = new JuryDTO();
        juryDTO.setId(jury.getId());
        juryDTO.setJuryType(jury.getJuryType());
        juryDTO.setPerson(jury.getPerson());
        juryDTO.setCountry(jury.getPerson().getCountry());
        juryDTO.setGender(jury.getPerson().getGender());
        return juryDTO;
    }

    public List<JuryDTO> findAllByCountryId(int countryId) {
        List<JuryDTO> juryDTOS = juryRepository.findAllByPersonCountryId(countryId)
                .stream().map(this::convertToJuryDTO).collect(Collectors.toList());
        Collections.sort(juryDTOS);
        return juryDTOS;
    }



}


