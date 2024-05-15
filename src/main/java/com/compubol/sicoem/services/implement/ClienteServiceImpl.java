package com.compubol.sicoem.services.implement;

import com.compubol.sicoem.domain.dto.ClienteDTO;
import com.compubol.sicoem.domain.entities.Cliente;
import com.compubol.sicoem.domain.entities.Persona;
import com.compubol.sicoem.repositories.ClienteRepository;
import com.compubol.sicoem.repositories.MunicipioRepository;
import com.compubol.sicoem.repositories.PersonaRepository;
import com.compubol.sicoem.services.ClienteService;
import com.compubol.sicoem.services.mapper.ClienteMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteServiceImpl implements ClienteService {
    private final ClienteMapper clienteMapper;
    private final ClienteRepository clienteRepository;
    private final PersonaRepository personaRepository;
    private  final MunicipioRepository municipioRepository;
    public ClienteServiceImpl(ClienteMapper clienteMapper, ClienteRepository clienteRepository, PersonaRepository personaRepository, MunicipioRepository municipioRepository) {
        this.clienteMapper = clienteMapper;
        this.clienteRepository = clienteRepository;
        this.personaRepository = personaRepository;
        this.municipioRepository = municipioRepository;
    }

    @Override
    public List<ClienteDTO> listClientes() {
        return clienteRepository.findAll()
                .stream()
                .map(clienteMapper::toDto).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public ClienteDTO save(ClienteDTO clienteDTO) {
        Cliente cliente=new Cliente();
        Persona persona=new Persona();
        if (clienteDTO.getId()!=null && clienteRepository.existsById(clienteDTO.getId())){ //Edit
            cliente=clienteRepository.findById(clienteDTO.getId()).get();
            persona=cliente.getPersona();
            //persona=personaRepository.findById(clienteDTO.getIdPersona()).get();
            persona.setCi(clienteDTO.getCi());
            persona.setNombre(clienteDTO.getNombre());
            persona.setPrimerApellido(clienteDTO.getPrimerApellido());
            if (clienteDTO.getSegundoApellido()!=null){
                persona.setSegundoApellido(clienteDTO.getSegundoApellido());
            }
            persona.setGenero(clienteDTO.getGenero());
            persona.setDireccion(clienteDTO.getDireccion());
            persona.setTelefono(clienteDTO.getTelefono());
            persona.setEmail(clienteDTO.getEmail());
            personaRepository.save(persona);
            //cliente=persona.getCliente();
            //cliente.setId(clienteDTO.getId());
            if(clienteDTO.getFoto()!=null){
                cliente.setFoto(clienteDTO.getFoto());
            }
            if(clienteDTO.getObservaciones()!=null){
                cliente.setObservaciones(clienteDTO.getObservaciones());
            }
            if(clienteDTO.getEstado()!=null){
                cliente.setEstado(clienteDTO.getEstado());
            }
            cliente.setMunicipio(municipioRepository.findById(clienteDTO.getIdMunicipio()).get());
            cliente.setPersona(persona);
            clienteRepository.save(cliente);
        }
        else{//Nuevo
            if(clienteDTO.getIdPersona()!=null && clienteRepository.existsById(clienteDTO.getIdPersona())){// En caso que ya exista la persona
                persona=personaRepository.findById(clienteDTO.getIdPersona()).get();
            }
            persona.setCi(clienteDTO.getCi());
            persona.setNombre(clienteDTO.getNombre());
            persona.setPrimerApellido(clienteDTO.getPrimerApellido());
            persona.setSegundoApellido(clienteDTO.getSegundoApellido());
            persona.setGenero(clienteDTO.getGenero());
            persona.setDireccion(clienteDTO.getDireccion());
            persona.setTelefono(clienteDTO.getTelefono());
            persona.setEmail(clienteDTO.getEmail());
            personaRepository.save(persona);
            //cliente=persona.getCliente();
            if (clienteDTO.getFoto()!=null){
                cliente.setFoto(clienteDTO.getFoto());
            }
            if (clienteDTO.getObservaciones()!=null){
                cliente.setObservaciones(clienteDTO.getObservaciones());
            }
            if (clienteDTO.getEstado()!=null){
                cliente.setEstado(clienteDTO.getEstado());
            }
            cliente.setMunicipio(municipioRepository.findById(clienteDTO.getIdMunicipio()).get());
            cliente.setPersona(persona);
            clienteRepository.save(cliente);
        }
        return clienteMapper.toDto(cliente);
    }

    @Override
    public Optional<ClienteDTO> getClienteById(Long id) {
        return clienteRepository.findById(id).map(clienteMapper::toDto);
    }
}
