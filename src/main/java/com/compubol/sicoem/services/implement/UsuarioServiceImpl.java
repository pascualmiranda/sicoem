package com.compubol.sicoem.services.implement;

import com.compubol.sicoem.domain.dto.UsuarioDTO;
import com.compubol.sicoem.domain.entities.Persona;
import com.compubol.sicoem.domain.entities.Usuario;
import com.compubol.sicoem.repositories.PersonaRepository;
import com.compubol.sicoem.repositories.UsuarioRepository;
import com.compubol.sicoem.services.UsuarioService;
import com.compubol.sicoem.services.mapper.UsuarioMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class UsuarioServiceImpl implements UsuarioService {
    private final PersonaRepository personaRepository;
    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    public UsuarioServiceImpl(PersonaRepository personaRepository, UsuarioRepository usuarioRepository, UsuarioMapper usuarioMapper) {
        this.personaRepository = personaRepository;
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
    }

    @Override
    @Transactional
    public UsuarioDTO save(UsuarioDTO usuarioDTO) {
        Usuario usuario=new Usuario();
        Persona persona=new Persona();
        if (usuarioDTO.getId()!=null && usuarioRepository.existsById(usuarioDTO.getId())){ //Edit
            persona=personaRepository.findById(usuarioDTO.getIdpersona()).get();
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
            usuario.setId(persona.getUsuario().getId());
            usuario.setLogin(usuarioDTO.getLogin());
            String pwd=usuario.getClave();
            if (usuarioDTO.getClave()!=null && !usuarioDTO.getClave().isBlank()) {
                pwd=usuarioDTO.getClave();
            }
            usuario.setClave(pwd);
            usuario.setEstado(usuarioDTO.isEstado());
            usuario.setPersona(persona);
            usuarioRepository.save(usuario);
        }
        else{//Nuevo
            if(usuarioDTO.getIdpersona()!=null && personaRepository.existsById(usuarioDTO.getIdpersona())){// En caso que ya exista la persona
                persona=personaRepository.findById(usuarioDTO.getIdpersona()).get();
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
            usuarioRepository.save(usuario);
        }
        return usuarioMapper.toDto(usuario);
    }
}
