package com.campuslands.proyectospringboot.Empleado.domain.entities;

import lombok.Data;

@Data
public class EmpleadoOficinaDTO {
    private Long id;
    private String empleado;
    private Long oficinaId;
}
