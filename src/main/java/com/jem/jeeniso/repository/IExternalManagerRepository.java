package com.jem.jeeniso.repository;

import com.jem.jeeniso.model.ExternalManager;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IExternalManagerRepository extends JpaRepository<ExternalManager,Integer> {

    Optional<ExternalManager> findByEmail(String email);
}
