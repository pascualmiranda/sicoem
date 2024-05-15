package com.compubol.sicoem.repositories;

import com.compubol.sicoem.domain.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepository extends JpaRepository<Role,Integer> {
}
