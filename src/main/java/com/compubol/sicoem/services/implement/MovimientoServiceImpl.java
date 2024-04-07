package com.compubol.sicoem.services.implement;

import com.compubol.sicoem.domain.dto.MovimientoDTO;
import com.compubol.sicoem.repositories.EmpenoRepository;
import com.compubol.sicoem.repositories.MovimientoRepository;
import com.compubol.sicoem.services.MovimientoService;
import com.compubol.sicoem.services.mapper.MovimientoMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovimientoServiceImpl implements MovimientoService {
    private final MovimientoRepository movimientoRepository;
    private final MovimientoMapper movimientoMapper;
    private final EmpenoRepository empenoRepository;

    public MovimientoServiceImpl(MovimientoRepository movimientoRepository, MovimientoMapper movimientoMapper, EmpenoRepository empenoRepository) {
        this.movimientoRepository = movimientoRepository;
        this.movimientoMapper = movimientoMapper;
        this.empenoRepository = empenoRepository;
    }

    @Override
    public List<MovimientoDTO> listMovimientos() {
        return movimientoRepository.findAll()
                .stream()
                .map(movimientoMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<MovimientoDTO> listMovimientosByIdEmpeno(Long idEmpeno) {
        if(empenoRepository.existsById(idEmpeno)) {
            return empenoRepository.findById(idEmpeno).get().getMovimientos()
                    .stream()
                    .map(movimientoMapper::toDto).collect(Collectors.toList());
        }
        else{
            return null;
        }
    }

    @Override
    @Transactional
    public MovimientoDTO save(MovimientoDTO movimientoDTO) {
        return movimientoMapper.toDto(movimientoRepository.save(movimientoMapper.toEntity(movimientoDTO)));
    }

    @Override
    public Optional<MovimientoDTO> getMovimientoById(Long id) {
        return movimientoRepository.findById(id).map(movimientoMapper::toDto);
    }
}
