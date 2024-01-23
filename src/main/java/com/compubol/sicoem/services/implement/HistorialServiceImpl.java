package com.compubol.sicoem.services.implement;

import com.compubol.sicoem.domain.dto.HistorialDTO;
import com.compubol.sicoem.repositories.ClienteRepository;
import com.compubol.sicoem.repositories.HistorialRepository;
import com.compubol.sicoem.services.HistorialService;
import com.compubol.sicoem.services.mapper.HistorialMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HistorialServiceImpl implements HistorialService {
    private final HistorialMapper historialMapper;
    private final HistorialRepository historialRepository;
    private final ClienteRepository clienteRepository;

    public HistorialServiceImpl(HistorialMapper historialMapper, HistorialRepository historialRepository, ClienteRepository clienteRepository) {
        this.historialMapper = historialMapper;
        this.historialRepository = historialRepository;
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<HistorialDTO> listHistorialesByIdCliente(Long idCliente) {
        if(clienteRepository.existsById(idCliente)) {
            return clienteRepository.findById(idCliente).get().getHistoriales()
                    .stream()
                    .map(historialMapper::toDto).collect(Collectors.toList());
        }
        else{
            return null;
        }

    }

    @Override
    public HistorialDTO save(HistorialDTO historialDTO) {

        return historialMapper.toDto(historialRepository.save(historialMapper.toEntity(historialDTO)));
    }

    @Override
    public Optional<HistorialDTO> getHistorialById(Long id) {
        return historialRepository.findById(id).map(historialMapper::toDto);
    }
}
