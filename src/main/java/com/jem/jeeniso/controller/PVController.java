package com.jem.jeeniso.controller;

import com.jem.jeeniso.dto.PVDto;
import com.jem.jeeniso.services.IPvService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.jem.jeeniso.utils.Constants.PV_ENDPOINT;


@RestController
@RequestMapping(PV_ENDPOINT)
@Api(PV_ENDPOINT)
public class PVController {

    private IPvService service;
    @Autowired
    public PVController(IPvService service) {
        this.service = service;
    }


    @PostMapping(value = "/create",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    PVDto save(@RequestBody PVDto Dto){
        return service.save(Dto);
    }


    @GetMapping(value = "/findAll",
            produces = MediaType.APPLICATION_JSON_VALUE)
    List<PVDto> findAll(){

        return service.findAll();
    }
}
