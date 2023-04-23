package com.jem.jeeniso.controller;

import com.jem.jeeniso.dto.RoleDto;
import com.jem.jeeniso.services.IRoleService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.jem.jeeniso.utils.Constants.ROLE_ENDPOINT;


@RestController
@RequestMapping(ROLE_ENDPOINT)
@Api(ROLE_ENDPOINT)
public class RoleController {

    private IRoleService service;

    @Autowired
    public RoleController(IRoleService service) {
        this.service = service;
    }

    @PostMapping(value = "/create")
    RoleDto save(@RequestBody RoleDto Dto){
        return service.save(Dto);
    }


    @GetMapping("/findAll")
    List<RoleDto> findAll(){
        return service.findAll();
    }
}
