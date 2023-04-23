package com.jem.jeeniso.services;

import com.jem.jeeniso.dto.EvaluationGridDto;

import java.util.List;

public interface IEvaluationGridService {
    EvaluationGridDto save(EvaluationGridDto Dto);

    List<EvaluationGridDto> findAll();

}
