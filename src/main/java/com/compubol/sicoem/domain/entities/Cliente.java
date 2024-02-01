package com.compubol.sicoem.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="cliente")
public class Cliente {
    @Id
    private  Long id;
    @Column(columnDefinition = "TIMESTAMP", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime fecha;
    private  String foto;
    private String observaciones;
    @Column(columnDefinition = "boolean default true", nullable = false)
    private  Boolean estado=true;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="persona_id")
    private Persona persona;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="municipio_id")
    private Municipio municipio;
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Historial> historiales;
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Garantia> garantias;
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Empeno> empenos;
}
