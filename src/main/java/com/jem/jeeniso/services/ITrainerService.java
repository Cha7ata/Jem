package com.jem.jeeniso.services;

import com.jem.jeeniso.dto.TrainerDto;

import java.util.List;

public interface ITrainerService {
    TrainerDto save(TrainerDto Dto);

    List<TrainerDto> findAll();


}
