package com.jem.jeeniso.dto;

import com.jem.jeeniso.model.Member;
import com.jem.jeeniso.model.Project;
import com.jem.jeeniso.model.ProjectManager;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDto {

    private String name;

    private String description;

    private Date startDate;

    private Date deadLine;

    private String stat;

    private String clientName;

    private String clientEmail;

    private String clientPhoneNumber;

    private ProjectManagerDto projectManager;

    private List<MemberDto> members;


}