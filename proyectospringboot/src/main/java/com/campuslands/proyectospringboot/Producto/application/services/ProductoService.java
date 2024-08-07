package com.campuslands.proyectospringboot.Producto.application.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.campuslands.proyectospringboot.Producto.domain.entities.BajoStockDTO;
import com.campuslands.proyectospringboot.Producto.domain.entities.Producto;
import com.campuslands.proyectospringboot.Producto.domain.entities.ProductoGamaDTO;

@Service
public interface ProductoService {
    List<Producto> findAll();
    Optional<Producto> findById(Long id);
    Producto save(Producto producto);
    Optional<Producto> update(Long id, Producto producto);
    Optional<Producto> delete(Long id);
    Optional<List<ProductoGamaDTO>> productosPorGama (String nombreGama);
    Optional<List<BajoStockDTO>> productosConBajoStock (Integer stockLimite);
}
