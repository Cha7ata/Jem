package com.jem.jeeniso.services.implementation;

import com.jem.jeeniso.dto.ExternalManagerDto;
import com.jem.jeeniso.dto.RoleDto;
import com.jem.jeeniso.exception.EntityNotFoundException;
import com.jem.jeeniso.exception.InvalidOperationException;
import com.jem.jeeniso.model.ExternalManager;
import com.jem.jeeniso.model.Role;
import com.jem.jeeniso.repository.IExternalManagerRepository;
import com.jem.jeeniso.repository.IRoleRepository;
import com.jem.jeeniso.repository.IUserRepository;
import com.jem.jeeniso.services.IExternalManagerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import static com.jem.jeeniso.exception.ErrorMessages.USER_ALREADY_EXISTS;

@Service
public class ExternalManagerService implements IExternalManagerService {
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private IExternalManagerRepository repository;
    @Autowired
    private IRoleRepository roleRepo ;
    @Transactional
    @Override
    public ExternalManagerDto save(ExternalManagerDto dto) {

        boolean isExist = userRepository.existsByEmail(dto.getEmail());

        if (isExist) {
            throw new InvalidOperationException(USER_ALREADY_EXISTS);
        }
        Optional<Role> optionalRole = roleRepo.findByRoleName(dto.getRole().getRoleName());

        Role role = optionalRole.get();
        ExternalManager externalManager = new ExternalManager();
        externalManager.setFirstname(dto.getFirstname());
        externalManager.setLastname(dto.getLastname());
        externalManager.setEmail(dto.getEmail());
        externalManager.setBirthDate(dto.getBirthDate());
        externalManager.setPhoto(dto.getPhoto());
        externalManager.setRole(role);
        ExternalManager ext = repository.save(externalManager);
        return ExternalManagerDto.builder()
                .birthDate(ext.getBirthDate())
                .firstname(ext.getFirstname())
                .lastname(ext.getLastname())
                .email(ext.getEmail())
                .role(modelMapper.map(ext.getRole(), RoleDto.class))
                .photo(ext.getPhoto())
                .build();

    }


    @Override
    public List<ExternalManagerDto> findAll() {

        return repository.findAll().stream()
                .map((externalManager-> modelMapper
                        .map(externalManager, ExternalManagerDto.class)))
                .collect(Collectors.toList());
    }


}
