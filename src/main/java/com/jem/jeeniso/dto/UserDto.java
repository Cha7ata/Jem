package com.jem.jeeniso.dto;


import com.jem.jeeniso.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private String firstname;

    private String lastname;

    private String email;

    private String password;

    private Date birthDate;

    private String photo;

    private RoleDto role;


}