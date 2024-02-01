package com.compubol.sicoem.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="empeno")
public class Empeno {
    @Id
    private Long id;
    @NotBlank(message = "El monto de empeño es requerido")
    private Double monto;
    @Column(columnDefinition = "TIMESTAMP", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime fecha;
    @Lob
    private String observacion;
    @Column(columnDefinition = "boolean default true", nullable = false)
    private Boolean estado=true;
    @NotBlank(message = "La fecha de plazo del empeño es requerido")
    @JoinColumn(name="fecha_plazo")
    private LocalDate fechaPlazo;
    @JoinColumn(name="fecha_cierre")
    private LocalDateTime fechaCierre;
    @ManyToOne(fetch = FetchType.LAZY)
    @NotBlank(message = "El capital del empeño es requerido")
    @JoinColumn(name="capital_id")
    private Capital capital;
    @ManyToOne(fetch = FetchType.LAZY)
    @NotBlank(message = "El cliente para el empeño es requerido")
    @JoinColumn(name="cliente_id")
    private Cliente cliente;
}
