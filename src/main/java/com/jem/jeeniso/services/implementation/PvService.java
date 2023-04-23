package com.jem.jeeniso.services.implementation;

import com.jem.jeeniso.dto.PVDto;
import com.jem.jeeniso.dto.SecretaryDto;
import com.jem.jeeniso.exception.EntityNotFoundException;
import com.jem.jeeniso.exception.InvalidOperationException;
import com.jem.jeeniso.model.PV;
import com.jem.jeeniso.model.Secretary;
import com.jem.jeeniso.repository.IPvRepository;
import com.jem.jeeniso.repository.ISecretaryRepository;
import com.jem.jeeniso.services.IPvService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.jem.jeeniso.exception.ErrorMessages.PV_ALREADY_EXISTS;

@Service
public class PvService implements IPvService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private IPvRepository repository;
    @Autowired
    private ISecretaryRepository secretaryRepository ;
    @Override
    public PVDto save(PVDto dto) {
        Optional<Secretary> optionalSecretary = secretaryRepository.findByEmail(dto.getSecretary().getEmail());

        Secretary sg = optionalSecretary.get();
        PV pv =repository.save(PV.builder()
                        .title(dto.getTitle())
                        .sujbect(dto.getSubject())
                        .date(dto.getDate())
                        .secretary(sg)
                .build());
        return PVDto.builder()
                .title(pv.getTitle())
                .subject(pv.getSujbect())
                .date(pv.getDate())
                .secretary(modelMapper.map(sg, SecretaryDto.class))
                .build();
    }

    @Override
    public List<PVDto> findAll() {
        return repository.findAll().stream()
                .map((pv-> modelMapper
                        .map(pv, PVDto.class)))
                .collect(Collectors.toList());
    }

}
