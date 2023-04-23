package com.jem.jeeniso.services;

import com.jem.jeeniso.dto.UserDto;
import com.jem.jeeniso.model.User;

import java.util.List;

public interface IUserService {

    List<UserDto> findAll();

    UserDto findById(Integer id);

    UserDto save(UserDto dto);

}
