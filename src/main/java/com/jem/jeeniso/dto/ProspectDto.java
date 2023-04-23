package com.jem.jeeniso.dto;

import com.jem.jeeniso.model.enumeration.Field;
import com.jem.jeeniso.model.enumeration.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ProspectDto {

    private String organisationName;

    private String address;

    private String respnsableName;

    private String function;

    private String email;

    private String phoneNumber;

    private Status status ;

    private BusinessDevelopmentManagerDto businesslDevelopmentManager ;



}
