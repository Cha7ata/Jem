package com.jem.jeeniso.services;

import com.jem.jeeniso.dto.CalendarDto;

import java.util.Date;
import java.util.List;

public interface ICalendarService {
    CalendarDto save(CalendarDto Dto);

    List<CalendarDto> findAll();

    void delete(Integer id);

    void update(Integer id, String name, String description, Date date);

    CalendarDto findById(Integer id);
}
