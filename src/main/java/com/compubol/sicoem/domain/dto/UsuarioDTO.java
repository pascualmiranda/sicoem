package com.compubol.sicoem.domain.dto;

import com.compubol.sicoem.domain.entities.Identidad;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {
    private Long id;
    private String login;
    private String clave;
    private boolean estado;
    private Integer idRol;
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
