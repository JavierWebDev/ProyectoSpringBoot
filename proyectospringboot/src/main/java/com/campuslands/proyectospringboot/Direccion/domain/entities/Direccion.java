package com.campuslands.proyectospringboot.Direccion.domain.entities;

import com.campuslands.proyectospringboot.Barrio.domain.Barrio;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
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

    @NotBlank(message="La calle no puede ser vacío")
    @Column(name = "calle", nullable = false)
    private String calle;

    @NotNull(message="El número de la calle no puede ser nulo")
    @Column(name = "numero", nullable = false)
    private Integer numero;

    @ManyToOne
    @NotNull(message="El barrio no puede ser vacío")
    @JoinColumn(name="barrio", nullable = false)
    private Barrio dirBarrio;
}
