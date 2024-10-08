package com.campuslands.proyectospringboot.GamaProducto.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table
@Data
public class GamaProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message="El nombre de la gama de producto no puede ser vacío")
    @Column (nullable = false)
    private String nombre;

    @NotBlank(message="La descripción del producto no puede ser vacío")
    @Column (nullable = false)
    private String descripcion;

    @Column(name = "descripcion_html")
    private String descripcionHtml;
    private String imagen;
}
