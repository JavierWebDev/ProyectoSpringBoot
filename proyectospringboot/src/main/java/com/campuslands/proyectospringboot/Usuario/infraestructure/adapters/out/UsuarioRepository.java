package com.campuslands.proyectospringboot.Usuario.infraestructure.adapters.out;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.campuslands.proyectospringboot.Usuario.domain.entities.Usuario;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    Optional<Usuario> findByUsername(String username);
}
