package com.campuslands.proyectospringboot.GamaProducto.application.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.campuslands.proyectospringboot.GamaProducto.domain.entities.GamaProducto;
import com.campuslands.proyectospringboot.GamaProducto.infrastructure.out.persistence.GamaProductoRepository;

@Component
public class GamaProductoImpl implements GamaProductoService{

    @Autowired
    private GamaProductoRepository repository;

    @Transactional
    @Override
    public List<GamaProducto> findAll() {
        return (List<GamaProducto>) repository.findAll();
    }

    @Transactional
    @Override
    public Optional<GamaProducto> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public GamaProducto save(GamaProducto gamaProducto) {
        return repository.save(gamaProducto);
    }

    @Transactional
    @Override
    public Optional<GamaProducto> delete(Long id) {
        Optional<GamaProducto> gamaProductoOpt = repository.findById(id);
        gamaProductoOpt.ifPresent(gpI -> {
            repository.delete(gpI);
        });
        return gamaProductoOpt;
    }

    @Override
    public Optional<GamaProducto> update(Long id, GamaProducto gamaProducto) {
        Optional<GamaProducto> gamaProductoOpt = repository.findById(id);
        if (gamaProductoOpt.isPresent()) {
            GamaProducto gamaProductoItem = gamaProductoOpt.orElseThrow();
            gamaProductoItem.setDescripcion(gamaProducto.getDescripcion());
            gamaProductoItem.setDescripcionHtml(gamaProducto.getDescripcionHtml());
            gamaProductoItem.setImagen(gamaProducto.getImagen());
            return Optional.of(repository.save(gamaProductoItem));
        }
        return gamaProductoOpt;
    }
}
