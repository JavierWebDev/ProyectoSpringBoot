package com.campuslands.proyectospringboot.GamaProducto.infrastructure.in.web;

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
import org.springframework.web.bind.annotation.RestController;

import com.campuslands.proyectospringboot.GamaProducto.application.services.GamaProductoService;
import com.campuslands.proyectospringboot.GamaProducto.domain.entities.GamaProducto;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/gamaproductos")
public class GamaProductoController {

    private final GamaProductoService gamaProductoService;

    public GamaProductoController(GamaProductoService gamaProductoService) {
        this.gamaProductoService = gamaProductoService;
    }

    @GetMapping
    public List<GamaProducto> getAllGamaProductos() {
        return gamaProductoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GamaProducto> getGamaProductoById(@PathVariable Long id) {
        Optional<GamaProducto> foundGamaProducto = gamaProductoService.findById(id);
        if (!foundGamaProducto.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(foundGamaProducto.orElseThrow(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<GamaProducto> createGamaProducto(@Valid @RequestBody GamaProducto gamaProducto) {
        gamaProductoService.save(gamaProducto);
        return new ResponseEntity<>(gamaProducto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateGamaProducto(@PathVariable Long id, @Valid @RequestBody GamaProducto gamaProducto) {
        Optional<GamaProducto> foundGamaProducto = gamaProductoService.findById(id);
        if (!foundGamaProducto.isPresent()) {
            return new ResponseEntity<>("Gama de producto no encontrada", HttpStatus.NOT_FOUND);
        }
        gamaProducto.setId(id);
        gamaProductoService.update(id, gamaProducto);
        return new ResponseEntity<>("Gama de producto actualizada correctamente", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteGamaProducto(@PathVariable Long id) {
        Optional<GamaProducto> foundGamaProducto = gamaProductoService.findById(id);
        if (!foundGamaProducto.isPresent()) {
            return new ResponseEntity<>("Gama de producto no encontrada", HttpStatus.NOT_FOUND);
        }
        gamaProductoService.delete(id);
        return new ResponseEntity<>("Gama de producto eliminada correctamente", HttpStatus.OK);
    }
}
