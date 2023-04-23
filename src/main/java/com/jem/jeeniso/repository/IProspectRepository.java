package com.jem.jeeniso.repository;

import com.jem.jeeniso.model.Prospect;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IProspectRepository extends JpaRepository<Prospect,Integer> {
    boolean existsByOrganisationName(String Name);


    Optional<Prospect> findByOrganisationName(String organisation);
}
