package com.campuslands.proyectospringboot.Region.infrastructure.persistence.out;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.campuslands.proyectospringboot.Region.domain.entities.Region;

@Repository
public interface RegionRepository extends JpaRepository<Region, Long>{
    
}
