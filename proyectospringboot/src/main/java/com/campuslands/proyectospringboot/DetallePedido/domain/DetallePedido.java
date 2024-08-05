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
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
@Table(name = "detalle_pedido")
public class DetallePedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message="La cantidad de unidades no puede ser nula")
    @Column(nullable = false)
    private int cantidad;

    @NotNull(message="El precio de la unidad no puede ser nulo")
    @Column(name = "precio_unidad", nullable = false)
    private Double precio;

    @NotBlank(message="El numero de linea no puede ser vacío")
    @Size(max=50)
    @Column(name = "numero_linea", nullable = false)
    private String numeroLinea;

    @OneToOne
    @Valid
    @NotNull(message="El pedido no puede ser nulo")
    @JoinColumn(name = "producto_pedido", nullable = false)
    private Pedido pedido;
}
