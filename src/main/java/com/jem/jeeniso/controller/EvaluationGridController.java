package com.jem.jeeniso.controller;

import com.jem.jeeniso.dto.EvaluationGridDto;
import com.jem.jeeniso.services.IEvaluationGridService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.jem.jeeniso.utils.Constants.EVALUATION_GRID_ENDPOINT;

@RestController
@RequestMapping(EVALUATION_GRID_ENDPOINT)
@Api(EVALUATION_GRID_ENDPOINT)
public class EvaluationGridController {
    private IEvaluationGridService service;
    @Autowired
    public EvaluationGridController(IEvaluationGridService service) {
        this.service = service;
    }


    @PostMapping(value = "/create",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    EvaluationGridDto save( @RequestBody EvaluationGridDto Dto) {
        return service.save(Dto);
    }


    @GetMapping(value = "/findAll",
            produces = MediaType.APPLICATION_JSON_VALUE)
    List<EvaluationGridDto> findAll() {

        return service.findAll();
    }
}
