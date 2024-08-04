package com.campuslands.proyectospringboot.Telefono.infrastructure.persistence.out;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.campuslands.proyectospringboot.Telefono.domain.entitie.Telefono;

@Repository
public interface  TelefonoRepository extends JpaRepository<Telefono, Long>{
    
}
