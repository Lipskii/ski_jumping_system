package com.lipskii.ski_jumping_system.service;

import com.lipskii.ski_jumping_system.dao.JuryRepository;
import com.lipskii.ski_jumping_system.dto.JuryDTO;
import com.lipskii.ski_jumping_system.entity.Country;
import com.lipskii.ski_jumping_system.entity.Jury;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
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

    public List<Jury> get(Specification<Jury> spec, Sort sort){
        return juryRepository.findAll(spec, sort);
    }


    public List<Jury> findAllByCountry(Country country) {
        return juryRepository.findAllByPersonCountry(country);
    }

    @Override
    public Optional<Jury> findById(int id) {
        return juryRepository.findById(id);
    }

    @Override
    public Jury save(Object obj) {
        return juryRepository.save((Jury) obj);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        Jury jury = juryRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("jury does not exist!"));
        juryRepository.delete(jury);
    }
}


