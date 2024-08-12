package com.campuslands.proyectospringboot.Pago.domain.entities;

import java.sql.Timestamp;

import com.campuslands.proyectospringboot.Cliente.domain.entities.Cliente;
import com.campuslands.proyectospringboot.FormaPago.domain.entities.FormaPago;

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
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message="La transaccion no puede ser nulo")
    @Column(nullable = false)
    private Integer transaccion;

    @ManyToOne
    @Valid
    @NotNull(message="La forma de pago no puede ser nulo")
    @JoinColumn(name = "forma_pago_pago", referencedColumnName = "id", nullable = false)
    private FormaPago formaPago;

    @NotNull(message="La fecha de pago no puede ser nulo")
    @Column (name = "fecha_pago", nullable=false)
    private Timestamp fechaPago;

    @ManyToOne
    @Valid
    @JoinColumn(name = "pago_cliente", referencedColumnName = "id")
    private Cliente cliente;
}
