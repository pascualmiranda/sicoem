package com.compubol.sicoem.services.implement;

import com.compubol.sicoem.domain.dto.EmpenoDTO;
import com.compubol.sicoem.repositories.ClienteRepository;
import com.compubol.sicoem.repositories.EmpenoRepository;
import com.compubol.sicoem.services.EmpenoService;
import com.compubol.sicoem.services.mapper.EmpenoMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmpenoServiceImpl implements EmpenoService {
    private final ClienteRepository clienteRepository;
    private final EmpenoMapper empenoMapper;
    private final EmpenoRepository empenoRepository;

    public EmpenoServiceImpl(ClienteRepository clienteRepository, EmpenoMapper empenoMapper, EmpenoRepository empenoRepository) {
        this.clienteRepository = clienteRepository;
        this.empenoMapper = empenoMapper;
        this.empenoRepository = empenoRepository;
    }

    @Override
    public List<EmpenoDTO> listEmpenosByIdCliente(Long idCliente) {
        return empenoRepository.findByIdCliente(idCliente)
                .stream()
                .map(empenoMapper::toDto).collect(Collectors.toList());
        /*if(clienteRepository.existsById(idCliente)) {
            return clienteRepository.findById(idCliente).get().getEmpenos()
                    .stream()
                    .map(empenoMapper::toDto).collect(Collectors.toList());
        }
        else{
            return null;
        }*/
    }

    @Override
    @Transactional
    public EmpenoDTO save(EmpenoDTO empenoDTO) {

        return empenoMapper.toDto(empenoRepository.save(empenoMapper.toEntity(empenoDTO)));
    }

    @Override
    public Optional<EmpenoDTO> getEmpenoById(Long id) {
        return empenoRepository.findById(id).map(empenoMapper::toDto);
    }
}
