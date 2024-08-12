package com.campuslands.proyectospringboot.Cliente.application;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.campuslands.proyectospringboot.Cliente.domain.entities.Cliente;
import com.campuslands.proyectospringboot.Cliente.domain.entities.ClienteCiudadDTO;
import com.campuslands.proyectospringboot.Cliente.domain.entities.ClientePedidoDTO;
import com.campuslands.proyectospringboot.Cliente.infrastructure.adapters.out.ClienteRepository;
import com.campuslands.proyectospringboot.Pedido.infrastructure.out.persistence.PedidoRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class ClienteService {

    @Autowired
    private PedidoRepository pedidoRepository;


    @PersistenceContext
    private EntityManager entityManager;
    
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> findById(Long id) {
        return clienteRepository.findById(id);
    }

    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Transactional
    public void deleteById(Long clienteId) {
        pedidoRepository.updateClienteToNull(clienteId);
        clienteRepository.deleteById(clienteId);
    }

    public Optional<List<ClienteCiudadDTO>> clientePorCiudad(String nombreCiudad) {
        return Optional.of(clienteRepository.clientePorCiudad(nombreCiudad));
    }

    public Optional<List<ClientePedidoDTO>> clientesConPedidosPendientes () {
        return Optional.of(clienteRepository.clientesConPedidosPendientes());
    }

    @Transactional
    public void disableForeignKeyChecks() {
        entityManager.createNativeQuery("SET FOREIGN_KEY_CHECKS = 0").executeUpdate();
    }

    @Transactional
    public void enableForeignKeyChecks() {
        entityManager.createNativeQuery("SET FOREIGN_KEY_CHECKS = 1").executeUpdate();
    }
}
