package com.jem.jeeniso.controller;

import com.jem.jeeniso.dto.PartnerDto;
import com.jem.jeeniso.model.enumeration.Status;
import com.jem.jeeniso.services.IPartnerService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.jem.jeeniso.utils.Constants.PARTNER_ENDPOINT;

@RestController
@RequestMapping(PARTNER_ENDPOINT)
@Api(PARTNER_ENDPOINT)
public class PartnerController {

    private IPartnerService service ;


    @Autowired
    public PartnerController(IPartnerService service) {
        this.service = service;
    }


    @PostMapping(value = "/create",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    PartnerDto save(@RequestBody PartnerDto Dto){
        return service.save(Dto);
    }

    @GetMapping(value ="/findlistbystatus")
    ArrayList<PartnerDto> findListByStatus(Status status) {
        return  service.findListByStatus(status);
    }


    @GetMapping(value = "/findAll",
            produces = MediaType.APPLICATION_JSON_VALUE)
    List<PartnerDto> findAll() {
      return service.findAll()  ;
    }

    @DeleteMapping(value="/deletePartner" )
    void delete(@RequestBody String organisation){
        service.delete(organisation);

    }   @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {
        //convert the date Note that the conversion here should always be in the same format as the string passed in, e.g. 2015-9-9 should be yyyy-MM-dd
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));// CustomDateEditor is a custom date editor
    }

    @PatchMapping(value = "/update")
    public PartnerDto update(String manager, String managerPhoneNumber, Status status , String description, Date expansionDate, String organizationName) {
        return service.update(manager,managerPhoneNumber,status,description,expansionDate,organizationName);
    }
}
