package com.jem.jeeniso.controller;

import com.jem.jeeniso.dto.MeetingDto;
import com.jem.jeeniso.dto.TaskDto;
import com.jem.jeeniso.model.enumeration.AchievedStat;
import com.jem.jeeniso.model.enumeration.MeetingType;
import com.jem.jeeniso.model.enumeration.TaskType;
import com.jem.jeeniso.services.IMeetingService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

import static com.jem.jeeniso.utils.Constants.MEETING_ENDPOINT;

@RestController
@RequestMapping(MEETING_ENDPOINT)
@Api(MEETING_ENDPOINT)
public class MeetingController {
    private IMeetingService service ;
    @Autowired
    public MeetingController(IMeetingService service) {
        this.service = service;
    }

    @PostMapping(value = "/create",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    MeetingDto save(@RequestBody MeetingDto Dto){
        return service.save(Dto);
    }


    @GetMapping(value = "/findAll",
            produces = MediaType.APPLICATION_JSON_VALUE)
    List<MeetingDto> findAll() {
        return service.findAll();
    }

    @DeleteMapping("/delete/{id}")
    void delete(@PathVariable Integer id) {
        service.delete(id);
    }

    @PatchMapping(value = "/update/{name}",produces = MediaType.APPLICATION_JSON_VALUE)
    void  update(@PathVariable Integer id, String place, String description, Date date, MeetingType meetingType){
        service.update(id,place,description,date,meetingType);}

    @GetMapping(value = "/findByName/{id}")
    MeetingDto findbyId(@PathVariable Integer id ){return service.findById(id);}

}
