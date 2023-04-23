package com.jem.jeeniso.services;

import com.jem.jeeniso.dto.CalendarDto;
import com.jem.jeeniso.dto.KpiDto;
import com.jem.jeeniso.model.Kpi;

import java.util.List;

public interface IKpiService {

    KpiDto save(Kpi dto);

    List<KpiDto> findAll();

    void delete(Integer id);

    void update(Integer id, String title, String value);

    KpiDto findById(Integer id);
}
