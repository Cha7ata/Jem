package com.jem.jeeniso.services;

import com.jem.jeeniso.dto.JuniorEntrepriseDto;

import java.util.List;

public interface IJuniorEntrepriseService {
    JuniorEntrepriseDto save(JuniorEntrepriseDto Dto);

    List<JuniorEntrepriseDto> findAll();

    void delete(Integer id);

    void update(Integer id, String name, String photo, String place, String email, String phoneNumber);

    JuniorEntrepriseDto findById(Integer id);
}
