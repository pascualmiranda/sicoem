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
@Table(name="medida")
public class Medida {
    @Id
    private Integer id;
    @Column(unique=true)
    @NotBlank(message = "El código del de la medida es requerido")
    private String codigo;
    private String nombre;
}
