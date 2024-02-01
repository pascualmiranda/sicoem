package com.compubol.sicoem.domain.dto;

import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EmpenoDTO {
    private Long id;
    private Double monto;
    private String observacion;
    private Boolean estado;
    private LocalDate fechaPlazo;
    private Integer idCapital;
    private Long idCliente;
}
