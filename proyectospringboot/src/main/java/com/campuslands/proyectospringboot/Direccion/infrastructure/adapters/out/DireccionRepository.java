package com.campuslands.proyectospringboot.Direccion.infrastructure.adapters.out;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campuslands.proyectospringboot.Direccion.domain.entities.Direccion;

public interface DireccionRepository  extends JpaRepository<Direccion, Long>{

}
