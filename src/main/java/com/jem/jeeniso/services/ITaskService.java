package com.jem.jeeniso.services;

import com.jem.jeeniso.dto.TaskDto;
import com.jem.jeeniso.model.enumeration.AchievedStat;
import com.jem.jeeniso.model.enumeration.TaskType;

import java.util.Date;
import java.util.List;

public interface ITaskService {
    TaskDto save(TaskDto Dto);

    List<TaskDto> findAll();

    TaskDto findById(Integer id);

    void delete(String name);

    TaskDto findByname(String name);


    void update(String name, String Description, Date assignementDate, Integer meritPoint, Date deadLine, TaskType taskType, AchievedStat achievedStat);
}
