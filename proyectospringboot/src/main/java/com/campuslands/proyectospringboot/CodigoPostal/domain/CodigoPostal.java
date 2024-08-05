package com.campuslands.proyectospringboot.CodigoPostal.domain;


import com.campuslands.proyectospringboot.Region.domain.entities.Region;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "codigo_postal")
public class CodigoPostal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigo;

    @ManyToOne
    @JoinColumn(name = "region_global", referencedColumnName = "id", nullable = false)
    private Region region;

}
