package com.jem.jeeniso.services.implementation;


import com.jem.jeeniso.dto.EvaluationGridDto;
import com.jem.jeeniso.exception.InvalidOperationException;
import com.jem.jeeniso.model.EvaluationGrid;
import com.jem.jeeniso.model.User;
import com.jem.jeeniso.repository.IEvaluationGridRepository;
import com.jem.jeeniso.services.IEvaluationGridService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.jem.jeeniso.exception.ErrorMessages.EVALUATIONGRID_ALREADY_EXISTS;
import static com.jem.jeeniso.exception.ErrorMessages.USER_ALREADY_EXISTS;

@Service
public class EvaluationGridService implements IEvaluationGridService {
    @Autowired
    private IEvaluationGridRepository repository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public EvaluationGridDto save(EvaluationGridDto Dto) {

        boolean isExist = repository.existsByMandate(Dto.getMandate());
        if (isExist) {
            throw new InvalidOperationException(EVALUATIONGRID_ALREADY_EXISTS);
        }
        return modelMapper
                .map(repository.save(modelMapper.map(Dto, EvaluationGrid.class)), EvaluationGridDto.class);
    }


    @Override
    public List<EvaluationGridDto> findAll() {

        return repository.findAll().stream()
                .map((evaluationGrid -> modelMapper
                        .map(evaluationGrid, EvaluationGridDto.class)))
                .collect(Collectors.toList());
    }


}
