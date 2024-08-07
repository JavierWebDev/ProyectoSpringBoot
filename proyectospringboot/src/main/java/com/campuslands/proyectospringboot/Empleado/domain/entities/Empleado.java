package com.campuslands.proyectospringboot.Empleado.domain.entities;


import com.campuslands.proyectospringboot.Oficina.domain.entities.Oficina;
// import com.campuslands.proyectospringboot.Puesto.domain.entities.Puesto;
import com.campuslands.proyectospringboot.Puesto.domain.entities.Puesto;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "empleado")
@Data
public class Empleado {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message="El nombre del empleado no puede ser vacío")
    @Column(name = "nombre_empleado", nullable = false)
    private String nombreEmpleado;

    @NotBlank(message="El apellido del no puede ser vacío")
    @Column(name = "apellido1_empleado", nullable = false)
    private String apellido1Empleado;

    @NotBlank(message="El apellido del no puede ser vacío")
    @Column(name = "apellido2_empleado", nullable = false)
    private String apellido2Empleado;

    @NotBlank(message="El apellido del no puede ser vacío")
    @Column(name = "extension_empleado", nullable = false)
    private String extensionEmpleado;

    @NotBlank(message="El email del empleado no puede ser vacío")
    @Email(message = "Debe ser una dirección de correo electrónico válida")
    @Column(name = "email_empleado", nullable = false)
    private String emailEmpleado;

    @ManyToOne
    @NotNull(message="La oficina del empleado no puede ser nulo")
    @JoinColumn(name = "oficina_empleado_id", referencedColumnName = "id", nullable = false)
    private Oficina oficina;

    @ManyToOne
    @NotNull(message="El puesto del empleado no puede ser nulo")
    @JoinColumn(name = "puesto_empleado_id", referencedColumnName = "id", nullable = false)
    private Puesto puesto;
}
