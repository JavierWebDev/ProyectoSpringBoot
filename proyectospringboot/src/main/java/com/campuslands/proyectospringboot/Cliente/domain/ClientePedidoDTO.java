package com.campuslands.proyectospringboot.Cliente.domain;

import lombok.Data;

@Data
public class ClientePedidoDTO {
    private Cliente cliente;
    private String estadoPedido;
}
