package com.lipskii.ski_jumping_system.service;

import com.lipskii.ski_jumping_system.dao.HillRepository;
import com.lipskii.ski_jumping_system.entity.Hill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

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

    @Override
    public Optional<Hill> findById(int id) {
        return hillRepository.findById(id);
    }

    public List<Hill> findAllByVenueId(int venueId){
        return hillRepository.findAllByVenue(venueService.findById(venueId).get());
    }

    @Override
    public Hill save(Object obj) {
        return hillRepository.save((Hill) obj);
    }

    @Override
    public void deleteById(int id) {
        hillRepository.deleteById(id);
    }
}
