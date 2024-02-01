package com.compubol.sicoem.services.mapper;

import com.compubol.sicoem.domain.dto.GarantiaDTO;
import com.compubol.sicoem.domain.entities.Garantia;
import com.compubol.sicoem.repositories.CategoriaRepository;
import com.compubol.sicoem.repositories.ClienteRepository;
import com.compubol.sicoem.repositories.GarantiaRepository;
import com.compubol.sicoem.repositories.MedidaRepository;
import org.springframework.stereotype.Component;

@Component
public class GarantiaMapper implements CustomMapper<GarantiaDTO, Garantia>{
    private final GarantiaRepository garantiaRepository;
    private final MedidaRepository medidaRepository;
    private final CategoriaRepository categoriaRepository;
    private final ClienteRepository clienteRepository;

    public GarantiaMapper(GarantiaRepository garantiaRepository, MedidaRepository medidaRepository, CategoriaRepository categoriaRepository, ClienteRepository clienteRepository) {
        this.garantiaRepository = garantiaRepository;
        this.medidaRepository = medidaRepository;
        this.categoriaRepository = categoriaRepository;
        this.clienteRepository = clienteRepository;
    }

    @Override
    public GarantiaDTO toDto(Garantia garantia) {
        GarantiaDTO garantiaDTO = new GarantiaDTO();
        garantiaDTO.setId(garantia.getId());
        garantiaDTO.setNombre(garantia.getNombre());
        garantiaDTO.setDescripcion(garantia.getDescripcion());
        garantiaDTO.setCantidad(garantia.getCantidad());
        garantiaDTO.setValor(garantia.getValor());
        garantiaDTO.setCondicion(garantia.getCondicion());
        garantiaDTO.setEstado(garantia.getEstado());
        garantiaDTO.setIdMedida(garantia.getMedida().getId());
        garantiaDTO.setIdCategoria(garantia.getCategoria().getId());
        garantiaDTO.setIdCliente(garantia.getCliente().getId());
        return garantiaDTO;
    }

    @Override
    public Garantia toEntity(GarantiaDTO garantiaDTO) {
        Garantia garantia = new Garantia();
        if (garantiaDTO.getId()!=null){
            garantia = garantiaRepository.findById(garantiaDTO.getId()).get();
            garantia.setEstado(garantiaDTO.getEstado());
        }
        garantia.setNombre(garantiaDTO.getNombre());
        garantia.setDescripcion(garantiaDTO.getDescripcion());
        garantia.setCantidad(garantiaDTO.getCantidad());
        garantia.setValor(garantiaDTO.getValor());
        garantia.setCondicion(garantiaDTO.getCondicion());
        garantia.setMedida(medidaRepository.findById(garantiaDTO.getIdMedida()).get());
        garantia.setCategoria(categoriaRepository.findById(garantiaDTO.getIdCategoria()).get());
        garantia.setCliente(clienteRepository.findById(garantiaDTO.getIdCliente()).get());
        return garantia;
    }
}
