package com.compubol.sicoem.web.rest;

import com.compubol.sicoem.domain.dto.UsuarioDTO;
import com.compubol.sicoem.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("v1/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> listUsuarios(){
            return ResponseEntity.ok().body(usuarioService.listUsuarios());
    }
    @PostMapping
    public ResponseEntity<UsuarioDTO> create(@Valid @RequestBody final UsuarioDTO usuarioDTO) throws URISyntaxException {
        UsuarioDTO usuarioDB=usuarioService.save(usuarioDTO);
        return ResponseEntity.created(new URI("v1/usuarios"+usuarioDB.getId())).body(usuarioDB);
    }
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> getUsuarioById(@PathVariable final Long id){
        return ResponseEntity
                .ok()
                .body(usuarioService.getUsuarioById(id).orElseThrow(() -> new IllegalArgumentException("Excepción. recurso no encontrado para id: " + id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> editUsuario(@Valid @RequestBody final UsuarioDTO usuarioDTO) throws URISyntaxException {
        if(usuarioDTO.getId()==null){
            throw new IllegalArgumentException("Para esta operación se requiere un id.");
        }
        UsuarioDTO usuarioDB=usuarioService.save(usuarioDTO);
        return ResponseEntity.created(new URI("v1/usuarios"+usuarioDB.getId())).body(usuarioDB);
    }
}
