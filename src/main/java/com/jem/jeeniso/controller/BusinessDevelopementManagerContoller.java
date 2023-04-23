package com.jem.jeeniso.controller;

import com.jem.jeeniso.dto.BusinessDevelopmentManagerDto;
import com.jem.jeeniso.services.IBusinessDevelopmentManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import java.util.List;
import static com.jem.jeeniso.utils.Constants.BUSINESSDEVELOPEMENT_MANAGER_ENDPOINT;



@RestController
@RequestMapping(BUSINESSDEVELOPEMENT_MANAGER_ENDPOINT)
@Api(BUSINESSDEVELOPEMENT_MANAGER_ENDPOINT)

public class BusinessDevelopementManagerContoller {
    private IBusinessDevelopmentManagerService service ;

    @Autowired
    public BusinessDevelopementManagerContoller(IBusinessDevelopmentManagerService service) {
        this.service = service;
    }

    @PostMapping(value = "/create")
    BusinessDevelopmentManagerDto save(@RequestBody BusinessDevelopmentManagerDto dto) {
        return service.save(dto);
    }

    @GetMapping(value = "/findAll")

    List<BusinessDevelopmentManagerDto> findAll(){
        return service.findAll();
    }
}
