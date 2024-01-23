package com.compubol.sicoem.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Table(name="categoria")
public class Categoria {
    @Id
    private Integer id;
    @NotBlank(message = "El nombre de la categoria es requerido")
    private String nombre;
    private String descripcion;
    @Column(columnDefinition = "boolean default true", nullable = false)
    private Boolean estado=true;
}
