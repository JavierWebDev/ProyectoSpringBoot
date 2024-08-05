package com.campuslands.proyectospringboot.FormaPago.infrastructure.adapters.out;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campuslands.proyectospringboot.FormaPago.domain.entities.FormaPago;

public interface FormaPagoRepository extends JpaRepository<FormaPago, Long>{

}
