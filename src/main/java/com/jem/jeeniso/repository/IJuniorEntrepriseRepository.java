package com.jem.jeeniso.repository;

import com.jem.jeeniso.dto.JuniorEntrepriseDto;
import com.jem.jeeniso.model.JuniorEntreprise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IJuniorEntrepriseRepository extends JpaRepository<JuniorEntreprise,Integer> {
    boolean existsByName(String Name);

}
