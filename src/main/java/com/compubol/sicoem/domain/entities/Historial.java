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
public class Historial {
    @Id
    private Long id;
    @NotBlank(message = "El nombre es requerido")
    private String nombre;
    @Lob
    private String descripcion;
    @Column(columnDefinition = "TIMESTAMP", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime fecha;
    @Column(columnDefinition = "boolean default true", nullable = false)
    private Boolean estado=true;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="cliente_id")
    @NotBlank(message = "El cliente es requerido")
    private Cliente cliente;
}
