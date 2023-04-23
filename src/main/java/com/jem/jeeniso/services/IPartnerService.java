package com.jem.jeeniso.services;

import com.jem.jeeniso.dto.PartnerDto;
import com.jem.jeeniso.model.enumeration.Status;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface IPartnerService {
    PartnerDto save(PartnerDto Dto);


    ArrayList<PartnerDto> findListByStatus(Status status);

    List<PartnerDto> findAll();

    void delete(String organisation);


    PartnerDto update(String manager, String managerPhoneNumber, Status status , String description, Date expansionDate, String organizationName);
}
