package com.campuslands.proyectospringboot.Empleado.infrastructure.adapters.out;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.campuslands.proyectospringboot.Empleado.domain.entities.Empleado;
import com.campuslands.proyectospringboot.Empleado.domain.entities.EmpleadoOficinaDTO;
import com.campuslands.proyectospringboot.Empleado.domain.entities.EmpleadoPedidoDTO;


public interface EmpleadoRepository extends JpaRepository<Empleado, Long>{

    @Query("select new com.campuslands.proyectospringboot.Empleado.domain.entities.EmpleadoOficinaDTO(e.id, CONCAT(e.nombreEmpleado,' ', e.apellido1Empleado), o.id)" +
            "from Empleado e " +
            "join e.oficina o " +
            "where o.id=?1")
    List<EmpleadoOficinaDTO> empleadosPorOficina(Long oficinaId);

    @Query("select new com.campuslands.proyectospringboot.Empleado.domain.entities.EmpleadoPedidoDTO(e, p.id, cp.id)" +
            "from Pedido p " +
            "join p.cliente cp " +
            "join cp.empleado e " +
            "order by e.id")
    List<EmpleadoPedidoDTO> empleadosConPedidos();

}
