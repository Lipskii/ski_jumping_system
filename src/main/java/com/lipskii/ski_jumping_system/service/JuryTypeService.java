package com.lipskii.ski_jumping_system.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lipskii.ski_jumping_system.dao.JuryTypeRepository;
import com.lipskii.ski_jumping_system.entity.JuryType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class JuryTypeService implements ServiceInterface{

    private final JuryTypeRepository juryTypeRepository;

    @Autowired
    public JuryTypeService(JuryTypeRepository juryTypeRepository) {
        this.juryTypeRepository = juryTypeRepository;
    }

    @Override
    public List<JuryType> findAll() {
        return juryTypeRepository.findAllByOrderByJuryType();
    }

    @Override
    public Optional<JuryType> findById(int id) {
        return juryTypeRepository.findById(id);
    }

    @Override
    public JuryType save(Object obj) {
        return juryTypeRepository.save((JuryType) obj);
    }

    @Override
    public void deleteById(int id) {
        juryTypeRepository.deleteById(id);
    }

    public JuryType getJson(String jType, MultipartFile file) {

        JuryType juryType = new JuryType();
        System.out.println(jType);

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            juryType = objectMapper.readValue(jType, JuryType.class);
        } catch (IOException err) {
            err.printStackTrace();
        }

        System.out.println(juryType);
        System.out.println(file);

        return juryType;

    }
}
