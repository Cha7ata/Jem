package com.jem.jeeniso.controller;


import com.jem.jeeniso.dto.CalendarDto;
import com.jem.jeeniso.dto.MediaDto;
import com.jem.jeeniso.services.ICalendarService;
import com.jem.jeeniso.services.IMediaService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

import static com.jem.jeeniso.utils.Constants.CALENDAR_ENDPOINT;

@RestController
@RequestMapping(CALENDAR_ENDPOINT)
@Api(CALENDAR_ENDPOINT)
public class CalendarController {

    private ICalendarService service ;
    @Autowired
    public CalendarController(ICalendarService service) {
        this.service = service;
    }


    @PostMapping(value = "/create",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    CalendarDto save(@RequestBody CalendarDto Dto) {
        return service.save(Dto);
    }


    @GetMapping(value = "/findAll",
            produces = MediaType.APPLICATION_JSON_VALUE)
    List<CalendarDto> findAll() {
        return service.findAll();
    }

    @DeleteMapping("/delete/{id}")
    void delete(@PathVariable Integer id) {
        service.delete(id);
    }

    @PatchMapping(value = "/update/{name}",produces = MediaType.APPLICATION_JSON_VALUE)
    void update(@PathVariable Integer id, String name, String description, Date date){ service.update(id,name,description,date);}

    @GetMapping(value = "/filterById/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    CalendarDto findById(@PathVariable Integer id) {
        return service.findById(id);
    }

}
