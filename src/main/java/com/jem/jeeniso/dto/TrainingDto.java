package com.jem.jeeniso.dto;


import com.jem.jeeniso.model.Training;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;
import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class TrainingDto {

    private String name;

    private String place;

    private String description;

    private Date date;

    private Integer trainerSatisfaction ;

    private Integer memberSatisfaction ;

    private BigDecimal price;

    private HumanResourcesAndTrainingManagerDto humanResourcesAndTrainingManager ;



}
