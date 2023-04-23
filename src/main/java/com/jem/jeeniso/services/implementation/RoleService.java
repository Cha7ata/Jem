package com.jem.jeeniso.services.implementation;

import com.jem.jeeniso.dto.RoleDto;
import com.jem.jeeniso.exception.InvalidOperationException;
import com.jem.jeeniso.model.Role;
import com.jem.jeeniso.repository.IRoleRepository;
import com.jem.jeeniso.services.IRoleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.jem.jeeniso.exception.ErrorMessages.ROLE_ALREADY_EXISTS;

@Service
public class RoleService implements IRoleService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private IRoleRepository repository;
    @Override
    public RoleDto save(RoleDto dto) {
        boolean isExist = repository.existsByroleName(dto.getRoleName());
        if (isExist) {
            throw new InvalidOperationException(ROLE_ALREADY_EXISTS);
        }
        return modelMapper
                .map(repository.save(modelMapper.map(dto, Role.class)), RoleDto.class);
    }


    @Override
    public List<RoleDto> findAll() {
        return repository.findAll().stream()
                .map((role-> modelMapper
                        .map(role, RoleDto.class)))
                .collect(Collectors.toList());
    }

}
