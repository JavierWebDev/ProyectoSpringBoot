package com.campuslands.proyectospringboot.Empleado.domain.entities;

import lombok.Data;

@Data
public class EmpleadoPedidoDTO {
    private Empleado empleado;
    private Long pedidoId;
    private Long clienteId;
}
