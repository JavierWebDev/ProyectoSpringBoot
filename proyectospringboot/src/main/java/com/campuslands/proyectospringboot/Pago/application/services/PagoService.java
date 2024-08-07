package com.campuslands.proyectospringboot.Pago.application.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.campuslands.proyectospringboot.Pago.domain.entities.Pago;
import com.campuslands.proyectospringboot.Pago.domain.entities.PagoClienteDTO;
import com.campuslands.proyectospringboot.Pago.domain.entities.PagoFormaPagoDTO;

@Service
public interface PagoService {
    List<Pago> findAll();
    Optional<Pago> findById(Long id);
    Pago save(Pago pago);
    Optional<Pago> update(Long id, Pago pago);
    Optional<Pago> delete(Long id);
    Optional<List<PagoClienteDTO>> pagosPorCliente (Long clienteId);
    Optional<List<PagoFormaPagoDTO>> pagosPorFormaPago (String formaPago);
}
