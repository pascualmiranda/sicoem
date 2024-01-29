package com.compubol.sicoem.domain.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class GarantiaDTO {
    private Long id;
    private String nombre;
    private String descripcion;
    private Double cantidad;
    private Double valor;
    private String condicion;
    private Boolean estado;
    private Integer idMedida;
    private Integer idCategoria;
    private Long idCliente;
}
