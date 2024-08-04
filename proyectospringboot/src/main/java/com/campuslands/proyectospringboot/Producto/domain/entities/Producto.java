package com.campuslands.proyectospringboot.Producto.domain.entities;

import com.campuslands.proyectospringboot.GamaProducto.domain.entities.GamaProducto;
import com.campuslands.proyectospringboot.Proveedor.domain.entities.Proveedor;
import com.campuslands.proyectospringboot.Stock.domain.entities.Stock;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreProducto;
    private Integer precioProveedor;
    private Integer precioVenta;

    @ManyToOne
    @JoinColumn(name = "gama_producto", referencedColumnName = "id", nullable = false)
    private GamaProducto gamaProducto;

    @ManyToOne
    @JoinColumn(name = "dimensiones_producto", referencedColumnName = "id", nullable = false)
    private Integer dimensionesProducto;

    @ManyToOne
    @JoinColumn(name = "proveedor_producto", referencedColumnName = "id", nullable = false)
    private Proveedor proveedorProducto;

    @ManyToOne
    @JoinColumn(name = "stock_producto", referencedColumnName = "id", nullable = false)
    private Stock stockProducto;

}
