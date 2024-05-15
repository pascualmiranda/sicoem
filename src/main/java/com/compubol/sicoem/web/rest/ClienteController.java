package com.compubol.sicoem.web.rest;

import com.compubol.sicoem.domain.dto.ClienteDTO;
import com.compubol.sicoem.services.ClienteService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("v1/clientes")
public class ClienteController {
    private ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> listClientes(){
        return ResponseEntity.ok().body(clienteService.listClientes());
    }
    @PostMapping
    public ResponseEntity<ClienteDTO> create(@Valid @RequestBody final ClienteDTO clienteDTO) throws URISyntaxException {
        ClienteDTO clienteDB=clienteService.save(clienteDTO);
        return ResponseEntity.created(new URI("v1/clientes/"+clienteDB.getId())).body(clienteDB);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> getClienteById(@PathVariable final Long id){
        return ResponseEntity
                .ok()
                .body(clienteService.getClienteById(id).orElseThrow(() -> new IllegalArgumentException("Excepción. recurso no encontrado para id: " + id)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO> editCliente(@Valid @RequestBody final ClienteDTO clienteDTO, @PathVariable final Long id) throws URISyntaxException {
        if(clienteDTO.getId()==null){
            throw new IllegalArgumentException("Para esta operación se requiere un id.");
        }

        if (!Objects.equals(clienteDTO.getId(), id)) {
            throw new IllegalArgumentException("Id no valido");
        }
        clienteDTO.setId(id);
        ClienteDTO clienteDB=clienteService.save(clienteDTO);
        return ResponseEntity.created(new URI("v1/clientes/"+clienteDB.getId())).body(clienteDB);
    }
}
