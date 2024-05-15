package com.compubol.sicoem.repositories;

import com.compubol.sicoem.domain.entities.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MovimientoRepository extends JpaRepository<Movimiento,Long> {
    @Query(value ="select * from sicoem.movimiento m where m.empeno_id=?1 and m.tipo='Egreso' and m.estado=true limit 1", nativeQuery = true)
    Optional<Movimiento> buscarMovimientoEgresoActivo(Long idEmpeno);
}
