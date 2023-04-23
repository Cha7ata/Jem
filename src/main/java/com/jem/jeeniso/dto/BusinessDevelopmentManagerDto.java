package com.jem.jeeniso.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;
import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class BusinessDevelopmentManagerDto {

    private String firstname;

    private String lastname;

    private String email;

    private Date birthDate;

    private String photo;

    private RoleDto role ;

}
