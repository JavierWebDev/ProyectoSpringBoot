package com.campuslands.proyectospringboot.Empleado.infrastructure.adapters.out;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campuslands.proyectospringboot.Empleado.domain.entities.Empleado;


public interface EmpleadoRepository extends JpaRepository<Empleado, Long>{

}
