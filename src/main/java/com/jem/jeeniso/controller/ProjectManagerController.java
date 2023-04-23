package com.jem.jeeniso.controller;

import com.jem.jeeniso.dto.ProjectManagerDto;
import com.jem.jeeniso.services.IProjectManagerService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.jem.jeeniso.utils.Constants.PROJECT_MANAGER_ENDPOINT;

@RestController
@RequestMapping(PROJECT_MANAGER_ENDPOINT)
@Api(PROJECT_MANAGER_ENDPOINT)
public class ProjectManagerController {

    private IProjectManagerService service;
    @Autowired
    public ProjectManagerController(IProjectManagerService service) {
        this.service = service;
    }


    @PostMapping(value = "/create",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    ProjectManagerDto save(@RequestBody ProjectManagerDto Dto) {
        return service.save(Dto);
    }


    @GetMapping(value = "/findAll",
            produces = MediaType.APPLICATION_JSON_VALUE)
    List<ProjectManagerDto> findAll(){

        return service.findAll();
    }
}
