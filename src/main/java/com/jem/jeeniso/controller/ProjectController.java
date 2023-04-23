package com.jem.jeeniso.controller;


import com.jem.jeeniso.dto.ProjectDto;
import com.jem.jeeniso.model.Project;
import com.jem.jeeniso.services.IProjectService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.jem.jeeniso.utils.Constants.PROJECT_ENDPOINT;

@RestController
@RequestMapping(PROJECT_ENDPOINT)
@Api(PROJECT_ENDPOINT)
public class ProjectController {
    private IProjectService service;
    @Autowired
    public ProjectController(IProjectService service) {
        this.service = service;
    }

    @PostMapping(value = "/create",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    ProjectDto save(@RequestBody ProjectDto Dto) {
        return service.save(Dto);
    }


    @GetMapping(value = "/findAll",
            produces = MediaType.APPLICATION_JSON_VALUE)
    List<ProjectDto> findAll(){

        return service.findAll();
    }
}
