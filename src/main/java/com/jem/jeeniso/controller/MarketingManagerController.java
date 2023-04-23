package com.jem.jeeniso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.jem.jeeniso.dto.MarketingManagerDto;
import com.jem.jeeniso.services.IMarketingManagerService;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;


import java.util.List;

import static com.jem.jeeniso.utils.Constants.MARKETING_MANAGER_ENDPOINT;

@RestController
@RequestMapping(MARKETING_MANAGER_ENDPOINT)
@Api(MARKETING_MANAGER_ENDPOINT)
public class MarketingManagerController {
    private IMarketingManagerService service;
    @Autowired
    public MarketingManagerController(IMarketingManagerService service) {
        this.service = service;
    }

    @PostMapping(value = "/create",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    MarketingManagerDto save( @RequestBody MarketingManagerDto Dto) {
        return service.save(Dto);
    }

    @GetMapping(value = "/findAll",
            produces = MediaType.APPLICATION_JSON_VALUE)
    List<MarketingManagerDto> findAll() {
        return service.findAll();
    }
}
