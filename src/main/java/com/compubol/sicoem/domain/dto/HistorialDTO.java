package com.compubol.sicoem.domain.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class HistorialDTO {
    private Long id;
    private String nombre;
    private String descripcion;
    private Boolean estado;
    private Long idCliente;
}
