package com.jem.jeeniso.repository;

import com.jem.jeeniso.dto.CalendarDto;
import com.jem.jeeniso.model.Calendar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICalendarRepository extends JpaRepository<Calendar, Integer> {
    void deleteByName(String name);
}
