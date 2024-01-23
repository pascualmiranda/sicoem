package com.compubol.sicoem.services;

import com.compubol.sicoem.domain.dto.HistorialDTO;

import java.util.List;
import java.util.Optional;

public interface HistorialService {
    List<HistorialDTO> listHistorialesByIdCliente(Long idCliente);
    HistorialDTO save(HistorialDTO historialDTO);
    Optional<HistorialDTO> getHistorialById(Long id);
}
