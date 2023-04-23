package com.jem.jeeniso.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.util.StringUtils;

import javax.persistence.*;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name="trainer")
public class Trainer extends AbstractEntity{


    @Column(name="Name")
    private String name;

    @Column(name="institution")
    private String institution ;

    @Column(name="address")
    private String address;

    @Column(name = "email")
    private String email;

    @Column(name = "phonenumber")
    private String phoneNumber;

    @Column(name="field")
    private String field;

    @ManyToOne
    @JoinColumn(name="training")
    private Training training;
}