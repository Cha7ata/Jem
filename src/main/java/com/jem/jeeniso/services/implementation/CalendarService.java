package com.jem.jeeniso.services.implementation;

import com.jem.jeeniso.dto.*;
import com.jem.jeeniso.exception.EntityNotFoundException;
import com.jem.jeeniso.exception.InvalidOperationException;
import com.jem.jeeniso.model.Calendar;
import com.jem.jeeniso.model.Media;
import com.jem.jeeniso.repository.ICalendarRepository;
import com.jem.jeeniso.services.ICalendarService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.jem.jeeniso.exception.ErrorMessages.*;

@Service
public class CalendarService implements ICalendarService {


    @Autowired
    private ICalendarRepository repository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CalendarDto save(CalendarDto dto) {

        Calendar calendar =repository.save(Calendar.builder()
                .name(dto.getName())
                .date(dto.getDate())
                .description(dto.getDescription())
                .build());

        return CalendarDto.builder()
                .name(calendar.getName())
                .date(calendar.getDate())
                .description(calendar.getDescription())
                .build();
    }

    @Override
    public List<CalendarDto> findAll() {
        return repository.findAll().stream()
                .map((Calendar -> modelMapper
                        .map(Calendar, CalendarDto.class)))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        CalendarDto dto = findById(id);
        if (dto == null) {
            throw new EntityNotFoundException(CALENDAR_NOT_FOUND_BY_NAME + id);
        }
        repository.deleteById(id);
    }

    @Override
    public void update(Integer id, String name, String description, Date date) {

        Optional<Calendar> calendar = repository.findById(id);
        System.out.println(name);

        if (!calendar.isPresent()) {
            throw new InvalidOperationException("this calendar is already empty-_-");
        }
        Calendar calendar1 = calendar.get();
        calendar1.setName(name);
        calendar1.setDate(date);
        calendar1.setDescription(description);

        repository.save(calendar1);

    }



    @Override
    public CalendarDto findById(Integer id) {

        return repository.findById(id).map((calendar -> modelMapper.map(calendar, CalendarDto.class))).orElseThrow(
                () -> new EntityNotFoundException("user not found")
        );
    }
}
