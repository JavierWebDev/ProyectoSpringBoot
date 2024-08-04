package com.campuslands.proyectospringboot.Proveedor.infrastructure.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.campuslands.proyectospringboot.Proveedor.domain.entities.Proveedor;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {
    
}
