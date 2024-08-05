package com.campuslands.proyectospringboot.Telefono.domain.entitie;

import com.campuslands.proyectospringboot.TipoTelefono.domain.entities.TipoTelefono;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name="telefono")
@Data
public class Telefono {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name= "id")
    private Long id;

    @NotNull(message="El Numero de telefono no puede ser nulo")
    @Column(name= "numero_tel")
    private Integer nombre;

    @ManyToOne
    @NotNull(message="El tipo de telefono no puede ser nulo")
    @JoinColumn(name = "tipo_tel")
    private TipoTelefono tipoTelefono;
}
