package com.compubol.sicoem.repositories;

import com.compubol.sicoem.domain.entities.Capital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CapitalRepository extends JpaRepository<Capital,Integer> {
}
