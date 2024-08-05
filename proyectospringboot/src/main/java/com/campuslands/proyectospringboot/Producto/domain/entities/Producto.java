package com.campuslands.proyectospringboot.Producto.domain.entities;

import com.campuslands.proyectospringboot.Dimensiones.domain.entities.Dimensiones;
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
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table
@Data
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message="El nombre del producto no puede ser nulo")
    @Column (name = "nombre_producto", nullable = false)
    private String nombreProducto;

    @NotNull(message="El precio del proveedor no puede ser nulo")
    @Column (name = "precio_proveedor", nullable = false)
    private Integer precioProveedor;

    @NotNull(message="El precio de venta no puede ser nulo")
    @Column (name = "precio_venta", nullable = false)
    private Integer precioVenta;

    @ManyToOne
    @NotNull(message="La gama de producto no puede ser nulo")
    @JoinColumn(name = "gama_producto", referencedColumnName = "id", nullable = false)
    private GamaProducto gamaProducto;

    @ManyToOne
    @NotNull(message="Las dimensiones de producto no puede ser nulo")
    @JoinColumn(name = "dimensiones_producto", referencedColumnName = "id", nullable = false)
    private Dimensiones dimensionesProducto;

    @ManyToOne
    @NotNull(message="El proveedor no puede ser nulo")
    @JoinColumn(name = "proveedor_producto", referencedColumnName = "id", nullable = false)
    private Proveedor proveedorProducto;

    @ManyToOne
    @NotNull(message="El stock de producto no puede ser nulo")
    @JoinColumn(name = "stock_producto", referencedColumnName = "id", nullable = false)
    private Stock stockProducto;

}
