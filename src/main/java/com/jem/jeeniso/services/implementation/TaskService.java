package com.jem.jeeniso.services.implementation;

import com.jem.jeeniso.dto.EvaluationGridDto;
import com.jem.jeeniso.dto.PartnerDto;
import com.jem.jeeniso.dto.SecretaryDto;
import com.jem.jeeniso.dto.TaskDto;
import com.jem.jeeniso.exception.EntityNotFoundException;
import com.jem.jeeniso.exception.InvalidOperationException;
import com.jem.jeeniso.model.*;
import com.jem.jeeniso.model.enumeration.AchievedStat;
import com.jem.jeeniso.model.enumeration.Status;
import com.jem.jeeniso.model.enumeration.TaskType;
import com.jem.jeeniso.repository.IEvaluationGridRepository;
import com.jem.jeeniso.repository.ISecretaryRepository;
import com.jem.jeeniso.repository.ITaskRepository;
import com.jem.jeeniso.services.ITaskService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.jem.jeeniso.exception.ErrorMessages.*;

@Service
public class TaskService implements ITaskService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ITaskRepository repository;
    @Autowired
    private ISecretaryRepository secretaryRepository ;
    @Autowired
    private IEvaluationGridRepository evaluationGridRepository;

    @Override
    public TaskDto save(TaskDto dto) {

        boolean isExist = repository.existsByName(dto.getName());
        if (isExist) {
            throw new InvalidOperationException(TASK_ALREADY_EXISTS);
        }
        Optional<Secretary> optionalSecretary = secretaryRepository.findByEmail(dto.getSecretary().getEmail());

        Secretary sg = optionalSecretary.get();
        Optional<EvaluationGrid> optionalEvaluationGrid = evaluationGridRepository.findByMandate(dto.getEvaluationGrid().getMandate());

        EvaluationGrid evaluationGrid = optionalEvaluationGrid.get();
        Task task =repository.save(Task.builder()
                        .name(dto.getName())
                        .achievedStat(dto.getAchievedStat())
                        .secretary(sg)
                        .evaluationGrid(evaluationGrid)
                        .taskType(dto.getTaskType())
                        .Description(dto.getDescription())
                        .deadLine(dto.getDeadline())
                        .assignementDate(dto.getAssignementDate())
                        .meritPoint(dto.getMeritPoint())
                .build());
        return TaskDto.builder()
                .name(dto.getName())
                .achievedStat(dto.getAchievedStat())
                .secretary(modelMapper.map(sg, SecretaryDto.class))
                .evaluationGrid(modelMapper.map(evaluationGrid, EvaluationGridDto.class))
                .taskType(dto.getTaskType())
                .description(dto.getDescription())
                .deadline(dto.getDeadline())
                .assignementDate(dto.getAssignementDate())
                .meritPoint(dto.getMeritPoint())
                .build();
    }

    @Override
    public List<TaskDto> findAll() {

        return repository.findAll().stream()
                .map((task-> modelMapper
                        .map(task, TaskDto.class)))
                .collect(Collectors.toList());
    }
    @Override
    public TaskDto findById(Integer id) {
        return repository.findById(id).map((pole) -> modelMapper.map(pole, TaskDto.class)).orElseThrow(
                () -> new EntityNotFoundException("not found " + id)
        );
    }

    @Override
    public void delete(String name) {
        Optional<Task> optionalTask = repository.findByName(name);
        Task task =optionalTask.get();
        if (task == null) {
            throw new EntityNotFoundException(TASK_NOT_FOUND + name);
        }
        repository.delete(task);
    }

    @Override
    public TaskDto findByname(String name) {
        TaskDto task = new TaskDto();
        for (TaskDto taskdto : findAll()) {
            if (taskdto.getName().equals(name)) {
                task= taskdto;
                ;
            }
        }
        return task;
    }

    @Override
    public void update( String name, String Description, Date assignementDate, Integer meritPoint, Date deadLine, TaskType taskType, AchievedStat achievedStat) {

        Optional<Task> task = repository.findByName(name);
        System.out.println(name);

        if (!task.isPresent()) {
            throw new InvalidOperationException("this calendar is already empty-_-");
        }

        Task task1 = task.get();
        task1.setName(name);
        task1.setDeadLine(deadLine);
        task1.setDescription(Description);
        task1.setTaskType(taskType);
        task1.setAchievedStat(achievedStat);
        task1.setAssignementDate(assignementDate);

        repository.save(task1);

    }
}
