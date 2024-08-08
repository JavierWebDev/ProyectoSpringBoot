package com.campuslands.proyectospringboot.DetallePedido.infrastructure.adapters.in;

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

import com.campuslands.proyectospringboot.DetallePedido.application.DetallePedidoService;
import com.campuslands.proyectospringboot.DetallePedido.domain.DetallePedido;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/detallepedido")
public class DetallePedidoController {
    @Autowired
    DetallePedidoService detallePedidoService;

    public DetallePedidoController(DetallePedidoService detallePedidoService) {
        this.detallePedidoService = detallePedidoService;
    }

    @GetMapping
    public ResponseEntity<List<DetallePedido>> list() {
        List<DetallePedido> detallePedidoes = detallePedidoService.list();
        return ResponseEntity.ok(detallePedidoes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetallePedido> listById(@PathVariable Long id) {
        Optional<DetallePedido> fDetallePedido = detallePedidoService.findById(id);
        if (!fDetallePedido.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(fDetallePedido.get(), HttpStatus.OK);
    }

    @PostMapping
    public void create(@RequestBody DetallePedido detallePedido) {
        detallePedidoService.create(detallePedido);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateDetallePedido(@PathVariable Long id, @Valid @RequestBody DetallePedido DetallePedido) {
        Optional<DetallePedido> foundDetallePedido = detallePedidoService.findById(id);
        if (!foundDetallePedido.isPresent()) {
            return new ResponseEntity<>("DetallePedido no encontrado", HttpStatus.NOT_FOUND);
        }
        DetallePedido.setId(id);
        detallePedidoService.create(DetallePedido);
        return new ResponseEntity<>("DetallePedido ha sido guardado correctamente", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDetallePedido(@PathVariable Long id) {
        Optional<DetallePedido> foundDetallePedido = detallePedidoService.findById(id);
        if (!foundDetallePedido.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        detallePedidoService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
