package com.jem.jeeniso.services.implementation;

import com.jem.jeeniso.dto.HumanResourcesAndTrainingManagerDto;
import com.jem.jeeniso.dto.TrainingDto;
import com.jem.jeeniso.exception.EntityNotFoundException;
import com.jem.jeeniso.model.HumanResourcesAndTrainingManager;
import com.jem.jeeniso.model.Training;
import com.jem.jeeniso.repository.IHumanResourcesAndTrainingManagerRepository;
import com.jem.jeeniso.repository.ITrainingRepository;
import com.jem.jeeniso.services.ITrainingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TrainingService implements ITrainingService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ITrainingRepository repository;
    @Autowired
    private IHumanResourcesAndTrainingManagerRepository hRMRepository ;
    @Override
    public TrainingDto save(TrainingDto dto) {

        Optional<HumanResourcesAndTrainingManager> optionalhRM = hRMRepository.findByEmail(dto.getHumanResourcesAndTrainingManager().getEmail());

        HumanResourcesAndTrainingManager hRM = optionalhRM.get();
        Training training =repository.save(Training.builder()
                        .name(dto.getName())
                        .date(dto.getDate())
                        .description(dto.getDescription())
                        .place(dto.getPlace())
                        .trainerSatisfaction(dto.getTrainerSatisfaction())
                        .memberSatisfaction(dto.getMemberSatisfaction())
                        .price(dto.getPrice())
                        .humanResourcesAndTrainingManager(hRM)
                .build());
        return TrainingDto.builder()
                .name(training.getName())
                .date(training.getDate())
                .description(training.getDescription())
                .place(training.getPlace())
                .trainerSatisfaction(training.getTrainerSatisfaction())
                .memberSatisfaction(training.getMemberSatisfaction())
                .price(training.getPrice())
                .humanResourcesAndTrainingManager(modelMapper.map(training.getHumanResourcesAndTrainingManager(), HumanResourcesAndTrainingManagerDto.class))
                .build();
    }


    @Override
    public List<TrainingDto> findAll() {


        return repository.findAll().stream()
                .map((training-> modelMapper
                        .map(training, TrainingDto.class)))
                .collect(Collectors.toList());
    }

}
