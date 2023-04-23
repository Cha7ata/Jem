package com.jem.jeeniso.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;
import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name="training")
public class Training extends AbstractEntity{

    @Column(name="Name")
    private String name;

    @Column(name="place")
    private String place;

    @Column(name="description")
    private String description;

    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name="traineratisfaction")
    private Integer trainerSatisfaction ;

    @Column(name="member_satisfaction")
    private Integer memberSatisfaction ;

    @Column(name = "price")
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name="humanresourcesandtrainingmanager")
    private HumanResourcesAndTrainingManager humanResourcesAndTrainingManager ;

    @OneToMany(mappedBy="training")
    private List<Trainer> trainer;
}
