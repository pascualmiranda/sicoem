package com.compubol.sicoem.domain.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MovimientoDTO {
    private Long id;
    private LocalDateTime fecha;
    private Double cantidad;
    private String referencia;
    private String concepto;
    private String descripcion;
    private String tipo;
    private Boolean estado;
    private Integer idTipoMov;
    private Long idEmpeno;
}
