package com.lipskii.ski_jumping_system.service;

import com.lipskii.ski_jumping_system.dao.HillRepository;
import com.lipskii.ski_jumping_system.entity.Hill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class HillService implements ServiceInterface {

    private final HillRepository hillRepository;
    private final VenueService venueService;

    @Autowired
    public HillService(HillRepository hillRepository, @Lazy VenueService venueService) {
        this.hillRepository = hillRepository;
        this.venueService = venueService;
    }

    @Override
    public List<Hill> findAll() {
        return hillRepository.findAll();
    }

    public List<Hill> get(Specification<Hill> spec, Sort sort) {
        return hillRepository.findAll(spec, sort);
    }

    @Override
    public Optional<Hill> findById(int id) {
        return hillRepository.findById(id);
    }

    //TODO add or else throw
    public List<Hill> findAllByVenueId(int venueId){
        return hillRepository.findAllByVenue(venueService.findById(venueId).orElseThrow(() -> new ResourceNotFoundException("No hills in venue with id=" + venueId)));
    }

    @Override
    @Transactional
    public Hill save(Object obj) {
        return hillRepository.save((Hill) obj);
    }


    @Override
    @Transactional
    public void deleteById(int id) {
        Hill hill = hillRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("hill does not exist!"));
        System.out.println(hill);
        hillRepository.deleteHillById(id);
    }


    @Transactional
    public Hill updateHill(int hillId, Hill requestHill) {
        if (hillRepository.findById(hillId).isPresent()) {
            requestHill.setId(hillId);
            hillRepository.save(requestHill);
        } else {
            throw new ResourceNotFoundException("No hill found for id: " + hillId);
        }

        return requestHill;
    }
}
