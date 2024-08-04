package com.campuslands.proyectospringboot.Proveedor.infrastructure.in;

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

import com.campuslands.proyectospringboot.Proveedor.app.services.ProveedorService;
import com.campuslands.proyectospringboot.Proveedor.domain.entities.Proveedor;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/proveedor")
public class ProveedorController {

    public ProveedorController(ProveedorService proveedorService) {
        this.proveedorService = proveedorService;
    }
    
    private final ProveedorService proveedorService;

    @GetMapping
    public List<Proveedor> getAllProveedores() {
        return proveedorService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Proveedor> getProveedorById(@PathVariable Long id) {
        Optional<Proveedor> foundProveedor = proveedorService.findById(id);
        if (!foundProveedor.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(foundProveedor.get(), HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<Proveedor> createProveedor(@Valid @RequestBody Proveedor proveedor){
        proveedorService.save(proveedor);
        return new ResponseEntity<>(proveedor, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateProveedor(@PathVariable Long id, @Valid @RequestBody Proveedor proveedor) {
    Optional<Proveedor> foundProveedor = proveedorService.findById(id);
    if (!foundProveedor.isPresent()) {
        return new ResponseEntity<>("Proveedor no encontrado", HttpStatus.NOT_FOUND);
    }
    proveedor.setId(id);
    proveedorService.save(proveedor);
    return new ResponseEntity<>("Proveedor ha sido guardado correctamente", HttpStatus.OK);
    }

    // @PutMapping("/{id}")
    // public ResponseEntity<Proveedor> updateProveedor(@PathVariable Long id, @Valid @RequestBody Proveedor proveedor) {
    //     Optional<Proveedor> existingProveedor = proveedorService.findById(id);
    //     if (!existingProveedor.isPresent()) {
    //         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    //     }
    //     proveedor.setId(id);
    //     proveedorService.save(proveedor);
    //     return new ResponseEntity<>(proveedor, HttpStatus.ACCEPTED);
    // }
 

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProveedor(@PathVariable Long id) {
        Optional<Proveedor> foundProveedor = proveedorService.findById(id);
        if (!foundProveedor.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        proveedorService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
