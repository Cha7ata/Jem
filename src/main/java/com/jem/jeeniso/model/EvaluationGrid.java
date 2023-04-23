package com.jem.jeeniso.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name="evaluationgrid")
public class EvaluationGrid extends AbstractEntity{

    @OneToMany(mappedBy = "evaluationGrid")
    private List<Task> task ;

    @Column(name="mandate")
    private String mandate ;

    @OneToOne
    private HumanResourcesAndTrainingManager humanResourcesAndTrainingManager;
}
