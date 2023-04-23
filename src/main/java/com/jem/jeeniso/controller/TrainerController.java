package com.jem.jeeniso.controller;

import com.jem.jeeniso.dto.TrainerDto;

import com.jem.jeeniso.services.ITrainerService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.jem.jeeniso.utils.Constants.TRAINER_ENDPOINT;

@RestController
@RequestMapping(TRAINER_ENDPOINT)
@Api(TRAINER_ENDPOINT)
public class TrainerController {

    private ITrainerService service;
    @Autowired
    public TrainerController(ITrainerService service) {
        this.service = service;
    }


    @PostMapping(value = "/create",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    TrainerDto save(@RequestBody TrainerDto Dto) {
        return service.save(Dto);
    }


    @GetMapping(value = "/findAll",
            produces = MediaType.APPLICATION_JSON_VALUE)
    List<TrainerDto> findAll(){

        return service.findAll();
    }
}
