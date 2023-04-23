package com.jem.jeeniso.controller;

import com.jem.jeeniso.dto.PartnerDto;
import com.jem.jeeniso.dto.ProspectDto;
import com.jem.jeeniso.model.enumeration.Status;
import com.jem.jeeniso.services.IProspectService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.jem.jeeniso.utils.Constants.PROSPECT_ENDPOINT;


@RestController
@RequestMapping(PROSPECT_ENDPOINT)
@Api(PROSPECT_ENDPOINT)
public class ProspectController {

    private IProspectService service;

   @Autowired
    public ProspectController(IProspectService service) {
        this.service = service;
    }

    @PostMapping( "/create")
    ProspectDto save(@RequestBody ProspectDto Dto){
        return service.save(Dto);
    }


    @GetMapping( "/findAll")
    List<ProspectDto> findAll(){
        return service.findAll();
    }

    @DeleteMapping("/deleteProspect" )
    void delete(@RequestBody String organisation){
        service.delete(organisation);

    }

    @GetMapping(value ="/findlistbystatus")
    ArrayList<ProspectDto> findListByStatus(Status status) {
        return  service.findListByStatus(status);
    }

    @PatchMapping(value = "/update")
    public ProspectDto update(String responsableName, String phoneNumber, Status status , String address,String organizationName,String function,String email) {
        return service.update(responsableName,phoneNumber,status,address,organizationName,function,email);
    }
}
