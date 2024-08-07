package com.campuslands.proyectospringboot.DetallePedido.application;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.campuslands.proyectospringboot.DetallePedido.domain.DetallePedido;
import com.campuslands.proyectospringboot.DetallePedido.infrastructure.adapters.out.DetallePedidoRepository;

@Service
public class DetallePedidoService {
    private final DetallePedidoRepository detallePedidoRepository;

    public DetallePedidoService(DetallePedidoRepository detallePedidoRepository) {
        this.detallePedidoRepository = detallePedidoRepository;
    }

    public List<DetallePedido> list() {
        return detallePedidoRepository.findAll();
    }

    public Optional<DetallePedido> findById(Long id) {
        return detallePedidoRepository.findById(id);
    }

    public void create(DetallePedido detallePedido) {
        detallePedidoRepository.save(detallePedido);
    }

    public void deleteById(Long id) {
        detallePedidoRepository.deleteById(id);
    }
}
