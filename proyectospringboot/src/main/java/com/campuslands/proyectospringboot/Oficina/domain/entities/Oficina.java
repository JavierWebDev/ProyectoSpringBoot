package com.campuslands.proyectospringboot.Oficina.domain.entities;

import java.util.Set;

import com.campuslands.proyectospringboot.Ciudad.domain.Ciudad;
import com.campuslands.proyectospringboot.CodigoPostal.domain.CodigoPostal;
import com.campuslands.proyectospringboot.Direccion.domain.entities.Direccion;
import com.campuslands.proyectospringboot.Empleado.domain.entities.Empleado;
import com.campuslands.proyectospringboot.Pais.domain.entities.Pais;
import com.campuslands.proyectospringboot.Telefono.domain.entitie.Telefono;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "oficina")
@Data
public class Oficina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id")
    private Long id;

    @ManyToOne
    @Valid
    @NotNull(message="El teléfono de oficina no puede ser nulo")
    @JoinColumn(name = "telefono_oficina", referencedColumnName = "id", nullable = false)
    private Telefono telefono;

    @ManyToOne
    @Valid
    @NotNull(message="La ciudad de la oficina no puede ser nulo")
    @JoinColumn(name = "ciudad_oficina", referencedColumnName = "id", nullable = false)
    private Ciudad ciudad;

    @ManyToOne
    @Valid
    @NotNull(message="El país de la oficina no puede ser nulo")
    @JoinColumn(name = "pais_oficina", referencedColumnName = "id", nullable = false)
    private Pais pais;

    @ManyToOne
    @JoinColumn(name = "codigo_postal_oficina", referencedColumnName = "id")
    private CodigoPostal codigoPostal;

    @OneToOne
    @Valid
    @NotNull(message="La dirección de la oficina no puede ser nulo")
    @JoinColumn(name = "direccion_oficina", referencedColumnName = "id", nullable = false)
    private Direccion direccion;

    @OneToMany(mappedBy = "oficina", cascade= CascadeType.ALL, orphanRemoval = true)
    private Set<Empleado> empleado;
}
