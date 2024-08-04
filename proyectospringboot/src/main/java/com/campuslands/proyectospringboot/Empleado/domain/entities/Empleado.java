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

    @Column(name = "nombre_empleado")
    private String nombreEmpleado;

    @Column(name = "apellido1_empleado")
    private String apellido1Empleado;

    @Column(name = "apellido2_empleado")
    private String apellido2Empleado;

    @Column(name = "extension_empleado")
    private String extensionEmpleado;

    @Column(name = "email_empleado")
    private String emailEmpleado;

    @ManyToOne
    @JoinColumn(name = "puesto_empleado_id", referencedColumnName = "id", nullable = false)
    private Puesto puesto;

    @ManyToOne
    @JoinColumn(name = "oficina_empleado_id", referencedColumnName = "id", nullable = false)
    private Oficina oficina;
}
