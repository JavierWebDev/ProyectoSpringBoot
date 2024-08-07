package com.campuslands.proyectospringboot.Proveedor.domain.entities;


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
@Table(name= "proveedor")
@Data
public class Proveedor {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name= "id")
    private Long id;
    
    @NotBlank(message="El nombre no puede ser vacío")
    @Size(max=50)
    @Column(name= "nombre_proveedor")
    private String nombre;
}
