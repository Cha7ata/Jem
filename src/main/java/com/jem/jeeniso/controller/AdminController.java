package com.jem.jeeniso.controller;

import com.jem.jeeniso.dto.MemberDto;
import com.jem.jeeniso.model.Member;
import com.jem.jeeniso.services.IAdminService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

import static com.jem.jeeniso.utils.Constants.ADMIN_ENDPOINT;

@RestController
@RequestMapping(ADMIN_ENDPOINT)
@Api(ADMIN_ENDPOINT)
public class AdminController {
    private IAdminService service ;
    @Autowired
    public AdminController(IAdminService service) {
        this.service = service;
    }

    @DeleteMapping("/deleteAccount" )
    void delete(@RequestBody String email){
        service.delete(email);

    }

    @GetMapping(ADMIN_ENDPOINT + "/getunconfirmedList")
    public ArrayList<MemberDto> getUnconfirmedList(){
        return service.getUnconfirmedMembersList();
    }

    @PutMapping(ADMIN_ENDPOINT+"/confirmAccount")
    MemberDto confirmAccount(@RequestBody String email){
        return service.confirmAccount(email);
    };
}
