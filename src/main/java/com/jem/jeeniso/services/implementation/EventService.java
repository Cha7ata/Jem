package com.jem.jeeniso.services.implementation;

import com.jem.jeeniso.dto.EventDto;
import com.jem.jeeniso.dto.VicePresidentDto;
import com.jem.jeeniso.exception.EntityNotFoundException;
import com.jem.jeeniso.exception.InvalidOperationException;
import com.jem.jeeniso.model.Event;
import com.jem.jeeniso.model.VicePresident;
import com.jem.jeeniso.repository.IEventRepository;
import com.jem.jeeniso.repository.IVicePresidentRepository;
import com.jem.jeeniso.services.IEventService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.jem.jeeniso.exception.ErrorMessages.*;

@Service
public class EventService implements IEventService {
    @Autowired
    private ModelMapper modelMapper;
     @Autowired
    private IVicePresidentRepository viceRepo ;
    @Autowired
    private IEventRepository repository ;
    @Override
    public EventDto save(EventDto dto) {
        boolean NameExist = repository.existsByName(dto.getName());
        boolean DateExist = repository.existsByDate(dto.getDate());
        if (NameExist && DateExist)  {
            throw new InvalidOperationException(EVENT_ALREADY_EXISTS);
        }
        if (DateExist) {
            throw new InvalidOperationException(BUSY_EVENTDate);

        }
        Optional<VicePresident> optionalVicePresident =viceRepo.findByEmail(dto.getVicePresident().getEmail());

        VicePresident vp = optionalVicePresident.get();
        Event event = repository.save(
                Event.builder()
                        .eventType(dto.getEventType())
                        .place(dto.getPlace())
                        .date(dto.getDate())
                        .name(dto.getName())
                        .vicePresident(vp)
                        .build()
        );
        return  EventDto.builder()
                .name(event.getName())
                .place(event.getPlace())
                .date(event.getDate())
                .vicePresident(modelMapper.map(event.getVicePresident(), VicePresidentDto.class))
                .eventType(event.getEventType())
                .build();

    }


    @Override
    public List<EventDto> findAll() {

        return repository.findAll().stream()
                .map((event -> modelMapper
                        .map(event,EventDto.class)))
                .collect(Collectors.toList());
    }


}
