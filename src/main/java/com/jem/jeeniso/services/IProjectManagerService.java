package com.jem.jeeniso.services;

import com.jem.jeeniso.dto.ProjectManagerDto;

import java.util.List;

public interface IProjectManagerService {
    ProjectManagerDto save(ProjectManagerDto Dto);

    List<ProjectManagerDto> findAll();

}
