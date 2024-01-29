package com.compubol.sicoem.web.rest;

import com.compubol.sicoem.domain.dto.GarantiaDTO;
import com.compubol.sicoem.domain.dto.HistorialDTO;
import com.compubol.sicoem.services.GarantiaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("v1/garantias")
public class GarantiaController {
    private final GarantiaService garantiaService;

    public GarantiaController(GarantiaService garantiaService) {
        this.garantiaService = garantiaService;
    }
    @GetMapping("/cliente/{id}")
    public ResponseEntity<List<GarantiaDTO>> getGarantiasByIdCliente(@PathVariable final Long id){
        return ResponseEntity.ok().body(garantiaService.listGarantiasByIdCliente(id));
    }
    @PostMapping
    public ResponseEntity<GarantiaDTO> create(@Valid @RequestBody final GarantiaDTO garantiaDTO) throws URISyntaxException {
        GarantiaDTO garantiaDB=garantiaService.save(garantiaDTO);
        return ResponseEntity.created(new URI("v1/garantias/"+garantiaDB.getId())).body(garantiaDB);
    }
    @PutMapping("/{id}")
    public ResponseEntity<GarantiaDTO> editGarantia(@Valid @RequestBody final GarantiaDTO garantiaDTO) throws URISyntaxException {
        if(garantiaDTO.getId()==null){
            throw new IllegalArgumentException("Para esta operación se requiere un id.");
        }
        GarantiaDTO garantiaDB=garantiaService.save(garantiaDTO);
        return ResponseEntity.created(new URI("v1/garantias/"+garantiaDB.getId())).body(garantiaDB);
    }
    @GetMapping("/{id}")
    public ResponseEntity<GarantiaDTO> getGarantiaById(@PathVariable final Long id){
        return ResponseEntity
                .ok()
                .body(garantiaService.getGarantiaById(id).orElseThrow(() -> new IllegalArgumentException("Excepción. recurso no encontrado para id: " + id)));
    }
}
