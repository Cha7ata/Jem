package com.jem.jeeniso.repository;

import com.jem.jeeniso.model.Trainer;
import com.jem.jeeniso.model.VicePresident;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITrainerRepository extends JpaRepository<Trainer,Integer> {
    boolean existsByEmail(String email);

    Trainer findByEmail(String email);
}
