package com.campuslands.proyectospringboot.Estado.infrastructure.adapters.out;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campuslands.proyectospringboot.Estado.domain.entities.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Long>{

}
