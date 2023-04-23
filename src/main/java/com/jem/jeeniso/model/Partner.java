package com.jem.jeeniso.model;

import com.jem.jeeniso.model.enumeration.Field;
import com.jem.jeeniso.model.enumeration.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Date;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name="partner")
public class Partner extends AbstractEntity{
    @Column(name="organizationname")
    private String organizationName;

    @Column(name="description")
    private String description;

    @Column(name = "signaturedate", nullable = false)

    private Date signatureDate;

    @Column(name = "expansiondate", nullable = false)
    private Date expansionDate;

    @Column(name="manager")
    private String manager;

    @Column(name = "managerphonenumber")
    private String managerphonenumber;

    @Column(name = "status")
    private Status status ;

    @Column(name = "field")
    private Field field ;

    @ManyToOne
    @JoinColumn(name="idvicepresidentpartener")
    private VicePresident vicePresident ;
}
