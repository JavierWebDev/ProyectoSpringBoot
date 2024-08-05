package com.campuslands.proyectospringboot.Usuario.app.services;

import com.campuslands.proyectospringboot.Usuario.domain.entities.Usuario;
import com.campuslands.proyectospringboot.Usuario.infraestructure.adapters.out.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + username));

        return new org.springframework.security.core.userdetails.User(
                usuario.getUsername(),
                usuario.getPassword(),
                new ArrayList<>()
        );
    }

    public Usuario buscarPorUsername(String username) {
        Optional<Usuario> usuario = usuarioRepository.findByUsername(username);
        return usuario.orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + username));
    }

    public Usuario registrarUsuario(Usuario usuario) {
        if (usuarioRepository.findByUsername(usuario.getUsername()).isPresent()) {
            throw new IllegalArgumentException("El nombre de usuario ya está en uso: " + usuario.getUsername());
        }
        return usuarioRepository.save(usuario);
    }
}
