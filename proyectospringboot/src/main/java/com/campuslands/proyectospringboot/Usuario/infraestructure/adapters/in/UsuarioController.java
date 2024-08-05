package com.campuslands.proyectospringboot.Usuario.infraestructure.adapters.in;

import com.campuslands.proyectospringboot.Usuario.app.services.UsuarioService;
import com.campuslands.proyectospringboot.Usuario.domain.entities.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping("/registro")
    public ResponseEntity<Usuario> registrarUsuario(@RequestBody Usuario usuario) {
        Usuario nuevoUsuario = usuarioService.registrarUsuario(usuario);
        return ResponseEntity.ok(nuevoUsuario);
    }

    @GetMapping("/{username}")
    public ResponseEntity<Usuario> obtenerUsuario(@PathVariable String username) {
        Usuario usuario = usuarioService.buscarPorUsername(username);
        return ResponseEntity.ok(usuario);
    }
}   