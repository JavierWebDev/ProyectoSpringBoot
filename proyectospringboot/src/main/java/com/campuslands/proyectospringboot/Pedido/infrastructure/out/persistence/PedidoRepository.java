package com.campuslands.proyectospringboot.Pedido.infrastructure.out.persistence;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.campuslands.proyectospringboot.Pedido.domain.entities.Pedido;
import com.campuslands.proyectospringboot.Pedido.domain.entities.PedidoEstadoDTO;

import jakarta.transaction.Transactional;

public interface PedidoRepository extends JpaRepository<Pedido,Long>{

        @Modifying
        @Transactional
        @Query("UPDATE Pedido p SET p.cliente = null WHERE p.cliente.id = :clienteId")
        void updateClienteToNull(@Param("clienteId") Long clienteId);


            @Query("select new com.campuslands.proyectospringboot.Pedido.domain.entities.PedidoEstadoDTO(p.id, p.fechaPedido, ep.estado)" +
                    "from Pedido p " +
                    "join p.estadoPedido ep " +
                    "where ep.estado=?1")
            List<PedidoEstadoDTO> pedidosPorEstado (String nombreEstado);

            @Query("select p from Pedido p WHERE p.fechaPedido between :fechaInicial AND :fechaFinal")
            List<Pedido> pedidosPorRangoFecha(@Param("fechaInicial") LocalDate fechaInicial, @Param("fechaFinal") LocalDate fechaFinal); 
}
