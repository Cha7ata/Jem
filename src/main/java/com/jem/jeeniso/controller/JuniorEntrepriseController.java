package com.jem.jeeniso.controller;

import com.jem.jeeniso.dto.JuniorEntrepriseDto;
import com.jem.jeeniso.model.JuniorEntreprise;
import com.jem.jeeniso.services.IJuniorEntrepriseService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.jem.jeeniso.utils.Constants.JUNIOR_ENTREPRISE_ENDPOINT;

@RestController
@RequestMapping(JUNIOR_ENTREPRISE_ENDPOINT)
@Api(JUNIOR_ENTREPRISE_ENDPOINT)
public class JuniorEntrepriseController {
    private IJuniorEntrepriseService service ;
    @Autowired
    public JuniorEntrepriseController(IJuniorEntrepriseService service) {
        this.service = service;
    }

    @PostMapping(value = "/create",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    JuniorEntrepriseDto save(@RequestBody JuniorEntrepriseDto Dto) {
        return service.save(Dto);
    }

    @GetMapping(value = "/findAll",
            produces = MediaType.APPLICATION_JSON_VALUE)
    List<JuniorEntrepriseDto> findAll() {
        return service.findAll();
    }

    @DeleteMapping("/delete/{id}")
    void delete(@PathVariable Integer id) {
        service.delete(id);
    }
    @PatchMapping(value = "/update/{id}")
    void update(@PathVariable Integer id, String name, String photo, String place, String email, String phoneNumber) {
        service.update(id, name,photo,place,email,phoneNumber);
    }

    @GetMapping(value = "/filterById/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    JuniorEntrepriseDto findById(@PathVariable Integer id) {
        return service.findById(id);
    }

}
