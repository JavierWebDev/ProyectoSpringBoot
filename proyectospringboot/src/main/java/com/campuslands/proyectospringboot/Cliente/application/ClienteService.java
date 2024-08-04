package com.campuslands.proyectospringboot.Cliente.application;

import java.util.List;
import java.util.Optional;

import com.campuslands.proyectospringboot.Cliente.domain.Cliente;
import com.campuslands.proyectospringboot.Cliente.infrastructure.adapters.out.ClienteRepository;

public class ClienteService {
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> list() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> findById(Long id) {
        return clienteRepository.findById(id);
    }

    public void create(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    public void deleteById(Long id) {
        clienteRepository.deleteById(id);
    }
}
