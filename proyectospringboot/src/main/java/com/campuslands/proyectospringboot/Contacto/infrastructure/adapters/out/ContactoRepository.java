package com.campuslands.proyectospringboot.Contacto.infrastructure.adapters.out;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.campuslands.proyectospringboot.Contacto.domain.Contacto;

@Repository
public interface ContactoRepository extends JpaRepository<Contacto, Long> {

}
