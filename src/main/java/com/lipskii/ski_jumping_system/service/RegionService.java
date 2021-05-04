package com.lipskii.ski_jumping_system.service;

import com.lipskii.ski_jumping_system.dao.RegionRepository;
import com.lipskii.ski_jumping_system.entity.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegionService implements ServiceInterface {

    private final RegionRepository regionRepository;

    @Autowired
    public RegionService(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    @Override
    public List<Region> findAll() {
        return regionRepository.findAll();
    }

    @Override
    public Optional<Region> findById(int id) {
        return regionRepository.findById(id);
    }

    @Override
    public Region save(Object obj) {
        return regionRepository.save((Region) obj);
    }

    public List<Region> getRegionsByCountry(int countryId){
        return regionRepository.findAllByCountryIdOrderByName(countryId);
    }

    public List<Region> findAllOrderByName() {
        return regionRepository.findAllByOrderByName();
    }

    @Override
    public void deleteById(int id) {
        regionRepository.deleteById(id);
    }

}
