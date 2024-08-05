package com.campuslands.proyectospringboot.Autenticacion.domain.entities;

import lombok.Data;

@Data 
public class LoginRequest {
    private String username;
    private String password;
}