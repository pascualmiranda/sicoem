package com.compubol.sicoem.repositories;

import com.compubol.sicoem.domain.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    //Optional<Usuario> findByUsername(String username);
}
