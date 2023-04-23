package com.jem.jeeniso.dto;

import com.jem.jeeniso.model.EvaluationGrid;
import com.jem.jeeniso.model.enumeration.TaskType;
import com.jem.jeeniso.model.enumeration.AchievedStat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {


    private String name;

    private String description;

    private Date assignementDate;

    private Date deadline;

    private TaskType taskType;

    private AchievedStat achievedStat;

    private SecretaryDto secretary ;

    private EvaluationGridDto evaluationGrid;

    private Integer meritPoint ;

}
