package com.campuslands.proyectospringboot.Fax.infrastructure.adapters.out;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campuslands.proyectospringboot.Fax.domain.entities.Fax;

public interface FaxRepository extends JpaRepository<Fax, Long>{

}
