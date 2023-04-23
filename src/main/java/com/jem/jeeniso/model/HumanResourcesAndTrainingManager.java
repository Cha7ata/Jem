package com.jem.jeeniso.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name="humanresourcesandtrainingmanager")
public class HumanResourcesAndTrainingManager extends User {

    @OneToMany(mappedBy="humanResourcesAndTrainingManager")
    private List<Training> training;

    @OneToMany(mappedBy="humanResourcesAndTrainingManager")
    private List<Task> tasks;

    @OneToOne
    private EvaluationGrid evaluationGrid;


}
