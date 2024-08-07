package com.campuslands.proyectospringboot.GamaProducto.application.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.campuslands.proyectospringboot.GamaProducto.domain.entities.GamaProducto;

@Service
public interface GamaProductoService {
    List<GamaProducto> findAll();
    Optional<GamaProducto> findById(Long id);
    GamaProducto save(GamaProducto gamaProducto);
    Optional<GamaProducto> update(Long id, GamaProducto gamaProducto);
    Optional<GamaProducto> delete(Long id);
}
