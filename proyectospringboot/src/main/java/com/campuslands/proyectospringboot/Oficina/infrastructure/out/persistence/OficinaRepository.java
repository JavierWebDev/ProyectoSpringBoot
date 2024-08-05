package com.campuslands.proyectospringboot.Oficina.infrastructure.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.campuslands.proyectospringboot.Oficina.domain.entities.Oficina;

@Repository
public interface OficinaRepository extends JpaRepository<Oficina, Long> {

}
