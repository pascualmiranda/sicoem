package com.compubol.sicoem.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="movimiento")
public class Movimiento {
    @Id
    private Long id;
    @Column(columnDefinition = "TIMESTAMP", nullable = false)
    @CreationTimestamp
    private LocalDateTime fecha;
    @NotBlank(message = "La cantidad en movimiento es requerido")
    private Double cantidad;
    private String referencia;
    private String concepto;
    private String descripcion;
    private String tipo;
    @Column(columnDefinition = "boolean default true", nullable = false)
    private Boolean estado=true;
    @ManyToOne(fetch = FetchType.LAZY)
    @NotBlank(message = "El tipo de movimiento es requerido")
    @JoinColumn(name="tipomov_id")
    private TipoMovimiento tipoMovimiento;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="empeno_id")
    private Empeno empeno;
    /*@ManyToOne(fetch = FetchType.LAZY)
    @NotBlank(message = "El usuario del movimiento es requerido")
    @JoinColumn(name="usuario_id")
    private Usuario usuario;*/
}
