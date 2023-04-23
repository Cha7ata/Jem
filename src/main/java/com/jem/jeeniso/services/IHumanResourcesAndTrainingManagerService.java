package com.jem.jeeniso.services;

import com.jem.jeeniso.dto.HumanResourcesAndTrainingManagerDto;

import java.util.List;

public interface IHumanResourcesAndTrainingManagerService {
    HumanResourcesAndTrainingManagerDto save(HumanResourcesAndTrainingManagerDto Dto);


    List<HumanResourcesAndTrainingManagerDto> findAll();

}
