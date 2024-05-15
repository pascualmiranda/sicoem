package com.compubol.sicoem.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="interes")
public class Interes {
    @Id
    private Integer id;
    //@NotBlank(message = "El interes diario es requerido")
    private Double interes;
    //@NotBlank(message = "El dia desde es requerido")
    private Integer diadesde;
    //@NotBlank(message = "El dia hasta es requerido")
    private Integer dishasta;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="capital_id")
    //@NotBlank(message = "El capital es requerido")
    private Capital capital;
}
