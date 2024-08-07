package com.campuslands.proyectospringboot.Empleado.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.campuslands.proyectospringboot.Empleado.domain.entities.Empleado;
import com.campuslands.proyectospringboot.Empleado.infrastructure.adapters.out.EmpleadoRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmpleadoService {
    private final EmpleadoRepository empleadoRepository;

    public List<Empleado> findAll(){
        return empleadoRepository.findAll();
    }

    public Optional<Empleado> findById(Long id) {
        return empleadoRepository.findById(id);
    }

    public Empleado save(Empleado empleado){
        return empleadoRepository.save(empleado);
    }

    public void deleteById(Long id) {
        empleadoRepository.deleteById(id);
    }


}
