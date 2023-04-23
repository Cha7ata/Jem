package com.jem.jeeniso.repository;

import com.jem.jeeniso.model.Event;
import com.jem.jeeniso.model.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Instant;

public interface IMeetingRepository extends JpaRepository<Meeting,Integer> {

    void deleteBydate(String name);
}
