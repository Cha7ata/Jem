package com.jem.jeeniso.services.implementation;

import com.jem.jeeniso.dto.BusinessDevelopmentManagerDto;

import com.jem.jeeniso.dto.RoleDto;
import com.jem.jeeniso.exception.EntityNotFoundException;
import com.jem.jeeniso.exception.InvalidOperationException;
import com.jem.jeeniso.model.BusinessDevelopmentManager;
import com.jem.jeeniso.model.Role;
import com.jem.jeeniso.repository.IBusinessDevelopmentManagerRepository;
import com.jem.jeeniso.repository.IRoleRepository;
import com.jem.jeeniso.repository.IUserRepository;
import com.jem.jeeniso.services.IBusinessDevelopmentManagerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.jem.jeeniso.exception.ErrorMessages.USER_ALREADY_EXISTS;

@Service
public class BusinessDevelopmentManagerService implements IBusinessDevelopmentManagerService {

    @Autowired
    private IBusinessDevelopmentManagerRepository repository;
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private IRoleRepository roleRepo ;
    @Override
    public BusinessDevelopmentManagerDto save(BusinessDevelopmentManagerDto dto) {

            boolean isExist = userRepository.existsByEmail(dto.getEmail());
            if (isExist) {
                throw new InvalidOperationException(USER_ALREADY_EXISTS);
            }
             Optional<Role> optionalRole = roleRepo.findByRoleName(dto.getRole().getRoleName());

              Role role = optionalRole.get();


              BusinessDevelopmentManager businessDevelopmentManager = repository.save(BusinessDevelopmentManager.builder()
                             .firstname(dto.getFirstname())
                             .lastname(dto.getLastname())
                             .email(dto.getEmail())
                             .photo(dto.getPhoto())
                             .birthDate(dto.getBirthDate())
                              .role(role)
                     .build());
              return BusinessDevelopmentManagerDto.builder()
                      .firstname(businessDevelopmentManager.getFirstname())
                      .lastname(businessDevelopmentManager.getLastname())
                      .birthDate(businessDevelopmentManager.getBirthDate())
                      .photo(businessDevelopmentManager.getPhoto())
                      .email(businessDevelopmentManager.getEmail())
                      .role(modelMapper.map(businessDevelopmentManager.getRole(), RoleDto.class))
                      .build();

    }

    @Override
    public List<BusinessDevelopmentManagerDto> findAll() {

        return repository.findAll().stream()
                .map((businessDevelopmentManager -> modelMapper
                        .map(businessDevelopmentManager, BusinessDevelopmentManagerDto.class)))
                           .collect(Collectors.toList());
    }


}
