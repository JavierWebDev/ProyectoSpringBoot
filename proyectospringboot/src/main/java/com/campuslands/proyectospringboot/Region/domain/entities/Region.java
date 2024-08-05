package com.campuslands.proyectospringboot.Region.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name="region")
@Data
public class Region {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name= "id")
    private Long id;

    @NotNull(message="El nombre de la region no puede ser nulo")
    @Column(name= "nombre_region")
    private String nombre;
}
