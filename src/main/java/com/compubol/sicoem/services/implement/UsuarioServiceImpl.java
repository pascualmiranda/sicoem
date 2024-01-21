package com.compubol.sicoem.services.implement;

import com.compubol.sicoem.domain.dto.UsuarioDTO;
import com.compubol.sicoem.domain.entities.Persona;
import com.compubol.sicoem.domain.entities.Usuario;
import com.compubol.sicoem.repositories.PersonaRepository;
import com.compubol.sicoem.repositories.RolRepository;
import com.compubol.sicoem.repositories.UsuarioRepository;
import com.compubol.sicoem.services.UsuarioService;
import com.compubol.sicoem.services.mapper.UsuarioMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioMapper usuarioMapper;
    private final UsuarioRepository usuarioRepository;
     private final PersonaRepository personaRepository;
     private final RolRepository rolRepository;
    public UsuarioServiceImpl(UsuarioMapper usuarioMapper, UsuarioRepository usuarioRepository, PersonaRepository personaRepository, RolRepository rolRepository) {
        this.usuarioMapper = usuarioMapper;
        this.usuarioRepository = usuarioRepository;
        this.personaRepository = personaRepository;
        this.rolRepository = rolRepository;
    }

    @Override
    public List<UsuarioDTO> listUsuarios() {
        return usuarioRepository.findAll()
                .stream()
                .map(usuarioMapper::toDto).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public UsuarioDTO save(UsuarioDTO usuarioDTO) {
        Usuario usuario=new Usuario();
        Persona persona=new Persona();
        if (usuarioDTO.getId()!=null && usuarioRepository.existsById(usuarioDTO.getId())){ //Edit
            persona=personaRepository.findById(usuarioDTO.getIdPersona()).get();
            persona.setCi(usuarioDTO.getCi());
            persona.setNombre(usuarioDTO.getNombre());
            persona.setPrimerApellido(usuarioDTO.getPrimerApellido());
            persona.setSegundoApellido(usuarioDTO.getSegundoApellido());
            persona.setGenero(usuarioDTO.getGenero());
            persona.setDireccion(usuarioDTO.getDireccion());
            persona.setTelefono(usuarioDTO.getTelefono());
            persona.setEmail(usuarioDTO.getEmail());
            personaRepository.save(persona);
            usuario=persona.getUsuario();
            usuario.setId(usuarioDTO.getId());
            usuario.setLogin(usuarioDTO.getLogin());
            String pwd=usuario.getClave();
            if (usuarioDTO.getClave()!=null && !usuarioDTO.getClave().isBlank()) {
                pwd=usuarioDTO.getClave();
            }
            usuario.setClave(pwd);
            usuario.setEstado(usuarioDTO.isEstado());
            usuario.setPersona(persona);
            usuario.setRol(rolRepository.findById(usuarioDTO.getIdRol()).get());
            usuarioRepository.save(usuario);
        }
        else{//Nuevo
            if(usuarioDTO.getIdPersona()!=null && personaRepository.existsById(usuarioDTO.getIdPersona())){// En caso que ya exista la persona
                persona=personaRepository.findById(usuarioDTO.getIdPersona()).get();
            }
            persona.setCi(usuarioDTO.getCi());
            persona.setNombre(usuarioDTO.getNombre());
            persona.setPrimerApellido(usuarioDTO.getPrimerApellido());
            persona.setSegundoApellido(usuarioDTO.getSegundoApellido());
            persona.setGenero(usuarioDTO.getGenero());
            persona.setDireccion(usuarioDTO.getDireccion());
            persona.setTelefono(usuarioDTO.getTelefono());
            persona.setEmail(usuarioDTO.getEmail());
            personaRepository.save(persona);
            usuario=persona.getUsuario();
            usuario.setLogin(usuarioDTO.getLogin());
            usuario.setClave(usuarioDTO.getClave());
            usuario.setEstado(usuarioDTO.isEstado());
            usuario.setPersona(persona);
            usuario.setRol(rolRepository.findById(usuarioDTO.getIdRol()).get());
            usuarioRepository.save(usuario);
        }
        return usuarioMapper.toDto(usuario);
    }

    @Override
    public Optional<UsuarioDTO> getUsuarioById(Long id) {
        return usuarioRepository.findById(id).map(usuarioMapper::toDto);
    }
}
