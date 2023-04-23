package com.jem.jeeniso.services;

import com.jem.jeeniso.dto.TrainingDto;

import java.util.List;

public interface ITrainingService {

    TrainingDto save(TrainingDto Dto);

    List<TrainingDto> findAll();

}
