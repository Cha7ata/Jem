package com.jem.jeeniso.services;

import com.jem.jeeniso.dto.ProspectDto;
import com.jem.jeeniso.model.enumeration.Status;

import java.util.ArrayList;
import java.util.List;

public interface IProspectService {
    ProspectDto save(ProspectDto Dto);

    List<ProspectDto> findAll();
    void delete(String organisation);

    ProspectDto update(String responsableName, String phoneNumber, Status status , String address, String organizationName, String function, String email);

    ArrayList<ProspectDto> findListByStatus(Status status);
}
