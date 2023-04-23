package com.jem.jeeniso.repository;

import com.jem.jeeniso.model.Event;
import com.jem.jeeniso.model.MarketingManager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Instant;
import java.util.Date;

public interface IEventRepository extends JpaRepository<Event,Integer> {
    boolean existsByName(String Name);
    Event   findByName(String Name);
    boolean existsByDate (Date date);
}
