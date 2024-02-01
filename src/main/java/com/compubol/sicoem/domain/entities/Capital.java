package com.compubol.sicoem.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="capital")
public class Capital {
    @Id
    private Integer id;
    @NotBlank(message = "El interes del capital es requerido")
    private Double interes;
    @NotBlank(message = "El rango desde del capital es requerido")
    private Double desde;
    @NotBlank(message = "El rango hasta del capital es requerido")
    private Double hasta;
    @Column(columnDefinition = "boolean default true", nullable = false)
    private Boolean estado=true;
    @OneToMany(mappedBy = "capital", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Interes> intereses;
    @OneToMany(mappedBy = "capital", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Empeno> empenos;
}
