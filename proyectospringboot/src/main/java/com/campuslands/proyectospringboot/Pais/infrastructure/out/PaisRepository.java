package com.campuslands.proyectospringboot.Pais.infrastructure.out;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.campuslands.proyectospringboot.Pais.domain.entities.Pais;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Long> {

}
