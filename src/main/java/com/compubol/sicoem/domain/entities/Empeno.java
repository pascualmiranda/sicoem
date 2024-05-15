package com.compubol.sicoem.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="empeno")
public class Empeno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "El monto de empeño es requerido")
    private Double monto;
    @Column(columnDefinition = "TIMESTAMP", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime fecha;
    @Lob
    private String observacion;
    @Column(columnDefinition = "boolean default true", nullable = false)
    private Boolean estado=true;
    @NotNull(message = "La fecha de plazo del empeño es requerido")
    @JoinColumn(name="fecha_plazo")
    private LocalDate fechaPlazo;
    @JoinColumn(name="fecha_cierre")
    private LocalDateTime fechaCierre;
    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull(message = "El capital del empeño es requerido")
    @JoinColumn(name="capital_id")
    private Capital capital;
    @ManyToOne(fetch = FetchType.LAZY)
    //@NotBlank(message = "El cliente para el empeño es requerido")
    @NotNull(message = "El cliente para el empeño es requerido")
    @JoinColumn(name="cliente_id")
    private Cliente cliente;
    @OneToMany(mappedBy = "empeno", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Movimiento> movimientos;
}
