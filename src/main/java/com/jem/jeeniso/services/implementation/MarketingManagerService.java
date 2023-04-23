package com.jem.jeeniso.services.implementation;

import com.jem.jeeniso.dto.MarketingManagerDto;
import com.jem.jeeniso.dto.RoleDto;
import com.jem.jeeniso.exception.EntityNotFoundException;
import com.jem.jeeniso.exception.InvalidOperationException;
import com.jem.jeeniso.model.MarketingManager;
import com.jem.jeeniso.model.Role;
import com.jem.jeeniso.repository.IMarketingManagerRepository;
import com.jem.jeeniso.repository.IRoleRepository;
import com.jem.jeeniso.repository.IUserRepository;
import com.jem.jeeniso.services.IMarketingManagerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.jem.jeeniso.exception.ErrorMessages.USER_ALREADY_EXISTS;

@Service
public class MarketingManagerService implements IMarketingManagerService {
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private IMarketingManagerRepository repository;

    @Autowired
    private IRoleRepository roleRepo ;
    @Override
    public MarketingManagerDto save(MarketingManagerDto dto) {

        boolean isExist = userRepository.existsByEmail(dto.getEmail());
        if (isExist) {
            throw new InvalidOperationException(USER_ALREADY_EXISTS);
        }
        Optional<Role> optionalRole = roleRepo.findByRoleName(dto.getRole().getRoleName());

        Role role = optionalRole.get();
        MarketingManager marketingManager =repository.save( MarketingManager.builder()
                        .firstname(dto.getFirstname())
                        .lastname(dto.getLastname())
                        .birthDate(dto.getBirthDate())
                        .email(dto.getEmail())
                        .photo(dto.getPhoto())
                        .role(role)
                .build());
        return MarketingManagerDto.builder()
                .firstname(marketingManager.getFirstname())
                .lastname(marketingManager.getLastname())
                .photo(marketingManager.getPhoto())
                .email(marketingManager.getEmail())
                .role(modelMapper.map(marketingManager.getRole(), RoleDto.class))
                .build();
    }


    @Override
    public List<MarketingManagerDto> findAll() {

        return repository.findAll().stream()
                .map((marketingManager-> modelMapper
                        .map(marketingManager, MarketingManagerDto.class)))
                .collect(Collectors.toList());
    }


}
