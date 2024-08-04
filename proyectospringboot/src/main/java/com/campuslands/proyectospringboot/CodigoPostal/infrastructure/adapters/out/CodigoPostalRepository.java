package com.campuslands.proyectospringboot.CodigoPostal.infrastructure.adapters.out;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campuslands.proyectospringboot.CodigoPostal.domain.CodigoPostal;

public interface CodigoPostalRepository extends JpaRepository<CodigoPostal, Long> {

}
