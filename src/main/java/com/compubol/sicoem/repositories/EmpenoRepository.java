package com.compubol.sicoem.repositories;

import com.compubol.sicoem.domain.entities.Empeno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpenoRepository extends JpaRepository<Empeno,Long> {
}
