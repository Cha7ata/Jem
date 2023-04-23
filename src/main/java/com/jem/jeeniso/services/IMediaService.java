package com.jem.jeeniso.services;

import com.jem.jeeniso.dto.MediaDto;

import java.util.List;

public interface IMediaService {
    MediaDto save(MediaDto Dto);

    List<MediaDto> findAll();

    void delete(Integer id);

    void update(Integer id, String name, String email, String phoneNumber, String address);

    MediaDto findById(Integer id);
}
