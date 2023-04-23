package com.jem.jeeniso.services.implementation;

import antlr.BaseAST;
import com.jem.jeeniso.dto.RoleDto;
import com.jem.jeeniso.dto.UserDto;

import com.jem.jeeniso.exception.EntityNotFoundException;
import com.jem.jeeniso.exception.InvalidOperationException;

import com.jem.jeeniso.model.Role;
import com.jem.jeeniso.model.User;
import com.jem.jeeniso.repository.IRoleRepository;
import com.jem.jeeniso.repository.IUserRepository;
import com.jem.jeeniso.services.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.jem.jeeniso.exception.ErrorMessages.USER_ALREADY_EXISTS;


@Service
public class UserService implements IUserService {


    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private IRoleRepository roleRepo ;
    @Lazy
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll().stream()
                .map(user -> modelMapper
                        .map(user, UserDto.class))
                .collect(Collectors.toList());
    }


    @Override
    public UserDto findById(Integer id) {

        return userRepository.findById(id).map((user -> modelMapper.map(user, UserDto.class))).orElseThrow(
                () -> new EntityNotFoundException("user not found")
        );
    }

    @Override
    public UserDto save(UserDto dto) {

        boolean isExist = userRepository.existsByEmail(dto.getEmail());
        if (isExist) {
            throw new InvalidOperationException(USER_ALREADY_EXISTS);
        }
        Optional<Role> optionalRole = roleRepo.findByRoleName(dto.getRole().getRoleName());

        Role role = optionalRole.get();

        User user = userRepository.save(User.builder()
                .firstname(dto.getFirstname())
                .lastname(dto.getLastname())
                .email(dto.getEmail())
                .photo(dto.getPhoto())
                .password(passwordEncoder.encode(dto.getPassword()))
                .birthDate(dto.getBirthDate())
                .role(role)
                .build());
        return  UserDto.builder()
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .email(user.getEmail())
                .password(user.getPassword())
                .photo(user.getPhoto())
                .birthDate(user.getBirthDate())
                .role(modelMapper.map(user.getRole(), RoleDto.class))
                .build();

    }


}

