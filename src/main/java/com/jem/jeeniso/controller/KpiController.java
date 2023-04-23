package com.jem.jeeniso.controller;

import com.jem.jeeniso.dto.CalendarDto;
import com.jem.jeeniso.dto.JuniorEntrepriseDto;
import com.jem.jeeniso.dto.KpiDto;
import com.jem.jeeniso.dto.MediaDto;
import com.jem.jeeniso.model.Kpi;
import com.jem.jeeniso.services.IJuniorEntrepriseService;
import com.jem.jeeniso.services.IKpiService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

import static com.jem.jeeniso.utils.Constants.KPI_ENDPOINT;

@RestController
@RequestMapping(KPI_ENDPOINT)
@Api(KPI_ENDPOINT)
public class KpiController {

    private IKpiService service ;
    @Autowired
    public KpiController(IKpiService service) {
        this.service = service;
    }


    @PostMapping(value = "/create",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    KpiDto save(@RequestBody Kpi Dto) {
        return service.save(Dto);
    }

    @GetMapping(value = "/findAll",
            produces = MediaType.APPLICATION_JSON_VALUE)
    List<KpiDto> findAll() {
        return service.findAll();
    }

    @DeleteMapping("/delete/{id}")
    void delete(@PathVariable Integer id) {
        service.delete(id);
    }

    @PatchMapping(value = "/update/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    void update(@PathVariable Integer id, String title, String value){ service.update(id,title,value);}

    @GetMapping(value = "/findByName/{id}")
    KpiDto findbyId(@PathVariable Integer id ){return service.findById(id);}

}
