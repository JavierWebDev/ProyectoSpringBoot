package com.campuslands.proyectospringboot.Autenticacion.app.services;

import com.campuslands.proyectospringboot.Autenticacion.domain.entities.LoginRequest;
import com.campuslands.proyectospringboot.Autenticacion.domain.entities.LoginResponse;
import com.campuslands.proyectospringboot.Autenticacion.infraestructure.adapters.security.JwtUtil;
import com.campuslands.proyectospringboot.Usuario.domain.entities.Usuario;
import com.campuslands.proyectospringboot.Usuario.infraestructure.adapters.out.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
// import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // @Autowired
    // private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil; 
    public LoginResponse autenticarUsuario(LoginRequest loginRequest) {
        try {
            // 1. Autenticar al usuario usando Spring Security
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
            );

            // 2. Buscar al usuario
            Usuario usuario = usuarioRepository.findByUsername(loginRequest.getUsername())
                    .orElseThrow(() -> new RuntimeException("Error al buscar usuario")); // Puedes lanzar una excepción más específica

            // 3. Generar token JWT
            String token = null;
            if (jwtUtil != null) { // Verifica si estás usando JWT
                token = jwtUtil.generateToken(usuario.getUsername());
            }

            // 4. Construir y devolver la respuesta
            return new LoginResponse(token, "Inicio de sesión exitoso");
        } catch (AuthenticationException e) {
            return new LoginResponse(null, "Credenciales incorrectas");
        } catch (Exception e) {
            return new LoginResponse(null, "Error en el inicio de sesión");
        }
    }
}
