package com.campuslands.proyectospringboot.Empleado.domain.entities;

import org.hibernate.annotations.EmbeddableInstantiator;

import com.campuslands.proyectospringboot.Oficina.domain.entities.Oficina;
import com.campuslands.proyectospringboot.Puesto.domain.entities.Puesto;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "empleado")
@Data
public class Empleado {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombreEmpleado")
    private String nombreEmpleado;

    @Column(name = "apellido1Empleado")
    private String apellido1Empleado;

    @Column(name = "apellido2Empleado")
    private String apellido2Empleado;

    @Column(name = "extensionEmpleado")
    private String extensionEmpleado;

    @Column(name = "emailEmpleado")
    private String emailEmpleado;

    @ManyToOne
    @JoinColumn(name = "puestoEmpleadoId", referencedColumnName = "id", nullable = false)
    private Puesto puesto;

    @ManyToOne
    @JoinColumn(name = "oficinaEmpleadoId", referencedColumnName = "id", nullable = false)
    private Oficina oficina;

    
}
