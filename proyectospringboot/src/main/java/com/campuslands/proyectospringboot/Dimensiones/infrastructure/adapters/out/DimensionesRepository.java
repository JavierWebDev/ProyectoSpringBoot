package com.campuslands.proyectospringboot.Dimensiones.infrastructure.adapters.out;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campuslands.proyectospringboot.Dimensiones.domain.entities.Dimensiones;

public interface DimensionesRepository extends JpaRepository<Dimensiones, Long> {

}
