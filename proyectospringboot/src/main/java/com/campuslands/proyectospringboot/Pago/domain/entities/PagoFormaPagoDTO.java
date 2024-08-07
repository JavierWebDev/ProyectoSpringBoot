package com.campuslands.proyectospringboot.Pago.domain.entities;

import lombok.Data;

@Data
public class PagoFormaPagoDTO {
    private Long id;
    private Integer transaccion;
    private String formaPago;
}
