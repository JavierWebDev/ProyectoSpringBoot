package com.campuslands.proyectospringboot.DetallePedido.infrastructure.adapters.out;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campuslands.proyectospringboot.DetallePedido.domain.DetallePedido;

public interface DetallePedidoRepository extends JpaRepository<DetallePedido, Long> {

}
