package com.jem.jeeniso.services;

import com.jem.jeeniso.dto.MeetingDto;
import com.jem.jeeniso.dto.TaskDto;
import com.jem.jeeniso.model.enumeration.MeetingType;

import java.util.Date;
import java.util.List;

public interface IMeetingService {
    MeetingDto save(MeetingDto Dto);

    List<MeetingDto> findAll();

    MeetingDto findById(Integer id);

    void delete(Integer id);

    void update(Integer id, String place, String description, Date date, MeetingType meetingType);
}
