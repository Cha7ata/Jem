package com.jem.jeeniso.dto;

import com.jem.jeeniso.model.enumeration.MemberStatus;
import com.jem.jeeniso.model.Project;
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
public class MemberDto {


    private String firstname;

    private String Lastname;

    private String email;

    private Date birthDate;

    private String photo;

    private RoleDto role ;

    private MemberStatus status;


}
