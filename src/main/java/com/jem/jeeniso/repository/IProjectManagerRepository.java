package com.jem.jeeniso.repository;

import com.jem.jeeniso.model.ProjectManager;
import com.jem.jeeniso.model.Secretary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IProjectManagerRepository extends JpaRepository<ProjectManager,Integer> {

    boolean existsByEmail(String email);

    Optional<ProjectManager > findByEmail(String email);
}
