package com.compubol.sicoem.services;

import com.compubol.sicoem.domain.dto.MovimientoDTO;

import java.util.List;
import java.util.Optional;

public interface MovimientoService {
    List<MovimientoDTO> listMovimientos();
    List<MovimientoDTO> listMovimientosByIdEmpeno(Long idEmpeno);
    MovimientoDTO save(MovimientoDTO movimientoDTO);
    Optional<MovimientoDTO> getMovimientoById(Long id);
}
