package com.campuslands.proyectospringboot.Pedido.domain.entities;

import java.time.LocalDate;

import com.campuslands.proyectospringboot.Cliente.domain.entities.Cliente;
import com.campuslands.proyectospringboot.DetallePedido.domain.DetallePedido;
import com.campuslands.proyectospringboot.Estado.domain.entities.Estado;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table
@Data
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message="La fecha de pedido no puede ser nulo")
    @Column (name = "fecha_pedido", nullable = false)
    private LocalDate fechaPedido;

    @NotNull(message="La fecha esperada no puede ser nulo")
    @Column (name = "fecha_esperada", nullable = false)
    private LocalDate fechaEsperada;

    @NotNull(message="La fecha de entrega no puede ser nulo")
    @Column (name = "fecha_entrega", nullable = false)
    private LocalDate fechaEntrega;

    private String comentarios;

    @ManyToOne
    @Valid
    @NotNull(message="El cliente no puede ser nulo")
    @JoinColumn(name = "cliente_pedido", referencedColumnName = "id", nullable = false)
    private Cliente clientePedido;

    @ManyToOne
    @Valid
    @NotNull(message="El estado de pedido no puede ser nulo")
    @JoinColumn(name = "estado_pedido", referencedColumnName = "id", nullable = false)
    private Estado estadoPedido;

    @ManyToOne
    @Valid
    @NotNull(message="El detalle de pedido no puede ser nulo")
    @JoinColumn(name = "detalle_pedido", referencedColumnName = "id", nullable = false)
    private DetallePedido detallePedido;


}

