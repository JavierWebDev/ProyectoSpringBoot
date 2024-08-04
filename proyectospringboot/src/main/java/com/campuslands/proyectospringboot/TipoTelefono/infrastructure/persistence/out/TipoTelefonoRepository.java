package com.campuslands.proyectospringboot.TipoTelefono.infrastructure.persistence.out;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.campuslands.proyectospringboot.TipoTelefono.domain.entities.TipoTelefono;

@Repository
public interface TipoTelefonoRepository extends JpaRepository<TipoTelefono, Long> {
    
}
