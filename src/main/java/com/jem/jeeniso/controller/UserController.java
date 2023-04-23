package com.jem.jeeniso.controller;

import com.jem.jeeniso.dto.SecretaryDto;
import com.jem.jeeniso.dto.UserDto;
import com.jem.jeeniso.model.User;
import com.jem.jeeniso.services.IUserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.jem.jeeniso.utils.Constants.USER_ENDPOINT;

@RestController
@RequestMapping(USER_ENDPOINT)
@Api(USER_ENDPOINT)
public class UserController {

    private IUserService service;
    @Autowired
    public UserController(IUserService service) {
        this.service = service;
    }


    @GetMapping(value = "/findAll",
            produces = MediaType.APPLICATION_JSON_VALUE)
    List<UserDto> findAll(){

        return service.findAll();
    }
    @PostMapping(value = "/create")
    UserDto save(@RequestBody UserDto Dto){
        return service.save(Dto);
    }





}
