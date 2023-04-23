package com.jem.jeeniso.services;

import com.jem.jeeniso.dto.BusinessDevelopmentManagerDto;

import java.util.List;

public interface IBusinessDevelopmentManagerService {
    BusinessDevelopmentManagerDto save(BusinessDevelopmentManagerDto dto);

    List<BusinessDevelopmentManagerDto> findAll();

}
