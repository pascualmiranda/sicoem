package com.compubol.sicoem.services.mapper;

import com.compubol.sicoem.domain.dto.UsuarioDTO;
import com.compubol.sicoem.domain.entities.Persona;
import com.compubol.sicoem.domain.entities.Usuario;

public class UsuarioMapper implements CustomMapper<UsuarioDTO, Usuario>{
    @Override
    public UsuarioDTO toDto(Usuario usuario) {
        UsuarioDTO usuarioDTO= new UsuarioDTO();
        usuarioDTO.setId(usuario.getId());
        usuarioDTO.setLogin(usuario.getLogin());
        usuarioDTO.setClave("*******");
        usuarioDTO.setEstado(usuario.isEstado());
        usuarioDTO.setIdpersona(usuario.getPersona().getId());
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
        usuario.setId(usuarioDTO.getId());
        usuario.setLogin(usuarioDTO.getLogin());
        usuario.setClave(usuarioDTO.getClave());
        usuario.setEstado(usuarioDTO.isEstado());
        Persona persona=new Persona();
        //persona.setId(usuarioDTO.getIdpersona());
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
