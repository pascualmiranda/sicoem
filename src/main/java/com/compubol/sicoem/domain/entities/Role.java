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
@Table(name="rol")
public class Role {
    @Id
    private Integer id;
    @Column(name = "codigo",unique=true)
    //@NotBlank(message = "El nombre del es requerido")
    private String name;
    //@NotBlank(message = "La descripción del rol es requerido")
    private String descripcion;
    @Column(columnDefinition = "boolean default true", nullable = false)
    private Boolean estado=true;
    /*@OneToMany(mappedBy = "role", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Usuario> usuario;*/
}
