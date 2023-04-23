package com.jem.jeeniso.services.implementation;

import com.jem.jeeniso.dto.*;
import com.jem.jeeniso.exception.EntityNotFoundException;
import com.jem.jeeniso.exception.InvalidOperationException;
import com.jem.jeeniso.model.Calendar;
import com.jem.jeeniso.model.Meeting;
import com.jem.jeeniso.model.Secretary;
import com.jem.jeeniso.model.enumeration.MeetingType;
import com.jem.jeeniso.repository.IMeetingRepository;
import com.jem.jeeniso.repository.ISecretaryRepository;
import com.jem.jeeniso.services.IMeetingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MeetingService implements IMeetingService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private IMeetingRepository repository;
    @Autowired
    private ISecretaryRepository secretaryRepository ;
    @Override
    public MeetingDto save(MeetingDto dto) {
        Optional<Secretary> optionalSecretary = secretaryRepository.findByEmail(dto.getSecretary().getEmail());

        Secretary sg = optionalSecretary.get();
        Meeting meeting =repository.save(Meeting.builder()
                        .date(dto.getDate())
                        .place(dto.getPlace())
                        .meetingType(dto.getMeetingType())
                        .secretary(sg)
                        .description(dto.getDescription())
                .build()
        );
        return MeetingDto.builder()
                .date(meeting.getDate())
                .description(meeting.getDescription())
                .place(meeting.getPlace())
                .meetingType(meeting.getMeetingType())
                .secretary(modelMapper.map(sg, SecretaryDto.class))
                .build();
    }

    @Override
    public List<MeetingDto> findAll() {


        return repository.findAll().stream()
                .map((meeting-> modelMapper
                        .map(meeting, MeetingDto.class)))
                .collect(Collectors.toList());
    }
    @Override
    public MeetingDto findById(Integer id) {
        return repository.findById(id).map((pole) -> modelMapper.map(pole, MeetingDto.class)).orElseThrow(
                () -> new EntityNotFoundException("not found " + id)
        );
    }

    @Override
    public void delete(Integer id) {
        MeetingDto dto = findById(id);
        if (dto == null) {
            throw new EntityNotFoundException("meeting not found");
        }
        repository.deleteById(id);
    }

    @Override
    public void update(Integer id, String place, String description, Date date, MeetingType meetingType) {

        Optional<Meeting> meeting = repository.findById(id);


        if (!meeting.isPresent()) {
            throw new InvalidOperationException("this calendar is already empty-_-");
        }
        Meeting meeting1 = meeting.get();
        meeting1.setPlace(place);
        meeting1.setDate(date);
        meeting1.setDescription(description);
        meeting1.setMeetingType(meetingType);

        repository.save(meeting1);

    }


}
