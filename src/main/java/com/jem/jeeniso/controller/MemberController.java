package com.jem.jeeniso.controller;


import com.jem.jeeniso.dto.MemberDto;
import com.jem.jeeniso.services.IMemberService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.jem.jeeniso.utils.Constants.MEMBER_ENDPOINT;

@RestController
@RequestMapping(MEMBER_ENDPOINT)
@Api(MEMBER_ENDPOINT)
public class MemberController {
    private IMemberService service;
    @Autowired
    public MemberController(IMemberService service) {
        this.service = service;
    }


    @PostMapping(value = "/create",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    MemberDto save(@RequestBody MemberDto Dto) {
        return service.save(Dto) ;
    }


    @GetMapping(value = "/findAll",
            produces = MediaType.APPLICATION_JSON_VALUE)
    List<MemberDto> findAll() {

        return service.findAll();
    }
}
