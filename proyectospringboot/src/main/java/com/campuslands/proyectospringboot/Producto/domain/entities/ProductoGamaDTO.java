package com.campuslands.proyectospringboot.Producto.domain.entities;

import lombok.Data;

@Data
public class ProductoGamaDTO {
    private Long id;
    private String nombreProducto;
    private Long precioVenta;
    private Long stockProducto;
    private String gamaProducto;
}
