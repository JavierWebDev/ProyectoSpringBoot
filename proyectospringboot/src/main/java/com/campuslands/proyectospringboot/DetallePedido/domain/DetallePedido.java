package com.campuslands.proyectospringboot.DetallePedido.domain;

import com.campuslands.proyectospringboot.Pedido.domain.entities.Pedido;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "detalle_pedido")
public class DetallePedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int cantidad;

    @Column(name = "precio_unidad")
    private Double precio;

    @Column(name = "numero_linea")
    private String numeroLinea;

    @OneToOne
    @JoinColumn(name = "producto_pedido")
    private Pedido pedido;
}
