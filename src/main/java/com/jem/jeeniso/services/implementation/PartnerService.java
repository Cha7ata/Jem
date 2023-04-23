package com.jem.jeeniso.services.implementation;

import com.jem.jeeniso.dto.MeetingDto;
import com.jem.jeeniso.dto.PartnerDto;
import com.jem.jeeniso.dto.TaskDto;
import com.jem.jeeniso.dto.VicePresidentDto;
import com.jem.jeeniso.exception.EntityNotFoundException;
import com.jem.jeeniso.exception.InvalidOperationException;
import com.jem.jeeniso.model.Partner;

import com.jem.jeeniso.model.VicePresident;
import com.jem.jeeniso.model.enumeration.Status;
import com.jem.jeeniso.repository.IPartnerRepository;
import com.jem.jeeniso.repository.IVicePresidentRepository;
import com.jem.jeeniso.services.IPartnerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.jem.jeeniso.exception.ErrorMessages.*;


@Service
public class PartnerService implements IPartnerService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private IPartnerRepository repository;
    @Autowired
    private IVicePresidentRepository viceRepo;

    @Override
    public PartnerDto save(PartnerDto dto) {
        boolean isExist = repository.existsByOrganizationName(dto.getOrganizationName());
        if (isExist) {
            throw new InvalidOperationException(PARTNER_ALREADY_EXISTS);
        }

        Optional<VicePresident> optionalVicePresident = viceRepo.findByEmail(dto.getVicePresident().getEmail());

        VicePresident vp = optionalVicePresident.get();

        Partner partner = repository.save(Partner.builder()
                .organizationName(dto.getOrganizationName())
                .description(dto.getDescription())
                .signatureDate(dto.getSignatureDate())
                .expansionDate(dto.getExpansionDate())
                .manager(dto.getManager())
                .managerphonenumber(dto.getManagerPhoneNumber())
                .field(dto.getField())
                .status(dto.getStatus())
                .vicePresident(vp)
                .build());
        return PartnerDto.builder()
                .organizationName(partner.getOrganizationName())
                .description(partner.getDescription())
                .signatureDate(partner.getSignatureDate())
                .expansionDate(partner.getExpansionDate())
                .manager(partner.getManager())
                .managerPhoneNumber(partner.getManagerphonenumber())
                .field(partner.getField())
                .status(partner.getStatus())
                .vicePresident(modelMapper.map(partner.getVicePresident(), VicePresidentDto.class))
                .build();
    }


    @Override
    public List<PartnerDto> findAll() {

        return repository.findAll().stream()
                .map((partner -> modelMapper
                        .map(partner, PartnerDto.class)))
                .collect(Collectors.toList());
    }

    @Override
    public ArrayList<PartnerDto> findListByStatus(Status status) {
        ArrayList<PartnerDto> listPartners = new ArrayList<PartnerDto>();
        for (PartnerDto partner : findAll()) {
            if (partner.getStatus().equals(status)) {
                listPartners.add(partner);
            }
        }
        return listPartners;
    }


    @Override
    public void delete(String organisation) {
       Optional<Partner> optionalPartner = repository.findByOrganizationName(organisation);
       Partner partner =optionalPartner.get();
       if (optionalPartner.isEmpty()){
           throw new EntityNotFoundException(PARTNER_NOT_FOUND_BY_OrganizationName);
       }
       repository.delete(partner);

    }


    @Override
    public PartnerDto update(String manager, String managerPhoneNumber, Status status , String description, Date expansionDate, String organizationName) {
        Optional<Partner> optionalPartner = repository.findByOrganizationName(organizationName);


        Partner partner = optionalPartner.get();
        if (optionalPartner.isEmpty()) {
            throw new EntityNotFoundException (PARTNER_NOT_FOUND_BY_OrganizationName);
        }

        partner.setOrganizationName(organizationName);
        partner.setDescription(description);
        partner.setExpansionDate(expansionDate);
        partner.setManager(manager);
        partner.setManagerphonenumber(managerPhoneNumber);
        partner.setStatus(status);

        repository.save(partner);
        return modelMapper.map(partner,PartnerDto.class);

    }


}
