package com.campuslands.proyectospringboot.Cliente.application;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.campuslands.proyectospringboot.Cliente.domain.Cliente;
import com.campuslands.proyectospringboot.Cliente.domain.ClienteCiudadDTO;
import com.campuslands.proyectospringboot.Cliente.domain.ClientePedidoDTO;
import com.campuslands.proyectospringboot.Cliente.infrastructure.adapters.out.ClienteRepository;
@Service
public class ClienteService {
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

    public void deleteById(Long id) {
        clienteRepository.deleteById(id);
    }

    public Optional<List<ClienteCiudadDTO>> clientePorCiudad(String nombreCiudad) {
        return Optional.of(clienteRepository.clientePorCiudad(nombreCiudad));
    }

    public Optional<List<ClientePedidoDTO>> clientesConPedidosPendientes () {
        return Optional.of(clienteRepository.clientesConPedidosPendientes());
    }
}
