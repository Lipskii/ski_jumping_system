package com.lipskii.ski_jumping_system.service;

import com.lipskii.ski_jumping_system.dao.VenueRepository;
import com.lipskii.ski_jumping_system.entity.Venue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VenueService implements ServiceInterface {

    private final VenueRepository venueRepository;

    @Autowired
    public VenueService(VenueRepository venueRepository) {
        this.venueRepository = venueRepository;
    }

    @Override
    public List<Venue> findAll() {
        return venueRepository.findAll();
    }

    @Override
    public Optional<Venue> findById(int id) {
        return venueRepository.findById(id);
    }

    @Override
    public void save(Object obj) {
        venueRepository.save((Venue) obj);
    }

    @Override
    public void deleteById(int id) {
        venueRepository.deleteById(id);
    }
}
