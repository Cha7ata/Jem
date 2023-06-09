package com.jem.jeeniso.repository;

import com.jem.jeeniso.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IRoleRepository extends JpaRepository<Role,Integer> {

    Optional<Role> findByRoleName(String name);

    boolean existsByroleName(String name);
}
