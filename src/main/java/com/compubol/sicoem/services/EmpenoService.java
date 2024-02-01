package com.compubol.sicoem.services;

import com.compubol.sicoem.domain.dto.EmpenoDTO;

import java.util.List;
import java.util.Optional;

public interface EmpenoService {
    List<EmpenoDTO> listEmpenosByIdCliente(Long idCliente);
    EmpenoDTO save(EmpenoDTO empenoDTO);
    Optional<EmpenoDTO> getEmpenoById(Long id);
}
