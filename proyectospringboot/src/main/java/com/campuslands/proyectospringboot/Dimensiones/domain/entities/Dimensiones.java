package com.campuslands.proyectospringboot.Dimensiones.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "dimenciones")
@Data
public class Dimensiones {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message="El ancho no puede ser nulo")
    @Column(name = "ancho", nullable = false)
    private double ancho;

    @NotNull(message="El largo no puede ser nulo")
    @Column(name = "largo", nullable = false)
    private double largo;

    @NotNull(message="El alto no puede ser nulo")
    @Column(name = "alto", nullable = false)
    private double alto;
}
