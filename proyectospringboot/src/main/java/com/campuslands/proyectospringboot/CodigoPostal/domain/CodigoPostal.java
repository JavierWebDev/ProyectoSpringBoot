package com.campuslands.proyectospringboot.CodigoPostal.domain;


import com.campuslands.proyectospringboot.Region.domain.entities.Region;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
@Table(name = "codigo_postal")
public class CodigoPostal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message="El código no puede ser vacío")
    @Size(max=30)
    private String codigo;

    @ManyToOne
    @NotNull(message = "La region no puede ser nula")
    @JoinColumn(name = "region_global", referencedColumnName = "id", nullable = false)
    private Region region;

}
