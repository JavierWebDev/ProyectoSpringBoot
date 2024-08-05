package com.campuslands.proyectospringboot.Region.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.campuslands.proyectospringboot.Region.domain.entities.Region;
import com.campuslands.proyectospringboot.Region.infrastructure.persistence.out.RegionRepository;

@Service
public class RegionService {
    
    private final RegionRepository regionRepository;

    public RegionService(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    public List<Region> findAll(){
        return regionRepository.findAll();  
    } 
    
    public Optional<Region> findById(Long id){
        return  regionRepository.findById(id);
    }

    public Region save(Region region){
        return regionRepository.save(region);
    }

    public void deleteById(Long id){
        regionRepository.deleteById(id);
    }
}
