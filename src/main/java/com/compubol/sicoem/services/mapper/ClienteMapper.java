package com.compubol.sicoem.services.mapper;

import com.compubol.sicoem.domain.dto.ClienteDTO;
import com.compubol.sicoem.domain.entities.Cliente;
import com.compubol.sicoem.domain.entities.Persona;
import com.compubol.sicoem.repositories.MunicipioRepository;
import com.compubol.sicoem.repositories.PersonaRepository;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper implements CustomMapper<ClienteDTO, Cliente>{
    private final MunicipioRepository municipioRepository;

    public ClienteMapper(MunicipioRepository municipioRepository) {
        this.municipioRepository = municipioRepository;
    }

    @Override
    public ClienteDTO toDto(Cliente cliente) {
        ClienteDTO clienteDTO= new ClienteDTO();
        clienteDTO.setId(cliente.getId());
        clienteDTO.setFoto(cliente.getFoto());
        clienteDTO.setObservaciones(cliente.getObservaciones());
        clienteDTO.setEstado(cliente.getEstado());
        clienteDTO.setIdMunicipio(cliente.getMunicipio().getId());
        clienteDTO.setIdPersona(cliente.getPersona().getId());
        clienteDTO.setCi(cliente.getPersona().getCi());
        clienteDTO.setNombre(cliente.getPersona().getNombre());
        clienteDTO.setPrimerApellido(cliente.getPersona().getPrimerApellido());
        clienteDTO.setSegundoApellido(cliente.getPersona().getSegundoApellido());
        clienteDTO.setGenero(cliente.getPersona().getGenero());
        clienteDTO.setDireccion(cliente.getPersona().getDireccion());
        clienteDTO.setTelefono(cliente.getPersona().getTelefono());
        clienteDTO.setEmail(cliente.getPersona().getEmail());
        return clienteDTO;
    }

    @Override
    public Cliente toEntity(ClienteDTO clienteDTO) {
        Cliente cliente= new Cliente();
        cliente.setId(clienteDTO.getId());
        cliente.setFoto(clienteDTO.getFoto());
        cliente.setObservaciones(clienteDTO.getObservaciones());
        cliente.setEstado(clienteDTO.getEstado());
        cliente.setMunicipio(municipioRepository.findById(clienteDTO.getIdMunicipio()).get());
        Persona persona=cliente.getPersona();
        if (clienteDTO.getIdPersona()!=null){
            persona.setId(clienteDTO.getIdPersona());
        }
        persona.setCi(clienteDTO.getCi());
        persona.setNombre(clienteDTO.getNombre());
        persona.setPrimerApellido(clienteDTO.getPrimerApellido());
        persona.setSegundoApellido(clienteDTO.getSegundoApellido());
        persona.setGenero(clienteDTO.getGenero());
        persona.setDireccion(clienteDTO.getDireccion());
        persona.setTelefono(clienteDTO.getTelefono());
        persona.setEmail(clienteDTO.getEmail());
        cliente.setPersona(persona);
        return cliente;
    }
}
