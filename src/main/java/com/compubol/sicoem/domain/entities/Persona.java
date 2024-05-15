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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Enumerated(EnumType.STRING)
    private Identidad genero;
    private String direccion;
    private String telefono;
    private String email;
    @OneToOne(mappedBy = "persona", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Usuario usuario;
    @OneToOne(mappedBy = "persona", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Cliente cliente;
}
