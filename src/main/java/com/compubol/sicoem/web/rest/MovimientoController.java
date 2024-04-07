package com.compubol.sicoem.web.rest;

import com.compubol.sicoem.domain.dto.ClienteDTO;
import com.compubol.sicoem.domain.dto.EmpenoDTO;
import com.compubol.sicoem.domain.dto.MovimientoDTO;
import com.compubol.sicoem.services.MovimientoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("v1/movimientos")
public class MovimientoController {
    private final MovimientoService movimientoService;

    public MovimientoController(MovimientoService movimientoService) {
        this.movimientoService = movimientoService;
    }
    @GetMapping
    public ResponseEntity<List<MovimientoDTO>> listMovimientos(){
        return ResponseEntity.ok().body(movimientoService.listMovimientos());
    }
    @GetMapping("/empeno/{id}")
    public ResponseEntity<List<MovimientoDTO>> getMovimientosByIdEmpeno(@PathVariable final Long id){
        return ResponseEntity.ok().body(movimientoService.listMovimientosByIdEmpeno(id));
    }
    @PostMapping
    public ResponseEntity<MovimientoDTO> create(@Valid @RequestBody final MovimientoDTO movimientoDTO) throws URISyntaxException {
        MovimientoDTO movimientoDB=movimientoService.save(movimientoDTO);
        return ResponseEntity.created(new URI("v1/movimientos/"+movimientoDB.getId())).body(movimientoDB);
    }
    @PutMapping("/{id}")
    public ResponseEntity<MovimientoDTO> editMovimiento(@Valid @RequestBody final MovimientoDTO movimientoDTO) throws URISyntaxException {
        if(movimientoDTO.getId()==null){
            throw new IllegalArgumentException("Para esta operación se requiere un id.");
        }
        MovimientoDTO movimientoDB=movimientoService.save(movimientoDTO);
        return ResponseEntity.created(new URI("v1/movimientos/"+movimientoDB.getId())).body(movimientoDB);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovimientoDTO> getMovimientoById(@PathVariable final Long id){
        return ResponseEntity
                .ok()
                .body(movimientoService.getMovimientoById(id).orElseThrow(() -> new IllegalArgumentException("Excepción. recurso no encontrado para id: " + id)));
    }
}
