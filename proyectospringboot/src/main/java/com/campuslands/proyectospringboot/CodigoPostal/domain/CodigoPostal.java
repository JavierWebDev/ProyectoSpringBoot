package com.campuslands.proyectospringboot.CodigoPostal.domain;


import com.campuslands.proyectospringboot.Region.domain.entities.Region;

import jakarta.persistence.*;
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
