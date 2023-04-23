package com.jem.jeeniso.services.implementation;

import com.jem.jeeniso.dto.ProjectManagerDto;
import com.jem.jeeniso.dto.RoleDto;
import com.jem.jeeniso.exception.EntityNotFoundException;
import com.jem.jeeniso.exception.InvalidOperationException;
import com.jem.jeeniso.model.ProjectManager;
import com.jem.jeeniso.model.Role;
import com.jem.jeeniso.repository.IProjectManagerRepository;
import com.jem.jeeniso.repository.IRoleRepository;
import com.jem.jeeniso.repository.IUserRepository;
import com.jem.jeeniso.services.IProjectManagerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.jem.jeeniso.exception.ErrorMessages.USER_ALREADY_EXISTS;

@Service
public class ProjectManagerService implements IProjectManagerService {

    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private IProjectManagerRepository repository;
    @Autowired
    private IRoleRepository roleRepo ;
    @Override
    public ProjectManagerDto save(ProjectManagerDto dto) {


        boolean isExist = userRepository.existsByEmail(dto.getEmail());
        if (isExist) {
            throw new InvalidOperationException(USER_ALREADY_EXISTS);
        }
        Optional<Role> optionalRole = roleRepo.findByRoleName(dto.getRole().getRoleName());

        Role role = optionalRole.get();
        ProjectManager projectManager =repository.save(ProjectManager.builder()
                .firstname(dto.getFirstname())
                .lastname(dto.getLastname())
                .birthDate(dto.getBirthDate())
                .email(dto.getEmail())
                .photo(dto.getPhoto())
                .role(role)
                .build());
        return ProjectManagerDto.builder()
                .role(modelMapper.map(projectManager.getRole(), RoleDto.class))
                .firstname(projectManager.getFirstname())
                .lastname(projectManager.getLastname())
                .photo(projectManager.getPhoto())
                .email(projectManager.getEmail())
                .birthDate(projectManager.getBirthDate())
                .build();
    }

    @Override
    public List<ProjectManagerDto> findAll() {

        return repository.findAll().stream()
                .map((projectManager -> modelMapper
                        .map(projectManager, ProjectManagerDto.class)))
                .collect(Collectors.toList());

    }


}
