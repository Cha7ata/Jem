package com.jem.jeeniso.repository;

import com.jem.jeeniso.model.BusinessDevelopmentManager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IBusinessDevelopmentManagerRepository extends JpaRepository<BusinessDevelopmentManager,Integer> {
    boolean existsByEmail(String email);

    Optional<BusinessDevelopmentManager> findByEmail(String email);
}
