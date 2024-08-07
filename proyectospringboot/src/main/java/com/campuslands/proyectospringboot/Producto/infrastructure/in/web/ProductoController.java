package com.campuslands.proyectospringboot.Producto.infrastructure.in.web;

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

import com.campuslands.proyectospringboot.Producto.application.services.ProductoService;
import com.campuslands.proyectospringboot.Producto.domain.entities.Producto;
import com.campuslands.proyectospringboot.Producto.domain.entities.ProductoGamaDTO;

import jakarta.validation.Valid;



@RestController
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    public List<Producto> getAllProductos() {
        return productoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> getProductoById(@PathVariable Long id) {
        Optional<Producto> foundProducto = productoService.findById(id);
        if (!foundProducto.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(foundProducto.orElseThrow(), HttpStatus.OK);
    }

    @GetMapping("/gama")
    public ResponseEntity<List<ProductoGamaDTO>> getProductosPorGama(@RequestParam String nombreGama) {
        Optional<List<ProductoGamaDTO>> productos = productoService.productosPorGama(nombreGama);

        if (productos.isPresent()) {
            return new ResponseEntity<>(productos.orElseThrow(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
    @PostMapping
    public ResponseEntity<Producto> createProducto(@Valid @RequestBody Producto producto) {
        productoService.save(producto);
        return new ResponseEntity<>(producto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
        public ResponseEntity<String> updateProducto(@PathVariable Long id, @Valid @RequestBody Producto product) {
            Optional<Producto> foundProducto = productoService.findById(id);
            if (!foundProducto.isPresent()){
            return new ResponseEntity<>("Producto no encontrado", HttpStatus.NOT_FOUND);
            }      
            product.setId(id);
            productoService.update(id, product);  
        return new ResponseEntity<>("Producto actualizado correctamente", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> DeleteProducto(@PathVariable Long id) {
        Optional<Producto> foundProducto = productoService.findById(id);
        if (!foundProducto.isPresent()){
            return new ResponseEntity<>("Producto no encontrado", HttpStatus.NOT_FOUND);
        } 
        productoService.delete(id);
        return new ResponseEntity<>("Producto eliminado correctamente", HttpStatus.OK);
    } 
}

