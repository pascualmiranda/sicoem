package com.compubol.sicoem.services.mapper;

import com.compubol.sicoem.domain.dto.MovimientoDTO;
import com.compubol.sicoem.domain.entities.Movimiento;
import com.compubol.sicoem.repositories.EmpenoRepository;
import com.compubol.sicoem.repositories.MovimientoRepository;
import com.compubol.sicoem.repositories.TipoMovimientoRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MovimientoMapper implements CustomMapper<MovimientoDTO, Movimiento>{
    private final MovimientoRepository movimientoRepository;
    private final TipoMovimientoRepository tipoMovimientoRepository;
    private final EmpenoRepository empenoRepository;
    public MovimientoMapper(MovimientoRepository movimientoRepository, TipoMovimientoRepository tipoMovimientoRepository, EmpenoRepository empenoRepository) {
        this.movimientoRepository = movimientoRepository;
        this.tipoMovimientoRepository = tipoMovimientoRepository;
        this.empenoRepository = empenoRepository;
    }

    @Override
    public MovimientoDTO toDto(Movimiento movimiento) {
        MovimientoDTO movimientoDTO=new MovimientoDTO();
        movimientoDTO.setId(movimiento.getId());
        movimientoDTO.setFecha(movimiento.getFecha());
        movimientoDTO.setCantidad(movimiento.getCantidad());
        movimientoDTO.setReferencia(movimiento.getReferencia());
        movimientoDTO.setConcepto(movimiento.getConcepto());
        movimientoDTO.setDescripcion(movimiento.getDescripcion());
        movimientoDTO.setTipo(movimiento.getTipo());
        movimientoDTO.setEstado(movimiento.getEstado());
        movimientoDTO.setIdTipoMov(movimiento.getTipoMovimiento().getId());
        if(movimiento.getEmpeno()!=null){
            movimientoDTO.setIdEmpeno(movimiento.getEmpeno().getId());
        }
        return movimientoDTO;
    }

    @Override
    public Movimiento toEntity(MovimientoDTO movimientoDTO) {
        Movimiento movimiento=new Movimiento();
        if(movimientoDTO.getId()!=null){ //Solo si es edición
            movimiento=movimientoRepository.findById(movimientoDTO.getId()).get();
            movimiento.setEstado(movimientoDTO.getEstado());
            movimiento.setFecha(LocalDateTime.now());
        }
        movimiento.setCantidad(movimientoDTO.getCantidad());
        movimiento.setReferencia(movimientoDTO.getReferencia());
        movimiento.setConcepto(movimientoDTO.getConcepto());
        movimiento.setDescripcion(movimientoDTO.getDescripcion());
        movimiento.setTipo(movimientoDTO.getTipo());
        movimiento.setTipoMovimiento(tipoMovimientoRepository.findById(movimientoDTO.getIdTipoMov()).get());
        if(movimientoDTO.getIdEmpeno()!=null){
            movimiento.setEmpeno(empenoRepository.findById(movimientoDTO.getIdEmpeno()).get());
        }
        return movimiento;
    }
}
