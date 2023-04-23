package com.jem.jeeniso.controller;

import com.jem.jeeniso.dto.VicePresidentDto;
import com.jem.jeeniso.services.IVicePresidentService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.jem.jeeniso.utils.Constants.VICE_PRESIDENT_ENDPOINT;


@RestController
@RequestMapping(VICE_PRESIDENT_ENDPOINT)
@Api(VICE_PRESIDENT_ENDPOINT)
public class VicePresidentController {
    private IVicePresidentService service;
    @Autowired
    public VicePresidentController(IVicePresidentService service) {
        this.service = service;
    }


    @PostMapping(value = "/create",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    VicePresidentDto save(@RequestBody VicePresidentDto Dto) {
        return service.save(Dto);
    }


    @GetMapping(value = "/findAll",
            produces = MediaType.APPLICATION_JSON_VALUE)
    List<VicePresidentDto> findAll(){

        return service.findAll();
    }
}
