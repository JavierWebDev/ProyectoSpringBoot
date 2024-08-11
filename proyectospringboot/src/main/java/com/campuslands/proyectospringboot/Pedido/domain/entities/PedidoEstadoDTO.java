package com.campuslands.proyectospringboot.Pedido.domain.entities;

import java.time.LocalDate;

import lombok.Data;

@Data
public class PedidoEstadoDTO {
    private Long id;
    private LocalDate fechaPedido;
    private String estado;
}
