package com.compubol.sicoem.services;

import com.compubol.sicoem.domain.dto.UsuarioDTO;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    List<UsuarioDTO> listUsuarios();
    UsuarioDTO save(UsuarioDTO usuarioDTO);
    Optional<UsuarioDTO> getUsuarioById(Long id);
}
