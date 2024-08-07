package com.campuslands.proyectospringboot.Cliente.infrastructure.adapters.in;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.campuslands.proyectospringboot.Cliente.domain.Cliente;
import com.campuslands.proyectospringboot.Cliente.domain.ClienteCiudadDTO;
import com.campuslands.proyectospringboot.Cliente.domain.ClientePedidoDTO;

import jakarta.validation.Valid;

import com.campuslands.proyectospringboot.Cliente.application.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public List<Cliente> getAllClientes() {
        return clienteService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable Long id) {
        Optional<Cliente> foundCliente = clienteService.findById(id);
        if (!foundCliente.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(foundCliente.orElseThrow(), HttpStatus.OK);
    }

    @GetMapping("/ciudad")
    public ResponseEntity<List<ClienteCiudadDTO>> getClientePorCiudad(@RequestParam String nombreCiudad) {
        Optional<List<ClienteCiudadDTO>> clientes = clienteService.clientePorCiudad(nombreCiudad);
        if (clientes.isPresent()) {
            return new ResponseEntity<>(clientes.orElseThrow(), HttpStatus.OK);
        }
        System.out.println("Busqueda sin resultados");
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/pedidosPendientes")
    public ResponseEntity<List<ClientePedidoDTO>> getClientesConPedidosPendientes() {
        Optional<List<ClientePedidoDTO>> clientes = clienteService.clientesConPedidosPendientes();
        if (clientes.isPresent()) {
            return new ResponseEntity<>(clientes.orElseThrow(), HttpStatus.OK);
        }
        System.out.println("Busqueda sin resultados");
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Cliente> createCliente(@Valid @RequestBody Cliente cliente) {
        clienteService.save(cliente);
        return new ResponseEntity<>(cliente, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCliente(@PathVariable Long id, @Valid @RequestBody Cliente cliente) {
        Optional<Cliente> foundCliente = clienteService.findById(id);
        if (!foundCliente.isPresent()) {
            return new ResponseEntity<>("Cliente no encontrado", HttpStatus.NOT_FOUND);
        }
        cliente.setId(id);
        clienteService.save(cliente);
        return new ResponseEntity<>("Cliente actualizado correctamente", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCliente(@PathVariable Long id) {
        Optional<Cliente> foundCliente = clienteService.findById(id);
        if (!foundCliente.isPresent()) {
            return new ResponseEntity<>("Cliente no encontrado", HttpStatus.NOT_FOUND);
        }
        clienteService.deleteById(id);
        return new ResponseEntity<>("Cliente eliminado correctamente", HttpStatus.OK);
    }

}
