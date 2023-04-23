package com.jem.jeeniso.repository;

import com.jem.jeeniso.model.Secretary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ISecretaryRepository extends JpaRepository<Secretary,Integer> {

    boolean existsByEmail(String email);

    Optional<Secretary> findByEmail(String email);
}
