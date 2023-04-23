package com.jem.jeeniso.controller;

import com.jem.jeeniso.dto.SecretaryDto;
import com.jem.jeeniso.services.ISecretaryService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.jem.jeeniso.utils.Constants.SECRETARY_ENDPOINT;


@RestController
@RequestMapping(SECRETARY_ENDPOINT)
@Api(SECRETARY_ENDPOINT)
public class SecretaryController {
    private ISecretaryService service;
    @Autowired
    public SecretaryController(ISecretaryService service) {
        this.service = service;
    }


    @PostMapping(value = "/create",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    SecretaryDto save(@RequestBody SecretaryDto Dto){
        return service.save(Dto);
    }


    @GetMapping(value = "/findAll",
            produces = MediaType.APPLICATION_JSON_VALUE)
    List<SecretaryDto> findAll(){

        return service.findAll();
    }

}
