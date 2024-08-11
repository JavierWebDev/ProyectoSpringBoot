package com.campuslands.proyectospringboot.Cliente.domain.entities;

import lombok.Data;

@Data
public class ClientePedidoDTO {
    private Cliente cliente;
    private String estadoPedido;
}
