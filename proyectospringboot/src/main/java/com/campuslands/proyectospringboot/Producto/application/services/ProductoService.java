package com.campuslands.proyectospringboot.Producto.application.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.campuslands.proyectospringboot.Producto.domain.entities.Producto;

@Service
public interface ProductoService {
    List<Producto> findAll();
    Optional<Producto> findById(Long id);
    Producto save(Producto producto);
    Optional<Producto> update(Long id, Producto producto);
    Optional<Producto> delete(Long id);
}
