package com.compubol.sicoem.services.implement;

import com.compubol.sicoem.domain.dto.GarantiaDTO;
import com.compubol.sicoem.repositories.ClienteRepository;
import com.compubol.sicoem.repositories.GarantiaRepository;
import com.compubol.sicoem.services.GarantiaService;
import com.compubol.sicoem.services.mapper.GarantiaMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GarantiaServiceImpl implements GarantiaService {
    private final ClienteRepository clienteRepository;
    private final GarantiaMapper garantiaMapper;
    private final GarantiaRepository garantiaRepository;

    public GarantiaServiceImpl(ClienteRepository clienteRepository, GarantiaMapper garantiaMapper, GarantiaRepository garantiaRepository) {
        this.clienteRepository = clienteRepository;
        this.garantiaMapper = garantiaMapper;
        this.garantiaRepository = garantiaRepository;
    }

    @Override
    public List<GarantiaDTO> listGarantiasByIdCliente(Long idCliente) {
        if(clienteRepository.existsById(idCliente)) {
            return clienteRepository.findById(idCliente).get().getGarantias()
                    .stream()
                    .map(garantiaMapper::toDto).collect(Collectors.toList());
        }
        else{
            return null;
        }
    }

    @Override
    @Transactional
    public GarantiaDTO save(GarantiaDTO garantiaDTO) {
        return garantiaMapper.toDto(garantiaRepository.save(garantiaMapper.toEntity(garantiaDTO)));
    }

    @Override
    public Optional<GarantiaDTO> getGarantiaById(Long id) {
        return garantiaRepository.findById(id).map(garantiaMapper::toDto);
    }
}
