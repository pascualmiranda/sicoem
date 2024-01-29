package com.compubol.sicoem.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Garantia {
    @Id
    private Long id;
    @NotBlank(message = "El nombre de la garantia es requerido")
    private String nombre;
    private String descripcion;
    @NotBlank(message = "La cantidad de la garantia es requerido")
    private Double cantidad;
    @NotBlank(message = "El valor de la garantia es requerido")
    private Double valor;
    @NotBlank(message = "La condición de la garantia es requerido")
    private String condicion;
    @Column(columnDefinition = "TIMESTAMP", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime fecha;
    @Column(columnDefinition = "boolean default true", nullable = false)
    private Boolean estado=true;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="medida_id")
    @NotBlank(message = "La unidad de medida de la garantia es requerido")
    private Medida medida;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="categoria_id")
    @NotBlank(message = "La categoria de la garantia es requerido")
    private Categoria categoria;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="cliente_id")
    @NotBlank(message = "El cliente para la garantia es requerido")
    private Cliente cliente;
}
