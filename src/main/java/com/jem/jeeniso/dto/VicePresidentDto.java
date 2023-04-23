package com.jem.jeeniso.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VicePresidentDto {


    private String firstname;

    private String lastname;

    private String email;

    private Date birthDate;

    private String photo;

    private RoleDto role ;






}
