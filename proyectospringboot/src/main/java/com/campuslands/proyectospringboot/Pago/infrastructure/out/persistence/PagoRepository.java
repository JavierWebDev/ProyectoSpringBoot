package com.campuslands.proyectospringboot.Pago.infrastructure.out.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.campuslands.proyectospringboot.Pago.domain.entities.Pago;
import com.campuslands.proyectospringboot.Pago.domain.entities.PagoClienteDTO;
import com.campuslands.proyectospringboot.Pago.domain.entities.PagoFormaPagoDTO;

@Repository
public interface PagoRepository extends JpaRepository<Pago,Long>{

        @Query("select new com.campuslands.proyectospringboot.Pago.domain.entities.PagoClienteDTO(p.id, p.transaccion, p.pagoCliente)" +
                "from Pago p" +
                "where p.pagoCliente=?1")
        List<PagoClienteDTO> pagosPorCliente (Long clienteId);

        @Query("select new com.campuslands.proyectospringboot.Pago.domain.entities.PagoFormaPagoDTO(p.id, p.transaccion, fp.formaPago)" +
                "from Pago p" +
                "join p.formaPago fp" +
                "where fp.formaPago=?1")
        List<PagoFormaPagoDTO> pagosPorFormaPago (String formaPago);
}
