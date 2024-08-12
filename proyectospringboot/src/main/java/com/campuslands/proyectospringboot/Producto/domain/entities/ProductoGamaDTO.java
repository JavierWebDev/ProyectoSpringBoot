package com.campuslands.proyectospringboot.Producto.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductoGamaDTO {
    private Long id;
    private String nombreProducto;
    private String gamaProducto;
}
