package com.jem.jeeniso.services.implementation;

import com.jem.jeeniso.dto.HumanResourcesAndTrainingManagerDto;
import com.jem.jeeniso.dto.RoleDto;
import com.jem.jeeniso.exception.EntityNotFoundException;
import com.jem.jeeniso.exception.InvalidOperationException;
import com.jem.jeeniso.model.EvaluationGrid;
import com.jem.jeeniso.model.HumanResourcesAndTrainingManager;
import com.jem.jeeniso.model.Role;
import com.jem.jeeniso.repository.IEvaluationGridRepository;
import com.jem.jeeniso.repository.IHumanResourcesAndTrainingManagerRepository;
import com.jem.jeeniso.repository.IRoleRepository;
import com.jem.jeeniso.repository.IUserRepository;
import com.jem.jeeniso.services.IHumanResourcesAndTrainingManagerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.jem.jeeniso.exception.ErrorMessages.USER_ALREADY_EXISTS;


@Service
public class HumanResourcesAndTrainingManagerService implements IHumanResourcesAndTrainingManagerService {
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private IRoleRepository roleRepo ;
    @Autowired
    private IEvaluationGridRepository evaluationGridRepository;
    @Autowired
    private IHumanResourcesAndTrainingManagerRepository repository;
    @Override
    public HumanResourcesAndTrainingManagerDto save(HumanResourcesAndTrainingManagerDto dto) {
        boolean isExist = userRepository.existsByEmail(dto.getEmail());
        if (isExist) {
            throw new InvalidOperationException(USER_ALREADY_EXISTS);
        }

        Optional<Role> optionalRole = roleRepo.findByRoleName(dto.getRole().getRoleName());


        Optional<EvaluationGrid> optionalEvaluationGrid = evaluationGridRepository.findByMandate(dto.getEvaluationGrid().getMandate());

        Role role = optionalRole.get();
        EvaluationGrid evaluationGrid = optionalEvaluationGrid.get();
        HumanResourcesAndTrainingManager hRM = repository.save(HumanResourcesAndTrainingManager.builder()
                .firstname(dto.getFirstname())
                .lastname(dto.getLastname())
                .email(dto.getEmail())
                .photo(dto.getPhoto())
                .birthDate(dto.getBirthDate())
                .role(role)
                .build());
        return HumanResourcesAndTrainingManagerDto.builder()
                .firstname(hRM.getFirstname())
                .lastname(hRM.getLastname())
                .photo(hRM.getPhoto())
                .email(hRM.getEmail())
                .birthDate(hRM.getBirthDate())
                .role(modelMapper.map(hRM.getRole(), RoleDto.class))
                .build();
    }
    @Override
    public List<HumanResourcesAndTrainingManagerDto> findAll() {

        return repository.findAll().stream()
                .map((humanResourcesAndTrainingManager
                        -> modelMapper
                        .map(humanResourcesAndTrainingManager, HumanResourcesAndTrainingManagerDto.class)))
                .collect(Collectors.toList());
    }

}
