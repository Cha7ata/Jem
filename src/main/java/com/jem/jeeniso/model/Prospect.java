package com.jem.jeeniso.model;


import com.jem.jeeniso.model.enumeration.Field;
import com.jem.jeeniso.model.enumeration.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "prospect")
public class Prospect extends AbstractEntity{


    @Column(name = "organisationname")
    private String organisationName;

    @Column(name = "address")
    private String address;

    @Column(name = "respnsablename")
    private String respnsableName;

    @Column(name = "function")
    private String function;

    @Column(name = "email")
    private String email;

    @Column(name = "phonenumber")
    private String phoneNumber;

    @Column(name = "status")
    private Status status ;

    @ManyToOne
    @JoinColumn(name = "businesslDevelopmentManager")
    private BusinessDevelopmentManager businesslDevelopmentManager;

}
