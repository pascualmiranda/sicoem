package com.compubol.sicoem.services;

import com.compubol.sicoem.domain.dto.ClienteDTO;

import java.util.List;
import java.util.Optional;

public interface ClienteService {
    List<ClienteDTO> listClientes();
    ClienteDTO save(ClienteDTO clienteDTO);
    Optional<ClienteDTO> getClienteById(Long id);
}
