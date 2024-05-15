package com.compubol.sicoem.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="usuario")
public class Usuario implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique=true)
    @NotBlank(message = "El nombre de usuario es requerido")
    private String login;
    @NotBlank(message = "La contraseña es requerido")
    private String clave;
    @Column(columnDefinition = "boolean default true", nullable = false)
    private boolean estado=true;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="persona_id")
    //@NotBlank(message = "Los datos de la persona son requerido")
    private Persona persona;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="rol_id")
    //@NotBlank(message = "El rol es requerido")
    Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.getName()));
    }

    @Override
    public String getPassword() {
        return clave;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return estado;
    }
}
