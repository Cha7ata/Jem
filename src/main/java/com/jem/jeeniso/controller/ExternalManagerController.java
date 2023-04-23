package com.jem.jeeniso.controller;

import com.jem.jeeniso.dto.ExternalManagerDto;
import com.jem.jeeniso.services.IExternalManagerService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.jem.jeeniso.utils.Constants.EXTERNAL_MANAGER_ENDPOINT;

@RestController
@RequestMapping(EXTERNAL_MANAGER_ENDPOINT)
@Api(EXTERNAL_MANAGER_ENDPOINT)
public class ExternalManagerController {

    private IExternalManagerService service;
    @Autowired
    public ExternalManagerController(IExternalManagerService service) {
        this.service = service;
    }

    @PostMapping(value = "/create")
    ExternalManagerDto save(@RequestBody ExternalManagerDto Dto) {
        return service.save(Dto);
    }

    @GetMapping(value = "/findAll")
    List<ExternalManagerDto> findAll() {
        return service.findAll();
    }
}
