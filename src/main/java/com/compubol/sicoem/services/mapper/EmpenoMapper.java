package com.compubol.sicoem.services.mapper;

import com.compubol.sicoem.domain.dto.EmpenoDTO;
import com.compubol.sicoem.domain.entities.Empeno;
import com.compubol.sicoem.repositories.CapitalRepository;
import com.compubol.sicoem.repositories.ClienteRepository;
import com.compubol.sicoem.repositories.EmpenoRepository;
import org.springframework.stereotype.Component;

@Component
public class EmpenoMapper implements CustomMapper<EmpenoDTO, Empeno>{
    private final EmpenoRepository empenoRepository;
    private final CapitalRepository capitalRepository;
    private final ClienteRepository clienteRepository;
    public EmpenoMapper(EmpenoRepository empenoRepository, CapitalRepository capitalRepository, ClienteRepository clienteRepository) {
        this.empenoRepository = empenoRepository;
        this.capitalRepository = capitalRepository;
        this.clienteRepository = clienteRepository;
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
        if(empenoDTO.getId()!=null){
            empeno = empenoRepository.findById(empenoDTO.getId()).get();
            empeno.setEstado(empenoDTO.getEstado());
        }
        empeno.setMonto(empenoDTO.getMonto());
        empeno.setObservacion(empenoDTO.getObservacion());
        empeno.setFechaPlazo(empenoDTO.getFechaPlazo());
        empeno.setCapital(capitalRepository.findById(empenoDTO.getIdCapital()).get());
        empeno.setCliente(clienteRepository.findById(empenoDTO.getIdCliente()).get());
        return empeno;
    }
}
