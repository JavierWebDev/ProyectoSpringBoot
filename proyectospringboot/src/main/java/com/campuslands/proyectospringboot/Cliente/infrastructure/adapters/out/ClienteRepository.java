package com.campuslands.proyectospringboot.Cliente.infrastructure.adapters.out;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.campuslands.proyectospringboot.Cliente.domain.entities.Cliente;
import com.campuslands.proyectospringboot.Cliente.domain.entities.ClienteCiudadDTO;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query("select new com.campuslands.proyectospringboot.Cliente.domain.entities.ClienteCiudadDTO(c.id, c.nombre, c.apellido1, ci.nombreCiudad)" +
            "from Cliente c " +
            "join c.ciudad ci " +
            "where ci.nombreCiudad=?1")
    List<ClienteCiudadDTO> clientePorCiudad(String nombreCiudad);
}
