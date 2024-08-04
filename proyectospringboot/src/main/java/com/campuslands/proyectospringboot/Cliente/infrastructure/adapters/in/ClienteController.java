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
import org.springframework.web.bind.annotation.RestController;

import com.campuslands.proyectospringboot.Cliente.domain.Cliente;
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
    public ResponseEntity<List<Cliente>> list() {
        List<Cliente> clientes = clienteService.list();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> listById(@PathVariable Long id) {
        Optional<Cliente> fCliente = clienteService.findById(id);
        if (!fCliente.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(fCliente.get(), HttpStatus.OK);
    }

    @PostMapping
    public void create(@RequestBody Cliente cliente) {
        clienteService.create(cliente);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Cliente cliente) {
        cliente.setId(id);
        clienteService.create(cliente);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        clienteService.deleteById(id);
    }

}
