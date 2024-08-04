package com.campuslands.proyectospringboot.Barrio.infrastructure.Out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.campuslands.proyectospringboot.Barrio.domain.Barrio;

@Repository
public interface BarrioRepository extends JpaRepository<Barrio, Long> {

}
