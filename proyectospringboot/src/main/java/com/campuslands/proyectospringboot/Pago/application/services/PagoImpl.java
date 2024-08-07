package com.campuslands.proyectospringboot.Pago.application.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.campuslands.proyectospringboot.Pago.domain.entities.Pago;
import com.campuslands.proyectospringboot.Pago.domain.entities.PagoClienteDTO;
import com.campuslands.proyectospringboot.Pago.domain.entities.PagoFormaPagoDTO;
import com.campuslands.proyectospringboot.Pago.infrastructure.out.persistence.PagoRepository;

@Component
public class PagoImpl implements PagoService {
    
    @Autowired
    private PagoRepository repository;

    @Transactional
    @Override
    public List<Pago> findAll() {
        return (List<Pago>) repository.findAll();
    }

    @Transactional
    @Override
    public Optional<Pago> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public Pago save(Pago pago) {
        return repository.save(pago);
    }

    @Transactional
    @Override
    public Optional<Pago> delete(Long id) {
        Optional<Pago> pagoOpt = repository.findById(id);
        pagoOpt.ifPresent(pI -> {
            repository.delete(pI);
        });
        return pagoOpt;
    }

    @Override
    public Optional<Pago> update(Long id, Pago pago) {
        Optional<Pago> pagoOpt = repository.findById(id);
        if (pagoOpt.isPresent()) {
            Pago pagoItem = pagoOpt.orElseThrow();
            pagoItem.setTransaccion(pago.getTransaccion());
            pagoItem.setFormaPago(pago.getFormaPago());
            pagoItem.setFechaPago(pago.getFechaPago());
            pagoItem.setPagoCliente(pago.getPagoCliente());
            return Optional.of(repository.save(pagoItem));
        }
        return pagoOpt;
    }

    @Override
    public Optional<List<PagoClienteDTO>> pagosPorCliente(Long clienteId) {
        return Optional.of(repository.pagosPorCliente(clienteId));
    }

    @Override
    public Optional<List<PagoFormaPagoDTO>> pagosPorFormaPago(String formaPago) {
        return Optional.of(repository.pagosPorFormaPago(formaPago));
    }
}

