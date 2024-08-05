package com.campuslands.proyectospringboot.Empleado.infrastructure.adapters.in;

import java.util.List;

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
    
    private final EmpleadoService EmpleadoService;

    @GetMapping
    public List<Empleado> getAllEmpleados() {
        return EmpleadoService.findAll();
    }

    @GetMapping("/{id}")
    public Empleado getEmpleadoById(@PathVariable Long id) {
        return EmpleadoService.findById(id);
    }

    @PostMapping
    public Empleado createEmpleado(@Valid @RequestBody Empleado Empleado) {
        return EmpleadoService.save(Empleado);
    }

    @PutMapping("/{id}")
    public Empleado updateEmpleado(@PathVariable Long id, @Valid @RequestBody Empleado Empleado) {
        Empleado.setId(id);
        return EmpleadoService.save(Empleado);
    }

    @DeleteMapping("/{id}")
    public void deleteEmpleado(@PathVariable Long id) {
        EmpleadoService.deleteById(id);
    }
}
