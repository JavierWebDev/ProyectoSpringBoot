package com.campuslands.proyectospringboot.Pedido.application.services;

import java.util.List;
import java.util.Optional;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.campuslands.proyectospringboot.Pedido.domain.entities.Pedido;
import com.campuslands.proyectospringboot.Pedido.domain.entities.PedidoEstadoDTO;
import com.campuslands.proyectospringboot.Pedido.infrastructure.out.persistence.PedidoRepository;

@Component
public class PedidoImpl implements PedidoService{

    @Autowired
    private PedidoRepository repository;

    @Transactional
    @Override
    public List<Pedido> findAll() {
        return (List<Pedido>) repository.findAll();
    }

    @Transactional
    @Override
    public Optional<Pedido> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public Pedido save(Pedido pedido) {
        return repository.save(pedido);
    }

    @Transactional
    @Override
    public Optional<Pedido> delete(Long id) {
        Optional<Pedido> pedidoOpt = repository.findById(id);
        pedidoOpt.ifPresent(pI -> {
            repository.delete(pI);
        });
        return pedidoOpt;
    }

    @Override
    public Optional<Pedido> update(Long id, Pedido pedido) {
        Optional<Pedido> pedidoOpt = repository.findById(id);
        if (pedidoOpt.isPresent()) {
            Pedido pedidoItem = pedidoOpt.orElseThrow();
            pedidoItem.setFechaPedido(pedido.getFechaPedido());
            pedidoItem.setFechaEsperada(pedido.getFechaEsperada());
            pedidoItem.setFechaEntrega(pedido.getFechaEntrega());
            pedidoItem.setComentarios(pedido.getComentarios());
            pedidoItem.setClientePedido(pedido.getClientePedido());
            pedidoItem.setEstadoPedido(pedido.getEstadoPedido());
            

            return Optional.of(repository.save(pedidoItem));
        }
        return pedidoOpt;
    }

    @Override
    public Optional<List<PedidoEstadoDTO>> pedidosPorEstado(String nombreEstado) {
        return Optional.of(repository.pedidosPorEstado(nombreEstado));
    }

    @Override
    public Optional<List<Pedido>> pedidosPorRangoFecha(LocalDate fechaInicial, LocalDate fechaFinal) {
        return Optional.of(repository.pedidosPorRangoFecha(fechaInicial, fechaFinal));
    }
}
