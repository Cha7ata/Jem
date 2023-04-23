package com.jem.jeeniso.controller;

import com.jem.jeeniso.dto.CalendarDto;
import com.jem.jeeniso.dto.MediaDto;
import com.jem.jeeniso.dto.TaskDto;
import com.jem.jeeniso.services.IMediaService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

import static com.jem.jeeniso.utils.Constants.MEDIA_ENDPOINT;


@RestController
@RequestMapping(MEDIA_ENDPOINT)
@Api(MEDIA_ENDPOINT)
public class MediaController {

    private IMediaService service ;
    @Autowired
    public MediaController(IMediaService service) {
        this.service = service;
    }


    @PostMapping(value = "/create",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    MediaDto save(@RequestBody MediaDto Dto) {
        return service.save(Dto);
    }


    @GetMapping(value = "/findAll",
            produces = MediaType.APPLICATION_JSON_VALUE)
    List<MediaDto> findAll() {
        return service.findAll();
    }



    @DeleteMapping("/delete/{id}")
    void delete(@PathVariable Integer id) {
        service.delete(id);
    }
    @PostMapping(value = "/update/{name}",produces = MediaType.APPLICATION_JSON_VALUE)
    void update(@PathVariable Integer id, String name, String email, String phoneNumber,String address){ service.update(id,name,email,phoneNumber,address);}

    @GetMapping(value = "/findbyid/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    MediaDto findById(@PathVariable Integer id) {
        return service.findById(id);
    }

}
