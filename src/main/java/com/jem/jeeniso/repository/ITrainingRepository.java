package com.jem.jeeniso.repository;

import com.jem.jeeniso.model.Training;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ITrainingRepository extends JpaRepository<Training,Integer> {

    Optional<Training> findByName(String name);
}
