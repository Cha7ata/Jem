package com.jem.jeeniso.services;

import com.jem.jeeniso.dto.MarketingManagerDto;

import java.util.List;

public interface IMarketingManagerService {
    MarketingManagerDto save(MarketingManagerDto Dto);

    List<MarketingManagerDto> findAll();

}
