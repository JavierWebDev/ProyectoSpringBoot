package com.campuslands.proyectospringboot.TipoTelefono.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name="tipotelefono")
@Data
public class TipoTelefono {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name= "id")
    private Long id;

    @NotNull(message="El nombre del tipo de telefono no puede ser nulo")
    @Column(name= "nombre_tipo_tel")
    private String nombre;

    @NotNull(message="La descripcion del tipo de telefono no puede ser nula")
    @Column(name= "descripcion_tel")
    private String descripcion;
}
