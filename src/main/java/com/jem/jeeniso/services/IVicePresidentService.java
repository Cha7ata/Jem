package com.jem.jeeniso.services;

import com.jem.jeeniso.dto.VicePresidentDto;

import java.util.List;

public interface IVicePresidentService {
    VicePresidentDto save(VicePresidentDto Dto);

    List<VicePresidentDto> findAll();


}
