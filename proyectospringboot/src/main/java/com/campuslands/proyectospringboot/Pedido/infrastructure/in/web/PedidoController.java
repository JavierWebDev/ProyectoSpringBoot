package com.campuslands.proyectospringboot.Pedido.infrastructure.in.web;

import java.util.List;
import java.util.Optional;

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

import com.campuslands.proyectospringboot.Pedido.application.services.PedidoService;
import com.campuslands.proyectospringboot.Pedido.domain.entities.Pedido;
import com.campuslands.proyectospringboot.Pedido.domain.entities.PedidoEstadoDTO;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping
    public List<Pedido> getAllPedidos() {
        return pedidoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> getPedidoById(@PathVariable Long id) {
        Optional<Pedido> foundPedido = pedidoService.findById(id);
        if (!foundPedido.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(foundPedido.orElseThrow(), HttpStatus.OK);
    }

    @GetMapping("/estado")
    public ResponseEntity<List<PedidoEstadoDTO>> getPedidosPorEstado(@RequestParam String nombreGama) {
        Optional<List<PedidoEstadoDTO>> pedidos = pedidoService.pedidosPorEstado(nombreGama);
        if (pedidos.isPresent()) {
            return new ResponseEntity<>(pedidos.orElseThrow(), HttpStatus.OK);
        }
        System.out.println("Busqueda sin resultados");
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Pedido> createPedido(@Valid @RequestBody Pedido pedido) {
        pedidoService.save(pedido);
        return new ResponseEntity<>(pedido, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
        public ResponseEntity<String> updatePedido(@PathVariable Long id, @Valid @RequestBody Pedido pedido) {
        Optional<Pedido> foundPedido = pedidoService.findById(id);
        if (!foundPedido.isPresent()){
            return new ResponseEntity<>("Pedido no encontrado", HttpStatus.NOT_FOUND);
        }
            pedido.setId(id);
            pedidoService.update(id, pedido);  
        return new ResponseEntity<>("Pedido actualizado correctamente", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> DeletePedido(@PathVariable Long id) {
        Optional<Pedido> foundPedido = pedidoService.findById(id);
        if (!foundPedido.isPresent()){
            return new ResponseEntity<>("Pedido no encontrado", HttpStatus.NOT_FOUND);
        } 
        pedidoService.delete(id);
        return new ResponseEntity<>("Pedido eliminado correctamente", HttpStatus.OK);
    }

}
