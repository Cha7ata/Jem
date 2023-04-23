package com.jem.jeeniso.services.implementation;

import com.jem.jeeniso.dto.MemberDto;
import com.jem.jeeniso.dto.ProjectDto;
import com.jem.jeeniso.dto.ProjectManagerDto;
import com.jem.jeeniso.exception.EntityNotFoundException;
import com.jem.jeeniso.exception.InvalidOperationException;
import com.jem.jeeniso.model.Member;
import com.jem.jeeniso.model.Project;
import com.jem.jeeniso.model.ProjectManager;
import com.jem.jeeniso.model.Role;
import com.jem.jeeniso.repository.IMemberRepository;
import com.jem.jeeniso.repository.IProjectManagerRepository;
import com.jem.jeeniso.repository.IProjectRepository;
import com.jem.jeeniso.services.IProjectService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.jem.jeeniso.exception.ErrorMessages.PROJECT_ALREADY_EXISTS;

@Service
public class ProjectService implements IProjectService {
    @Autowired
    private IProjectRepository repository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private IProjectManagerRepository projectManagerRepository;
    @Autowired
    private IMemberRepository memberRepository;
    @Override
    @Transactional
    public ProjectDto save(ProjectDto dto) {

        boolean isExist = repository.existsByName(dto.getName());
        if (isExist) {
            throw new InvalidOperationException(PROJECT_ALREADY_EXISTS);
        }
        Optional<ProjectManager> optionalProjectManager = projectManagerRepository.findByEmail(dto.getProjectManager().getEmail());

        ProjectManager projectManager = optionalProjectManager.get();

        Optional<Member> optionalMember;
        List<Member> membersL =new ArrayList<Member>();
        for (MemberDto member : dto.getMembers()
        ) {
            optionalMember = memberRepository.findByEmail(member.getEmail());

            Member memberL = optionalMember.get();
            membersL.add(memberL);
        }
        List<Member> members = membersL
                .stream()
                .map((memberDto ->modelMapper.map(memberDto,Member.class )))
                .collect(Collectors.toList());

        Project project = repository.save(Project.builder()
                .clientName(dto.getClientName())
                .clientEmail(dto.getClientEmail())
                .clientPhoneNumber(dto.getClientPhoneNumber())
                .deadLine(dto.getDeadLine())
                .name(dto.getName())
                .description(dto.getDescription())
                .startdate(dto.getStartDate())
                .stat(dto.getStat())
                .projectmanager(projectManager)
                .members(members)
                .build());


        List<MemberDto> memberDto = members
                .stream()
                .map((member ->modelMapper.map(member,MemberDto.class )))
                .collect(Collectors.toList());

        return ProjectDto.builder()
                .clientName(project.getClientName())
                .clientEmail(project.getClientEmail())
                .clientPhoneNumber(project.getClientPhoneNumber())
                .deadLine(project.getDeadLine())
                .name(project.getName())
                .description(project.getDescription())
                .startDate(project.getStartdate())
                .stat(project.getStat())
                .projectManager(modelMapper.map(projectManager, ProjectManagerDto.class))
                .members(memberDto)
                .build();
    }


    @Override
    public List<ProjectDto> findAll() {

        return repository.findAll().stream()
                .map((project-> modelMapper
                        .map(project, ProjectDto.class)))
                .collect(Collectors.toList());
    }


}
