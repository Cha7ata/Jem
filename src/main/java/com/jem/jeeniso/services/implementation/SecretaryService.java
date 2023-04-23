package com.jem.jeeniso.services.implementation;

import com.jem.jeeniso.dto.RoleDto;
import com.jem.jeeniso.dto.SecretaryDto;
import com.jem.jeeniso.exception.EntityNotFoundException;
import com.jem.jeeniso.exception.InvalidOperationException;
import com.jem.jeeniso.model.Role;
import com.jem.jeeniso.model.Secretary;
import com.jem.jeeniso.repository.IRoleRepository;
import com.jem.jeeniso.repository.ISecretaryRepository;
import com.jem.jeeniso.repository.IUserRepository;
import com.jem.jeeniso.services.ISecretaryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.jem.jeeniso.exception.ErrorMessages.USER_ALREADY_EXISTS;

@Service
public class SecretaryService implements ISecretaryService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ISecretaryRepository repository;
    @Autowired
    private IRoleRepository roleRepo ;
    @Override
    public SecretaryDto save(SecretaryDto dto) {
        boolean isExist = repository.existsByEmail(dto.getEmail());
        if (isExist) {
            throw new InvalidOperationException(USER_ALREADY_EXISTS);
        }
        Optional<Role> optionalRole = roleRepo.findByRoleName(dto.getRole().getRoleName());

        Role role = optionalRole.get();
        Secretary sg = repository.save(Secretary.builder()
                .firstname(dto.getFirstname())
                .lastname(dto.getLastname())
                .email(dto.getEmail())
                .photo(dto.getPhoto())
                .birthDate(dto.getBirthDate())
                .role(role)
                .build());
        return  SecretaryDto.builder()
                .firstname(dto.getFirstname())
                .lastname(dto.getLastname())
                .email(dto.getEmail())
                .photo(dto.getPhoto())
                .birthDate(dto.getBirthDate())
                .role(modelMapper.map(sg.getRole(), RoleDto.class))
                .build();

    }


    @Override
    public List<SecretaryDto> findAll() {

        return repository.findAll().stream()
                .map((secretary-> modelMapper
                        .map(secretary, SecretaryDto.class)))
                .collect(Collectors.toList());
    }

}
