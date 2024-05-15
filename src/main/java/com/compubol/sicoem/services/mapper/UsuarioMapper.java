package com.compubol.sicoem.services.mapper;

import com.compubol.sicoem.domain.dto.UsuarioDTO;
import com.compubol.sicoem.domain.entities.Persona;
import com.compubol.sicoem.domain.entities.Role;
import com.compubol.sicoem.domain.entities.Usuario;
import com.compubol.sicoem.repositories.RolRepository;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper implements CustomMapper<UsuarioDTO, Usuario>{
    private final RolRepository rolRepository;

    public UsuarioMapper(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    @Override
    public UsuarioDTO toDto(Usuario usuario) {
        UsuarioDTO usuarioDTO= new UsuarioDTO();
        usuarioDTO.setId(usuario.getId());
        usuarioDTO.setLogin(usuario.getLogin());
        usuarioDTO.setClave("*******");
        usuarioDTO.setEstado(usuario.isEstado());
        usuarioDTO.setIdRol(usuario.getRole().getId());
        usuarioDTO.setIdPersona(usuario.getPersona().getId());
        usuarioDTO.setCi(usuario.getPersona().getCi());
        usuarioDTO.setNombre(usuario.getPersona().getNombre());
        usuarioDTO.setPrimerApellido(usuario.getPersona().getPrimerApellido());
        usuarioDTO.setSegundoApellido(usuario.getPersona().getSegundoApellido());
        usuarioDTO.setGenero(usuario.getPersona().getGenero());
        usuarioDTO.setDireccion(usuario.getPersona().getDireccion());
        usuarioDTO.setTelefono(usuario.getPersona().getTelefono());
        usuarioDTO.setEmail(usuario.getPersona().getEmail());
        return usuarioDTO;
    }

    @Override
    public Usuario toEntity(UsuarioDTO usuarioDTO) { //Solo para nuevo
        Usuario usuario= new Usuario();
        Role role = new Role();
        usuario.setId(usuarioDTO.getId());
        usuario.setLogin(usuarioDTO.getLogin());
        usuario.setClave(usuarioDTO.getClave());
        usuario.setEstado(usuarioDTO.isEstado());
        role = rolRepository.findById(usuarioDTO.getIdRol()).get();
        usuario.setRole(role);
        Persona persona=usuario.getPersona();
        if (usuarioDTO.getIdPersona()!=null){
            persona.setId(usuarioDTO.getIdPersona());
        }
        persona.setCi(usuarioDTO.getCi());
        persona.setNombre(usuarioDTO.getNombre());
        persona.setPrimerApellido(usuarioDTO.getPrimerApellido());
        persona.setSegundoApellido(usuarioDTO.getSegundoApellido());
        persona.setGenero(usuarioDTO.getGenero());
        persona.setDireccion(usuarioDTO.getDireccion());
        persona.setTelefono(usuarioDTO.getTelefono());
        persona.setEmail(usuarioDTO.getEmail());
        usuario.setPersona(persona);
        return usuario;
    }
}
