package com.jem.jeeniso.controller;

import com.jem.jeeniso.dto.EventDto;
import com.jem.jeeniso.services.IEventService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.jem.jeeniso.utils.Constants.EVENT_ENDPOINT;

@RestController
@RequestMapping(EVENT_ENDPOINT)
@Api(EVENT_ENDPOINT)
public class EventController {
    private IEventService service ;
    @Autowired
    public EventController(IEventService service) {
        this.service = service;
    }


    @PostMapping(value = "/create",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    EventDto save(@RequestBody EventDto Dto) {
        return service.save(Dto);
    }



    @GetMapping(value = "/findAll",
            produces = MediaType.APPLICATION_JSON_VALUE)
    List<EventDto> findAll() {
        return service.findAll();
    }
}
