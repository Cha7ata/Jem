package com.jem.jeeniso.services.implementation;

import com.jem.jeeniso.dto.BusinessDevelopmentManagerDto;
import com.jem.jeeniso.dto.ProspectDto;
import com.jem.jeeniso.exception.EntityNotFoundException;
import com.jem.jeeniso.exception.InvalidOperationException;
import com.jem.jeeniso.model.BusinessDevelopmentManager;
import com.jem.jeeniso.model.Prospect;
import com.jem.jeeniso.model.enumeration.Status;
import com.jem.jeeniso.repository.IBusinessDevelopmentManagerRepository;
import com.jem.jeeniso.repository.IProspectRepository;
import com.jem.jeeniso.services.IProspectService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.jem.jeeniso.exception.ErrorMessages.PROSPECT_ALREADY_EXISTS;
import static com.jem.jeeniso.exception.ErrorMessages.PROSPECT_NOT_FOUND_BY_OrganizationName;

@Service
public class ProspectService implements IProspectService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private IProspectRepository repository;
    @Autowired
    private IBusinessDevelopmentManagerRepository  businessDevelopmentManagerRepository ;
    @Override
    public ProspectDto save(ProspectDto dto) {
        boolean isExist = repository.existsByOrganisationName(dto.getOrganisationName());
        if (isExist) {
            throw new InvalidOperationException(PROSPECT_ALREADY_EXISTS);
        }

        Optional<BusinessDevelopmentManager> optionalBusinessDevelopmentManager = businessDevelopmentManagerRepository.findByEmail(dto.getBusinesslDevelopmentManager().getEmail());

        BusinessDevelopmentManager businessDevelopmentManager = optionalBusinessDevelopmentManager.get();

        Prospect prospect =repository.save(Prospect.builder()
                .businesslDevelopmentManager(businessDevelopmentManager)
                .address(dto.getAddress())
                .email(dto.getEmail())
                .function(dto.getFunction())
                .respnsableName(dto.getRespnsableName())
                .organisationName(dto.getOrganisationName())
                .status(dto.getStatus())
                .phoneNumber(dto.getPhoneNumber())
                .build());

        return ProspectDto.builder()
                .businesslDevelopmentManager(modelMapper.map(prospect.getBusinesslDevelopmentManager(), BusinessDevelopmentManagerDto.class))
                .address(prospect.getAddress())
                .email(prospect.getEmail())
                .function(prospect.getFunction())
                .respnsableName(prospect.getRespnsableName())
                .organisationName(prospect.getOrganisationName())
                .status(prospect.getStatus())
                .phoneNumber(prospect.getPhoneNumber())
                .build();
    }

    @Override
    public List<ProspectDto> findAll() {
        return repository.findAll().stream()
                .map((prospect-> modelMapper
                        .map(prospect, ProspectDto.class)))
                .collect(Collectors.toList());
    }


    @Override
    public void delete(String organisation) {
        Optional<Prospect> optionalProspect = repository.findByOrganisationName(organisation);
        Prospect prospect =optionalProspect.get();
        if (optionalProspect.isEmpty()){
            throw new EntityNotFoundException(PROSPECT_NOT_FOUND_BY_OrganizationName);
        }
        repository.delete(prospect);

    }

    @Override
    public ProspectDto update(String responsableName, String phoneNumber, Status status , String address,String organizationName,String function,String email) {
        Optional<Prospect> optionalProspect = repository.findByOrganisationName(organizationName);

        Prospect prospect = optionalProspect.get();
        if (optionalProspect.isEmpty()) {
            throw new EntityNotFoundException (PROSPECT_NOT_FOUND_BY_OrganizationName);
        }


        prospect.setAddress(address);
        prospect.setEmail(email);
        prospect.setFunction(function);
        prospect.setOrganisationName(organizationName);
        prospect.setPhoneNumber(phoneNumber);
        prospect.setRespnsableName(responsableName);
        prospect.setStatus(status);
        repository.save(prospect);
        return modelMapper.map(prospect,ProspectDto.class);
    }

    @Override
    public ArrayList<ProspectDto> findListByStatus(Status status) {
        ArrayList<ProspectDto> listProspect = new ArrayList<ProspectDto>();
        for (ProspectDto prospect : findAll()) {
            if (prospect.getStatus()==status) {
                listProspect.add(prospect);
            }
        }
        return listProspect;
    }


}
