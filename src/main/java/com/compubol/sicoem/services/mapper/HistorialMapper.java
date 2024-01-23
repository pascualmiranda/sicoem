package com.compubol.sicoem.services.mapper;

import com.compubol.sicoem.domain.dto.HistorialDTO;
import com.compubol.sicoem.domain.entities.Historial;
import com.compubol.sicoem.repositories.ClienteRepository;
import com.compubol.sicoem.repositories.HistorialRepository;
import org.springframework.stereotype.Component;

@Component
public class HistorialMapper implements CustomMapper<HistorialDTO, Historial>{
    private final HistorialRepository historialRepository;
    private  final ClienteRepository clienteRepository;

    public HistorialMapper(HistorialRepository historialRepository, ClienteRepository clienteRepository) {
        this.historialRepository = historialRepository;
        this.clienteRepository = clienteRepository;
    }

    @Override
    public HistorialDTO toDto(Historial historial) {
        HistorialDTO historialDTO = new HistorialDTO();
        historialDTO.setId(historial.getId());
        historialDTO.setNombre(historial.getNombre());
        historialDTO.setDescripcion(historial.getDescripcion());
        historialDTO.setEstado(historial.getEstado());
        historialDTO.setIdCliente(historial.getCliente().getId());
        return historialDTO;
    }

    @Override
    public Historial toEntity(HistorialDTO historialDTO) {
        Historial historial = new Historial();
        if(historialDTO.getId()!=null){
            historial= historialRepository.findById(historialDTO.getId()).get();
        }
        historial.setNombre(historialDTO.getNombre());
        historial.setDescripcion(historialDTO.getDescripcion());
        historial.setEstado(historialDTO.getEstado());
        historial.setCliente(clienteRepository.findById(historialDTO.getIdCliente()).get());
        return historial;
    }
}
