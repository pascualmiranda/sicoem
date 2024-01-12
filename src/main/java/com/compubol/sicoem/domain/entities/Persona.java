package com.compubol.sicoem.domain.entities;

import jakarta.persistence.*;
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
@Table(name="persona")
public class Persona {
    @Id
    private Long id;
    @Column(unique=true)
    @NotBlank(message = "El carnet de identidad es requerido")
    private String ci;
    @NotBlank(message = "El nombre es requerido")
    private String nombre;
    @Column(name = "primerapellido", nullable = false)
    @NotBlank(message = "El primer apellido es requerido")
    private  String primerApellido;
    @Column(name = "segundoapellido")
    private  String segundoApellido;
    @Enumerated(EnumType.ORDINAL)
    @NotBlank(message = "El género es requerido")
    private Identidad genero;
    private String direccion;
    private String telefono;
    private String email;
    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Usuario usuario;
}
