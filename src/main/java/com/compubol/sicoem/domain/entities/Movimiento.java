package com.compubol.sicoem.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "TIMESTAMP", nullable = false)
    @CreationTimestamp
    private LocalDateTime fecha;
    @NotNull(message = "La cantidad en movimiento es requerido")
    private Double cantidad;
    private String referencia;
    private String concepto;
    private String descripcion;
    private String tipo;
    @Column(columnDefinition = "boolean default true", nullable = false)
    private Boolean estado=true;
    @ManyToOne(fetch = FetchType.EAGER)
    @NotNull(message = "El tipo de movimiento es requerido")
    @JoinColumn(name="tipomov_id")
    private TipoMovimiento tipoMovimiento;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="empeno_id")
    private Empeno empeno;
    /*@ManyToOne(fetch = FetchType.LAZY)
    @NotBlank(message = "El usuario del movimiento es requerido")
    @JoinColumn(name="usuario_id")
    private Usuario usuario;*/
}
