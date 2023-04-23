package com.jem.jeeniso.repository;

import com.jem.jeeniso.model.PV;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPvRepository extends JpaRepository<PV,Integer> {

    PV findByTitle(String Title);


}
