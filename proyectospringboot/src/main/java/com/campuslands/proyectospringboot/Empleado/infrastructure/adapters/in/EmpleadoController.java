package com.campuslands.proyectospringboot.Empleado.infrastructure.adapters.in;

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

import com.campuslands.proyectospringboot.Empleado.app.services.EmpleadoService;
import com.campuslands.proyectospringboot.Empleado.domain.entities.Empleado;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/empleado")
@AllArgsConstructor
public class EmpleadoController {

    private final EmpleadoService empleadoService;

    @GetMapping
    public List<Empleado> getAllEmpleados() {
        return empleadoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empleado> getEmpleadoById(@PathVariable Long id) {
        Optional<Empleado> foundEmpleado = empleadoService.findById(id);
        if (!foundEmpleado.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(foundEmpleado.orElseThrow(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Empleado> createEmpleado(@Valid @RequestBody Empleado empleado) {
        empleadoService.save(empleado);
        return new ResponseEntity<>(empleado, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateEmpleado(@PathVariable Long id, @Valid @RequestBody Empleado empleado) {
        Optional<Empleado> foundEmpleado = empleadoService.findById(id);
        if (!foundEmpleado.isPresent()) {
            return new ResponseEntity<>("Empleado no encontrado", HttpStatus.NOT_FOUND);
        }
        empleado.setId(id);
        empleadoService.save(empleado);
        return new ResponseEntity<>("Empleado actualizado correctamente", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmpleado(@PathVariable Long id) {
        Optional<Empleado> foundEmpleado = empleadoService.findById(id);
        if (!foundEmpleado.isPresent()) {
            return new ResponseEntity<>("Empleado no encontrado", HttpStatus.NOT_FOUND);
        }
        empleadoService.deleteById  (id);
        return new ResponseEntity<>("Empleado eliminado correctamente", HttpStatus.OK);
    }
}
