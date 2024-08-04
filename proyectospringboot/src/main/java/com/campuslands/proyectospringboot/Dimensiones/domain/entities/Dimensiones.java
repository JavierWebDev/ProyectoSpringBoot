package com.campuslands.proyectospringboot.Dimensiones.domain.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "dimenciones")
@Data
public class Dimensiones {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ancho")
    private double ancho;

    @Column(name = "largo")
    private double largo;

    @Column(name = "alto")
    private double alto;
}
