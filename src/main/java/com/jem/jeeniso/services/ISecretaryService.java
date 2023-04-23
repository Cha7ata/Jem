package com.jem.jeeniso.services;

import com.jem.jeeniso.dto.SecretaryDto;

import java.util.List;

public interface ISecretaryService {
    SecretaryDto save(SecretaryDto Dto);

    List<SecretaryDto> findAll();

}
