package com.campuslands.proyectospringboot.Cliente.domain;

import com.campuslands.proyectospringboot.Ciudad.domain.Ciudad;
import com.campuslands.proyectospringboot.CodigoPostal.domain.CodigoPostal;
import com.campuslands.proyectospringboot.Contacto.domain.Contacto;
import com.campuslands.proyectospringboot.Direccion.domain.entities.Direccion;
import com.campuslands.proyectospringboot.Empleado.domain.entities.Empleado;
import com.campuslands.proyectospringboot.Fax.domain.entities.Fax;
import com.campuslands.proyectospringboot.Pais.domain.entities.Pais;
import com.campuslands.proyectospringboot.Telefono.domain.entitie.Telefono;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message="El nombre de cliente no puede ser vacío")
    @Size(max=50)
    @Column(name = "nombre_cliente", nullable = false)
    private String nombre;

    @NotBlank(message="El apellido de cliente no puede ser vacío")
    @Size(max=50)
    @Column(name = "apellido1_cliente", nullable = false)
    private String apellido1;

    @NotBlank(message="El apellido de cliente no puede ser vacío")
    @Size(max=50)
    @Column(name = "apellido2_cliente", nullable = false)
    private String apellido2;

    @ManyToOne
    @NotNull(message = "El contacto no puede ser nulo")
    @JoinColumn(name = "contacto_cliente", nullable = false)
    private Contacto contacto;

    
    @ManyToOne
    @NotNull(message = "El teléfono no puede ser nulo")
    @JoinColumn(name = "telefono_cliente", nullable = false)
    private Telefono telefono;
 
    @ManyToOne
    @NotNull(message = "El fax no puede ser nulo")
    @JoinColumn(name = "fax_cliente", nullable = false)
    private Fax fax;
    
    @ManyToOne
    @NotNull(message = "La dirección no puede ser nulo")
    @JoinColumn(name = "direccion_clientes", nullable = false)
    private Direccion direccion;

    @ManyToOne
    @NotNull(message = "La ciudad no puede ser nulo")
    @JoinColumn(name = "ciudad_cliente", nullable = false)
    private Ciudad ciudad;

    @ManyToOne
    @NotNull(message = "El código postal no puede ser nulo")
    @JoinColumn(name = "codigo_postal_cliente", nullable = false)
    private CodigoPostal codigoPostal;

    
    @ManyToOne
    @NotNull(message = "El país no puede ser nulo")
    @JoinColumn(name = "pais_cliente", nullable = false)
    private Pais pais;
     

    @ManyToOne
    @NotNull(message = "El empleado no puede ser nulo")
    @JoinColumn(name = "empleado_cliente", nullable = false)
    private Empleado empleado;
}
