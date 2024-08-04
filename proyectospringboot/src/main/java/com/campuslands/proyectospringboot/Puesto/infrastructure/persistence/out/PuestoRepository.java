package com.campuslands.proyectospringboot.Puesto.infrastructure.persistence.out;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.campuslands.proyectospringboot.Puesto.domain.entities.Puesto;

@Repository
public interface PuestoRepository extends JpaRepository<Puesto, Long> {

}
