package com.compubol.sicoem.services;

import com.compubol.sicoem.domain.dto.GarantiaDTO;

import java.util.List;
import java.util.Optional;

public interface GarantiaService {
    List<GarantiaDTO> listGarantiasByIdCliente(Long idCliente);
    GarantiaDTO save(GarantiaDTO garantiaDTO);
    Optional<GarantiaDTO> getGarantiaById(Long id);
}
