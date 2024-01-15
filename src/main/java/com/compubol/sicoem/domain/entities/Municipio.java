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
@Table(name="municipio")
public class Municipio {
    @Id
    private Integer id;
    @NotBlank(message = "El código del municipio es requerido")
    private String codigo;
    @NotBlank(message = "El nombre del municipio es requerido")
    private String nombre;
    @Column(name = "codigodepto", nullable = false)
    @NotBlank(message = "El código del departamento es requerido")
    private String codigoDepto;
    @OneToMany(mappedBy = "municipio", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Cliente> clientes;
}
