package com.jem.jeeniso.controller;

import com.jem.jeeniso.dto.TaskDto;
import com.jem.jeeniso.model.enumeration.AchievedStat;
import com.jem.jeeniso.model.enumeration.TaskType;
import com.jem.jeeniso.services.ITaskService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

import static com.jem.jeeniso.utils.Constants.TASK_ENDPOINT;

@RestController
@RequestMapping(TASK_ENDPOINT)
@Api(TASK_ENDPOINT)
public class TaskController {
    private ITaskService service;
    @Autowired
    public TaskController(ITaskService service) {
        this.service = service;
    }


    @PostMapping(value = "/create",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    TaskDto save(@RequestBody TaskDto Dto) {
        return service.save(Dto);
    }


    @GetMapping(value = "/findAll",
            produces = MediaType.APPLICATION_JSON_VALUE)
    List<TaskDto> findAll(){

        return service.findAll();
    }

    @DeleteMapping("/delete/{name}")
    void delete(@PathVariable String name) {
        service.delete(name);
    }

    @PatchMapping(value = "/update/{name}",produces = MediaType.APPLICATION_JSON_VALUE)
     void  update(@PathVariable Integer id, String name, String Description, Date assignementDate, Integer meritPoint, Date deadLine, TaskType taskType, AchievedStat achievedStat){
        service.update(name,Description,assignementDate,meritPoint,deadLine,taskType,achievedStat);}

    @GetMapping(value = "/findByName/{id}")
    TaskDto  findbyId(@PathVariable Integer id ){return service.findById(id);}


}
