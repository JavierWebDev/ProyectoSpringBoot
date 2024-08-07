package com.campuslands.proyectospringboot.Pedido.infrastructure.out.persistence;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.campuslands.proyectospringboot.Pedido.domain.entities.Pedido;
import com.campuslands.proyectospringboot.Pedido.domain.entities.PedidoEstadoDTO;

public interface PedidoRepository extends JpaRepository<Pedido,Long>{

        @Query("select new com.campuslands.proyectospringboot.Pedido.domain.entities.PedidoEstadoDTO(p.id, p.fechaPedido, ep.estado)" +
                "from Pedidos p" +
                "join p.estadoPedido ep"+
                "where ep.nombre=?1")
        List<PedidoEstadoDTO> pedidosPorEstado (String nombreEstado);

        @Query("select p from Pedido p WHERE p.fechaPedido between :fechaInicial AND :fechaFinal")
        List<Pedido> pedidosPorRangoFecha(@Param("fechaInicial") LocalDate fechaInicial, @Param("fechaFinal") LocalDate fechaFinal);
}
