package com.compubol.sicoem.web.rest;

import com.compubol.sicoem.domain.dto.EmpenoDTO;
import com.compubol.sicoem.domain.dto.GarantiaDTO;
import com.compubol.sicoem.repositories.EmpenoRepository;
import com.compubol.sicoem.services.EmpenoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("v1/empenos")
public class EmpenoController {
    private final EmpenoService empenoService;

    public EmpenoController(EmpenoService empenoService) {
        this.empenoService = empenoService;
    }

    @GetMapping("/cliente/{id}")
    public ResponseEntity<List<EmpenoDTO>> getEmpenosByIdCliente(@PathVariable final Long id){
        return ResponseEntity.ok().body(empenoService.listEmpenosByIdCliente(id));
    }

    @PostMapping
    public ResponseEntity<EmpenoDTO> create(@Valid @RequestBody final EmpenoDTO empenoDTO) throws URISyntaxException {
        EmpenoDTO empenoDB=empenoService.save(empenoDTO);
        return ResponseEntity.created(new URI("v1/empenos/"+empenoDB.getId())).body(empenoDB);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmpenoDTO> editEmpeno(@Valid @RequestBody final EmpenoDTO empenoDTO) throws URISyntaxException {
        if(empenoDTO.getId()==null){
            throw new IllegalArgumentException("Para esta operación se requiere un id.");
        }
        EmpenoDTO empenoDB=empenoService.save(empenoDTO);
        return ResponseEntity.created(new URI("v1/empenos/"+empenoDB.getId())).body(empenoDB);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpenoDTO> getEmpenoById(@PathVariable final Long id){
        return ResponseEntity
                .ok()
                .body(empenoService.getEmpenoById(id).orElseThrow(() -> new IllegalArgumentException("Excepción. recurso no encontrado para id: " + id)));
    }
}
