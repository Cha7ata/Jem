package com.jem.jeeniso.repository;

import com.jem.jeeniso.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProjectRepository extends JpaRepository<Project, Integer> {
    boolean existsByName(String Name);

}
