package com.jem.jeeniso.services;

import com.jem.jeeniso.dto.ProjectDto;
import com.jem.jeeniso.model.Project;

import java.util.List;

public interface IProjectService {
    ProjectDto save(ProjectDto Dto);

    List<ProjectDto> findAll();

}
