package com.campuslands.proyectospringboot.Barrio.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.campuslands.proyectospringboot.Barrio.domain.entities.Barrio;

@Repository
public interface BarrioRepository extends JpaRepository<Barrio, Long> {

}
