package com.jem.jeeniso.services;

import com.jem.jeeniso.dto.EventDto;

import java.util.List;

public interface IEventService {
    EventDto save(EventDto Dto);

    List<EventDto> findAll();

}
