package com.jem.jeeniso.services.implementation;

import com.jem.jeeniso.dto.TrainerDto;
import com.jem.jeeniso.dto.TrainingDto;
import com.jem.jeeniso.exception.EntityNotFoundException;
import com.jem.jeeniso.exception.InvalidOperationException;
import com.jem.jeeniso.model.HumanResourcesAndTrainingManager;
import com.jem.jeeniso.model.Trainer;
import com.jem.jeeniso.model.Training;
import com.jem.jeeniso.repository.ITrainerRepository;
import com.jem.jeeniso.repository.ITrainingRepository;
import com.jem.jeeniso.services.ITrainerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.jem.jeeniso.exception.ErrorMessages.TRAINER_ALREADY_EXISTS;

@Service
public class TrainerService implements ITrainerService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ITrainerRepository repository;
    @Autowired
    private ITrainingRepository trainingRepository;
    @Override
    public TrainerDto save(TrainerDto dto) {

        boolean isExist = repository.existsByEmail(dto.getEmail());
        if (isExist) {
            throw new InvalidOperationException(TRAINER_ALREADY_EXISTS);
        }
        Optional<Training> optionalTraining = trainingRepository.findByName(dto.getTraining().getName());

        Training training = optionalTraining.get();

        Trainer trainer =repository.save(Trainer.builder()
                        .name(dto.getName())
                        .email(dto.getEmail())
                        .address(dto.getAddress())
                        .phoneNumber(dto.getPhoneNumber())
                        .institution(dto.getInstitution())
                        .field(dto.getField())
                        .training(training)
                .build());
        return TrainerDto.builder()
                .name(trainer.getName())
                .email(trainer.getEmail())
                .address(trainer.getAddress())
                .phoneNumber(trainer.getPhoneNumber())
                .institution(trainer.getInstitution())
                .field(trainer.getField())
                .training(modelMapper.map(trainer.getTraining(), TrainingDto.class))
                .build();
    }

    @Override
    public List<TrainerDto> findAll() {

        return repository.findAll().stream()
                .map((trainer-> modelMapper
                        .map(trainer, TrainerDto.class)))
                .collect(Collectors.toList());
    }

}
