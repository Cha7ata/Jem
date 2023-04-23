package com.jem.jeeniso.repository;

import com.jem.jeeniso.model.MarketingManager;
import com.jem.jeeniso.model.ProjectManager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IMarketingManagerRepository extends JpaRepository<MarketingManager,Integer> {
    boolean existsByEmail(String email);

    Optional<MarketingManager>  findByEmail(String email);


}
