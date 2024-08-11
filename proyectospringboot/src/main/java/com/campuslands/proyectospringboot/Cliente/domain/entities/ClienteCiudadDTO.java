package com.campuslands.proyectospringboot.Cliente.domain.entities;

import lombok.Data;

@Data
public class ClienteCiudadDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private String ciudad;
}
