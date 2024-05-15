package com.compubol.sicoem.services.mapper;

import com.compubol.sicoem.domain.dto.EmpenoDTO;
import com.compubol.sicoem.domain.entities.Capital;
import com.compubol.sicoem.domain.entities.Empeno;
import com.compubol.sicoem.domain.entities.Movimiento;
import com.compubol.sicoem.repositories.*;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class EmpenoMapper implements CustomMapper<EmpenoDTO, Empeno>{
    private final EmpenoRepository empenoRepository;
    private final CapitalRepository capitalRepository;
    private final ClienteRepository clienteRepository;
    private final MovimientoRepository movimientoRepository;
    private final TipoMovimientoRepository tipoMovimientoRepository;
    public EmpenoMapper(EmpenoRepository empenoRepository, CapitalRepository capitalRepository, ClienteRepository clienteRepository, MovimientoRepository movimientoRepository, TipoMovimientoRepository tipoMovimientoRepository) {
        this.empenoRepository = empenoRepository;
        this.capitalRepository = capitalRepository;
        this.clienteRepository = clienteRepository;
        this.movimientoRepository = movimientoRepository;
        this.tipoMovimientoRepository = tipoMovimientoRepository;
    }

    @Override
    public EmpenoDTO toDto(Empeno empeno) {
        EmpenoDTO empenoDTO = new EmpenoDTO();
        empenoDTO.setId(empeno.getId());
        empenoDTO.setMonto(empeno.getMonto());
        empenoDTO.setObservacion(empeno.getObservacion());
        empenoDTO.setEstado(empeno.getEstado());
        empenoDTO.setFechaPlazo(empeno.getFechaPlazo());
        empenoDTO.setIdCapital(empeno.getCapital().getId());
        empenoDTO.setIdCliente(empeno.getCliente().getId());
        return empenoDTO;
    }

    @Override
    public Empeno toEntity(EmpenoDTO empenoDTO) {
        Empeno empeno = new Empeno();
        Movimiento movimiento = new Movimiento();
        Set<Movimiento> movimientoSet=new HashSet<>();
        if(empenoDTO.getId()!=null){
            empeno = empenoRepository.findById(empenoDTO.getId()).get();
            empeno.setEstado(empenoDTO.getEstado());
            movimiento=movimientoRepository.buscarMovimientoEgresoActivo(empenoDTO.getId()).get();
            movimiento.setEstado(false);
        }
        empeno.setMonto(empenoDTO.getMonto());
        empeno.setObservacion(empenoDTO.getObservacion());
        empeno.setFechaPlazo(empenoDTO.getFechaPlazo());
        empeno.setCapital(capitalRepository.buscarDentroDesdeHasta(empenoDTO.getMonto()).get());
        empeno.setCliente(clienteRepository.findById(empenoDTO.getIdCliente()).get());
        movimiento = new Movimiento();
        movimiento.setCantidad(empenoDTO.getMonto());
        movimiento.setConcepto("Salida por préstamo");
        movimiento.setTipo("Egreso");
        movimiento.setTipoMovimiento(tipoMovimientoRepository.findById(1).get());
        movimiento.setEmpeno(empeno);
        movimientoSet.add(movimiento);
        empeno.setMovimientos(movimientoSet);
        return empeno;
    }
}
