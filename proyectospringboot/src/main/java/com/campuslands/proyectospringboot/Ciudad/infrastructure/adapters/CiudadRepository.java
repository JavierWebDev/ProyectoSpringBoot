package com.campuslands.proyectospringboot.Ciudad.infrastructure.adapters;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.campuslands.proyectospringboot.Ciudad.domain.Ciudad;

@Repository
public interface CiudadRepository extends JpaRepository<Ciudad, Long> {

}
