package com.jem.jeeniso.controller;

import com.jem.jeeniso.dto.TrainingDto;
import com.jem.jeeniso.services.ITrainingService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.jem.jeeniso.utils.Constants.TRAINING_ENDPOINT;

@RestController
@RequestMapping(TRAINING_ENDPOINT)
@Api(TRAINING_ENDPOINT)
public class TrainingController {

    private ITrainingService service;
    @Autowired
    public TrainingController(ITrainingService service) {
        this.service = service;
    }


    @PostMapping(value = "/create",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    TrainingDto save(@RequestBody TrainingDto Dto) {
        return service.save(Dto);
    }


    @GetMapping(value = "/findAll",
            produces = MediaType.APPLICATION_JSON_VALUE)
    List<TrainingDto> findAll(){

        return service.findAll();
    }
}
