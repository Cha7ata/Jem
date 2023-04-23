package com.jem.jeeniso.model;

import com.jem.jeeniso.model.enumeration.AchievedStat;
import com.jem.jeeniso.model.enumeration.TaskType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name="task")
public class Task extends AbstractEntity{
    @Column(name="name")
    private String name;

    @Column(name="description")
    private String Description;

    @Column(name = "assignmentdate", nullable = false, updatable = false)
    private Date assignementDate;

    @Column(name="meritpoint")
    private Integer meritPoint ;

    @Column(name = "deadline", nullable = false)
    private Date deadLine;


    @Column(name ="listtask")
    private TaskType taskType;

    @Column(name="achievedstat")
    private AchievedStat achievedStat;

    @ManyToOne()
    @JoinColumn(name="idsecretarytask")
    private Secretary secretary;

    @ManyToOne
    @JoinColumn(name="idhuman_resources_and_training_manager")
    private HumanResourcesAndTrainingManager humanResourcesAndTrainingManager;

    @ManyToOne
    @JoinColumn(name = "evaluationGrid", nullable = false)
    private EvaluationGrid evaluationGrid;


}
