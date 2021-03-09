package com.lipskii.ski_jumping_system.service;

import com.lipskii.ski_jumping_system.dao.RegionRepository;
import com.lipskii.ski_jumping_system.dto.RegionDTO;
import com.lipskii.ski_jumping_system.entity.Country;
import com.lipskii.ski_jumping_system.entity.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<RegionDTO> findRegionsByCountry(Country country){
        return regionRepository.findAllByCountryOrderByName(country).stream().map(this::convertToRegionDTO).collect(Collectors.toList());
    }

    public List<Region> findRegionsByCountryCode(String code){
        return regionRepository.findAllByCountryCodeOrderByNameAsc(code);
    }

    public Region findRegionByName(String name){
        return regionRepository.findByName(name);
    }

    private RegionDTO convertToRegionDTO(Region region){
        RegionDTO regionDTO = new RegionDTO();
        regionDTO.setId(region.getId());
        regionDTO.setName(region.getName());
        regionDTO.setCountry(region.getCountry().getName());
        return regionDTO;
    }
}
