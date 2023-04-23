package com.jem.jeeniso.services;

import com.jem.jeeniso.dto.PVDto;

import java.util.List;

public interface IPvService {
    PVDto save(PVDto Dto);

    List<PVDto> findAll();

}
