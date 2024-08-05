package com.campuslands.proyectospringboot.Direccion.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "direccion")
@Data
public class Direccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull(message="La calle no puede ser nulo")
    @Column(name = "calle", nullable = false)
    private String calle;

    @NotNull(message="El número de la calle no puede ser nulo")
    @Column(name = "numero", nullable = false)
    private Integer numero;

    @NotNull(message="El barrio no puede ser nulo")
    @Column(name = "barrio", nullable = false)
    private String barrio;
}
