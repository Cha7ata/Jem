package com.jem.jeeniso.repository;

import com.jem.jeeniso.model.EvaluationGrid;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IEvaluationGridRepository extends JpaRepository<EvaluationGrid,Integer> {
    boolean existsByMandate(String email);
    Optional<EvaluationGrid> findByMandate(String mandate);
}
