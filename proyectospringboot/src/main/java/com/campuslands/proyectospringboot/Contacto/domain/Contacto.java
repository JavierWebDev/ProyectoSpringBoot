package com.campuslands.proyectospringboot.Contacto.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
@Table(name = "contacto")
public class Contacto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message="El nombre no puede ser vacío")
    @Size(max=50)
    @Column(name = "nombre_contacto")
    private String nombre;

    @NotBlank(message="El apellido no puede ser vacío")
    @Size(max=50)
    @Column(name = "apellido_contacto")
    private String apellido;
}
