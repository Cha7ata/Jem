package com.jem.jeeniso.dto;


import com.jem.jeeniso.model.enumeration.Field;
import com.jem.jeeniso.model.enumeration.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PartnerDto {

    private String organizationName;

    private String description;

    private Date signatureDate;

    private Date expansionDate;

    private String manager;

    private String managerPhoneNumber;

    private Status status ;

    private Field field ;

    private VicePresidentDto vicePresident ;



}
