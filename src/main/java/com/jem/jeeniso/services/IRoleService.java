package com.jem.jeeniso.services;

import com.jem.jeeniso.dto.RoleDto;

import java.util.List;

public interface IRoleService {
    RoleDto save(RoleDto Dto);

    List<RoleDto> findAll();

}
