package com.compubol.sicoem.repositories;

import com.compubol.sicoem.domain.entities.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona,Long> {
}
