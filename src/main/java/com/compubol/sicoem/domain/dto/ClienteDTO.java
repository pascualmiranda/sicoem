package com.compubol.sicoem.domain.dto;

import com.compubol.sicoem.domain.entities.Identidad;
import com.compubol.sicoem.domain.entities.Municipio;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {
    private Long id;
    private String foto;
    private String observaciones;
    private Boolean estado;
    private Integer idMunicipio;
    private Long idPersona;
    private String ci;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private Identidad genero;
    private String direccion;
    private String telefono;
    private String email;
}
