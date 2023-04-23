package com.jem.jeeniso.services;


import com.jem.jeeniso.dto.ExternalManagerDto;

import java.util.List;

public interface IExternalManagerService {
   ExternalManagerDto save(ExternalManagerDto Dto);

    List<ExternalManagerDto> findAll();

}
