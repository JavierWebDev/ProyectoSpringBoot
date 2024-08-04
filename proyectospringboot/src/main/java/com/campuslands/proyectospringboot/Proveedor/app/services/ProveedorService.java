package com.campuslands.proyectospringboot.Proveedor.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.campuslands.proyectospringboot.Proveedor.domain.entities.Proveedor;
import com.campuslands.proyectospringboot.Proveedor.infrastructure.out.persistence.ProveedorRepository;

@Service
public class ProveedorService{

    public ProveedorService(ProveedorRepository proveedorRepository) {
        this.proveedorRepository = proveedorRepository;
    }

    private final ProveedorRepository proveedorRepository;

    public List<Proveedor> findAll(){
        return proveedorRepository.findAll();  
    } 
    
    public Optional<Proveedor> findById(Long id){
        return  proveedorRepository.findById(id);
    }

    public Proveedor save(Proveedor proveedor){
        return proveedorRepository.save(proveedor);
    }

    public void deleteById(Long id){
        proveedorRepository.deleteById(id);
    }

    
}
