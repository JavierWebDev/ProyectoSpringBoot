package com.campuslands.proyectospringboot.Pago.domain.entities;

import lombok.Data;

@Data
public class PagoClienteDTO {
    private Long id;
    private Integer transaccion;
    private Long pagoCliente;
}
