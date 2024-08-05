package com.campuslands.proyectospringboot.Autenticacion.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponse {
    private String token; 
    private String message;
}