package com.campuslands.proyectospringboot.Producto.domain.entities;

import lombok.Data;

@Data
public class BajoStockDTO {
    private Long id;
    private String nombreProducto;
    private Integer stock;
}
