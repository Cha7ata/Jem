package com.jem.jeeniso.dto;


import com.jem.jeeniso.model.Trainer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class TrainerDto {

    private String name;

    private String institution;

    private String address;

    private String email;

    private String phoneNumber;

    private String field;

    private TrainingDto training ;


}
