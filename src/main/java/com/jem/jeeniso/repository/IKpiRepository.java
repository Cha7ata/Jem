package com.jem.jeeniso.repository;

import com.jem.jeeniso.model.Kpi;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IKpiRepository  extends JpaRepository<Kpi,Integer> {
    void deleteByTitle(String name);
}
