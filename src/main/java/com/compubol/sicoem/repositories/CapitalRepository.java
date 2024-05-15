package com.compubol.sicoem.repositories;

import com.compubol.sicoem.domain.entities.Capital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CapitalRepository extends JpaRepository<Capital,Integer> {

    @Query(value ="select * from sicoem.capital c where c.desde <= ?1 and c.hasta >=?1 limit 1", nativeQuery = true)
    Optional<Capital> buscarDentroDesdeHasta(Double capPrestamo);
}
