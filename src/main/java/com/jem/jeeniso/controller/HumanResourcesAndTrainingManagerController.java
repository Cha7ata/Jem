package com.jem.jeeniso.controller;

import com.jem.jeeniso.dto.HumanResourcesAndTrainingManagerDto;
import com.jem.jeeniso.services.IHumanResourcesAndTrainingManagerService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.jem.jeeniso.utils.Constants.HR_MANAGER_ENDPOINT;

@RestController
@RequestMapping(HR_MANAGER_ENDPOINT)
@Api(HR_MANAGER_ENDPOINT)
public class HumanResourcesAndTrainingManagerController {
    private IHumanResourcesAndTrainingManagerService service ;
    @Autowired
    public HumanResourcesAndTrainingManagerController(IHumanResourcesAndTrainingManagerService service) {
        this.service = service;
    }


    @PostMapping(value = "/create")
    HumanResourcesAndTrainingManagerDto save(@RequestBody HumanResourcesAndTrainingManagerDto Dto) {
        return service.save(Dto);
    }

    @GetMapping(value = "/findAll")
    List<HumanResourcesAndTrainingManagerDto> findAll() {
        return service.findAll();
    }
}
