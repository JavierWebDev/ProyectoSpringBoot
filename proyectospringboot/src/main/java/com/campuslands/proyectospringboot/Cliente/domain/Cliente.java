package com.campuslands.proyectospringboot.Cliente.domain;

import com.campuslands.proyectospringboot.Ciudad.domain.Ciudad;
import com.campuslands.proyectospringboot.CodigoPostal.domain.CodigoPostal;
import com.campuslands.proyectospringboot.Contacto.domain.Contacto;
import com.campuslands.proyectospringboot.Direccion.domain.entities.Direccion;
import com.campuslands.proyectospringboot.Empleado.domain.entities.Empleado;
// import com.campuslands.proyectospringboot.Telefono.domain.Telefono;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_cliente")
    private String nombre;

    @Column(name = "apellido1_cliente")
    private String apellido1;

    @Column(name = "apellido2_cliente")
    private String apellido2;

    @OneToOne
    @JoinColumn(name = "contacto_cliente")
    private Contacto contacto;

    /*
     * @OneToOne
     * 
     * @JoinColumn(name = "telefono_cliente")
     * private Telefono telefono;
     * 
     * @OneToOne
     * 
     * @JoinColumn(name = "fax_cliente")
     * private Fax fax;
     */

    @ManyToOne
    @JoinColumn(name = "direccion_clientes")
    private Direccion direccion;

    @ManyToOne
    @JoinColumn(name = "ciudad_cliente")
    private Ciudad ciudad;

    @ManyToOne
    @JoinColumn(name = "codigo_postal_cliente")
    private CodigoPostal codigoPostal;

    /*
     * @ManyToOne
     * 
     * @JoinColumn(name = "pais_cliente")
     * private Pais pais;
     */

    @ManyToOne
    @JoinColumn(name = "empleado_cliente")
    private Empleado empleado;
}
