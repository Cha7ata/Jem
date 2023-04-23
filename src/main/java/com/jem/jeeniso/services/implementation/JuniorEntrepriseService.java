package com.jem.jeeniso.services.implementation;

import com.jem.jeeniso.dto.*;
import com.jem.jeeniso.exception.EntityNotFoundException;
import com.jem.jeeniso.exception.InvalidOperationException;
import com.jem.jeeniso.model.JuniorEntreprise;
import com.jem.jeeniso.model.Secretary;
import com.jem.jeeniso.repository.IJuniorEntrepriseRepository;
import com.jem.jeeniso.repository.ISecretaryRepository;
import com.jem.jeeniso.services.IJuniorEntrepriseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.jem.jeeniso.exception.ErrorMessages.*;

@Service
public class JuniorEntrepriseService implements IJuniorEntrepriseService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private IJuniorEntrepriseRepository repository;

    @Autowired
    private ISecretaryRepository secretaryRepository ;
    @Override
    public JuniorEntrepriseDto save(JuniorEntrepriseDto dto) {

        boolean isExist = repository.existsByName(dto.getName());
        if (isExist) {
            throw new InvalidOperationException(JUNIORENTREPRISE_ALREADY_EXISTS);
        }
        Optional<Secretary> optionalSecretary = secretaryRepository.findByEmail(dto.getSecretary().getEmail());

        Secretary sg = optionalSecretary.get();

        JuniorEntreprise je= repository.save(JuniorEntreprise.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .place(dto.getPlace())
                .secretary(sg)
                .phoneNumber(dto.getPhoneNumber())
                .picture(dto.getPhoto())

                .build());


        return JuniorEntrepriseDto.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .place(dto.getPlace())
                .secretary(modelMapper.map(sg, SecretaryDto.class))
                .phoneNumber(dto.getPhoneNumber())
                .photo(dto.getPhoto())
                .build();
    }


    @Override
    public List<JuniorEntrepriseDto> findAll() {

        return repository.findAll().stream()
                .map((juniorEntreprise-> modelMapper
                        .map(juniorEntreprise, JuniorEntrepriseDto.class)))
                .collect(Collectors.toList());

    }

    @Override
    public void delete(Integer id) {
        JuniorEntrepriseDto dto = findById(id);
        if (dto == null) {
            throw new EntityNotFoundException(CALENDAR_NOT_FOUND_BY_NAME + id);
        }
        repository.deleteById(id);
    }

    @Override
    public void update(Integer id, String name, String photo, String place, String email, String phoneNumber) {

        Optional<JuniorEntreprise> optionalJuniorEntreprise = repository.findById(id);
        System.out.println(name);

        if (!optionalJuniorEntreprise.isPresent()) {
            throw new InvalidOperationException("this junior entreprise is already empty-_-");
        }
        System.out.println("------------------------");
        System.out.println("--------------------------");
        System.out.println("------------------------");
        JuniorEntreprise juniorEntreprise = optionalJuniorEntreprise.get();
        juniorEntreprise.setName(name);
        juniorEntreprise.setPicture(photo);
        juniorEntreprise.setPlace(place);
        juniorEntreprise.setEmail(email);
        juniorEntreprise.setPhoneNumber(phoneNumber);

        repository.save(juniorEntreprise);

    }


    @Override
    public JuniorEntrepriseDto findById(Integer id) {

        return repository.findById(id).map((je -> modelMapper.map(je, JuniorEntrepriseDto.class))).orElseThrow(
                () -> new EntityNotFoundException("user not found")
        );
    }

}
