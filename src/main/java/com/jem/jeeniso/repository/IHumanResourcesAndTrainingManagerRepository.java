package com.jem.jeeniso.repository;

import com.jem.jeeniso.model.HumanResourcesAndTrainingManager;
import com.jem.jeeniso.model.MarketingManager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IHumanResourcesAndTrainingManagerRepository extends JpaRepository<HumanResourcesAndTrainingManager,Integer> {
    boolean existsByEmail(String email);

   Optional<HumanResourcesAndTrainingManager> findByEmail(String email);
}
