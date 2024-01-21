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
public class Rol {
    @Id
    private Integer id;
    @Column(unique=true)
    @NotBlank(message = "El código de rol es requerido")
    private String codigo;
    @NotBlank(message = "La descripción del rol es requerido")
    private String descripcion;
    @Column(columnDefinition = "boolean default true", nullable = false)
    private Boolean estado=true;
    @OneToMany(mappedBy = "rol", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Usuario> usuario;
}
