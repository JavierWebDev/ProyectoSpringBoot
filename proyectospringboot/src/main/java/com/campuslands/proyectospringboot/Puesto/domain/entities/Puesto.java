package com.campuslands.proyectospringboot.Puesto.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name= "puesto")
@Data
public class Puesto {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name= "id")
    private Long id;

    @NotNull(message="El campo ''puesto'' no puede ser nulo")
    @Column(name= "puesto")
    private String puesto;
}
