package com.jem.jeeniso.dto;


import com.jem.jeeniso.model.Secretary;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class SecretaryDto {


    private String firstname;

    private String lastname;

    private String email;

    private Date birthDate;

    private String photo;

    private RoleDto role;





}
