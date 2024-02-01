package com.compubol.sicoem.web.rest;

import com.compubol.sicoem.domain.dto.HistorialDTO;
import com.compubol.sicoem.domain.dto.UsuarioDTO;
import com.compubol.sicoem.services.HistorialService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
@RestController
@RequestMapping("v1/historiales")
public class HistorialController {
    private final HistorialService historialService;

    public HistorialController(HistorialService historialService) {
        this.historialService = historialService;
    }
    @GetMapping("/cliente/{id}")
    public ResponseEntity<List<HistorialDTO>> getHistorialesByIdCliente(@PathVariable final Long id){
        return ResponseEntity.ok().body(historialService.listHistorialesByIdCliente(id));
    }
    @PostMapping
    public ResponseEntity<HistorialDTO> create(@Valid @RequestBody final HistorialDTO historialDTO) throws URISyntaxException {
        HistorialDTO historialDB=historialService.save(historialDTO);
        return ResponseEntity.created(new URI("v1/historiales/"+historialDB.getId())).body(historialDB);
    }
    @PutMapping("/{id}")
    public ResponseEntity<HistorialDTO> editHistorial(@Valid @RequestBody final HistorialDTO historialDTO) throws URISyntaxException {
        if(historialDTO.getId()==null){
            throw new IllegalArgumentException("Para esta operación se requiere un id.");
        }
        HistorialDTO historialDB=historialService.save(historialDTO);
        return ResponseEntity.created(new URI("v1/historiales/"+historialDB.getId())).body(historialDB);
    }
    @GetMapping("/{id}")
    public ResponseEntity<HistorialDTO> getHistorialById(@PathVariable final Long id){
        return ResponseEntity
                .ok()
                .body(historialService.getHistorialById(id).orElseThrow(() -> new IllegalArgumentException("Excepción. recurso no encontrado para id: " + id)));
    }
}
