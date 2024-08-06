package com.campuslands.proyectospringboot.GamaProducto.infrastructure.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campuslands.proyectospringboot.GamaProducto.domain.entities.GamaProducto;

public interface GamaProductoRepository extends JpaRepository<GamaProducto, Long>{

}
