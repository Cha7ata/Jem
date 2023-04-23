package com.jem.jeeniso.repository;

import com.jem.jeeniso.model.VicePresident;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IVicePresidentRepository extends JpaRepository<VicePresident,Integer> {
    boolean existsByEmail(String email);

    Optional<VicePresident> findByEmail(String email);

}
