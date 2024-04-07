package com.compubol.sicoem.repositories;

import com.compubol.sicoem.domain.entities.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimientoRepository extends JpaRepository<Movimiento,Long> {
}
