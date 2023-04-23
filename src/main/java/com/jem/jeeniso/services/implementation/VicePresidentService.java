package com.jem.jeeniso.services.implementation;

import com.jem.jeeniso.dto.RoleDto;
import com.jem.jeeniso.dto.VicePresidentDto;
import com.jem.jeeniso.exception.EntityNotFoundException;
import com.jem.jeeniso.exception.InvalidOperationException;
import com.jem.jeeniso.model.Role;
import com.jem.jeeniso.model.VicePresident;
import com.jem.jeeniso.repository.IRoleRepository;
import com.jem.jeeniso.repository.IUserRepository;
import com.jem.jeeniso.repository.IVicePresidentRepository;
import com.jem.jeeniso.services.IVicePresidentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.jem.jeeniso.exception.ErrorMessages.USER_ALREADY_EXISTS;

@Service

public class VicePresidentService implements IVicePresidentService {
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private IVicePresidentRepository repository;
    @Autowired
    private IRoleRepository roleRepo ;
    @Override
    public VicePresidentDto save(VicePresidentDto dto) {
        boolean isExist = userRepository.existsByEmail(dto.getEmail());
        if (isExist) {
            throw new InvalidOperationException(USER_ALREADY_EXISTS);
        }
        Optional<Role> optionalRole = roleRepo.findByRoleName(dto.getRole().getRoleName());

        Role role = optionalRole.get();
        VicePresident vp =repository.save(VicePresident.builder()
                .firstname(dto.getFirstname())
                .lastname(dto.getLastname())
                .email(dto.getEmail())
                .photo(dto.getPhoto())
                .birthDate(dto.getBirthDate())
                .role(role)
                .build());
        return VicePresidentDto.builder()
                .firstname(vp.getFirstname())
                .lastname(vp.getLastname())
                .birthDate(vp.getBirthDate())
                .photo(vp.getPhoto())
                .email(vp.getEmail())
                .role(modelMapper.map(vp.getRole(), RoleDto.class))
                .build();
    }

    @Override
    public List<VicePresidentDto> findAll() {

        return repository.findAll().stream()
                .map((vicePresident-> modelMapper
                        .map(vicePresident, VicePresidentDto.class)))
                .collect(Collectors.toList());
    }

}
