package com.compubol.sicoem.repositories;

import com.compubol.sicoem.domain.dto.EmpenoDTO;
import com.compubol.sicoem.domain.entities.Empeno;
import com.compubol.sicoem.domain.entities.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Transactional
public interface EmpenoRepository extends JpaRepository<Empeno,Long> {
    @Query(value ="select * from sicoem.empeno e where e.cliente_id=?1", nativeQuery = true)
    List<Empeno> findByIdCliente(Long idCliente);
}
