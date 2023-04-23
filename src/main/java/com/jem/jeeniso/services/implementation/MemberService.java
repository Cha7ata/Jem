package com.jem.jeeniso.services.implementation;

import com.jem.jeeniso.dto.MemberDto;
import com.jem.jeeniso.dto.RoleDto;
import com.jem.jeeniso.exception.InvalidOperationException;
import com.jem.jeeniso.model.Member;
import com.jem.jeeniso.model.Role;
import com.jem.jeeniso.repository.IMemberRepository;
import com.jem.jeeniso.repository.IRoleRepository;
import com.jem.jeeniso.repository.IUserRepository;
import com.jem.jeeniso.services.IMemberService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.jem.jeeniso.exception.ErrorMessages.USER_ALREADY_EXISTS;

@Service
public class MemberService implements IMemberService {
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private IMemberRepository repository;
    @Autowired
    private IRoleRepository roleRepo ;

    @Override
    public MemberDto save(MemberDto dto) {

        boolean isExist = userRepository.existsByEmail(dto.getEmail());
        if (isExist) {
            throw new InvalidOperationException(USER_ALREADY_EXISTS);
        }
        Optional<Role> optionalRole =roleRepo.findByRoleName("Unknown");
        Role role = optionalRole.get();
        Member member =repository.save(Member.builder()
                .firstname(dto.getFirstname())
                .lastname(dto.getLastname())
                .birthDate(dto.getBirthDate())
                .email(dto.getEmail())
                .photo(dto.getPhoto())
                .role(role)
                .build());

        return MemberDto.builder()
                .firstname(member.getFirstname())
                .Lastname(member.getLastname())
                .birthDate(member.getBirthDate())
                .email(member.getEmail())
                .photo(dto.getPhoto())
                .role(modelMapper.map(role, RoleDto.class))
                .build();
    }

    @Override
    public List<MemberDto> findAll() {
        return repository.findAll().stream()
                .map((member-> modelMapper
                        .map(member, MemberDto.class)))
                .collect(Collectors.toList());
    }

}
