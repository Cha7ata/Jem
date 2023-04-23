package com.jem.jeeniso.repository;

import com.jem.jeeniso.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ITaskRepository extends JpaRepository<Task,Integer> {
    boolean existsByName(String Name);

    void deleteByName(String name);

    Optional<Task> findByName(String name);
}
