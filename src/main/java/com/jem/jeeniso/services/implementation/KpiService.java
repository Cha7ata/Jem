package com.jem.jeeniso.services.implementation;

import com.jem.jeeniso.dto.KpiDto;
import com.jem.jeeniso.dto.MediaDto;
import com.jem.jeeniso.dto.MeetingDto;
import com.jem.jeeniso.exception.EntityNotFoundException;
import com.jem.jeeniso.exception.InvalidOperationException;
import com.jem.jeeniso.model.Calendar;
import com.jem.jeeniso.model.Kpi;
import com.jem.jeeniso.repository.IKpiRepository;
import com.jem.jeeniso.services.IKpiService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.jem.jeeniso.exception.ErrorMessages.KPI_NOT_FOUND_BY_NAME;


@Service
public class KpiService implements IKpiService {

    @Autowired
    private IKpiRepository repository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public KpiDto save(Kpi dto) {

        Kpi kpi =repository.save(dto.builder()
                .title(dto.getTitle())
                .value(dto.getValue())
                .build());

        return KpiDto.builder()
                .title(kpi.getTitle())
                .value(kpi.getValue())
                .build();
    }

    @Override
    public List<KpiDto> findAll() {
        return repository.findAll().stream()
                .map((kpi -> modelMapper
                        .map(kpi, KpiDto.class)))
                .collect(Collectors.toList());
    }
    @Override
    public void delete(Integer id) {
        KpiDto dto = findById(id);
        if (dto == null) {
            throw new EntityNotFoundException(KPI_NOT_FOUND_BY_NAME + id);
        }
        repository.deleteById(id);
    }

    @Override
    public void update(Integer id, String title, String value) {

        Optional<Kpi> kpi = repository.findById(id);

        if (!kpi.isPresent()) {
            throw new InvalidOperationException("this calendar is already empty-_-");
        }
        Kpi kpi1 = kpi.get();
        kpi1.setTitle(title);
        kpi1.setValue(value);

        repository.save(kpi1);

    }

    @Override
    public KpiDto findById(Integer id) {

        return repository.findById(id).map((media -> modelMapper.map(media, KpiDto.class))).orElseThrow(
                () -> new EntityNotFoundException("user not found")
        );
    }

}

