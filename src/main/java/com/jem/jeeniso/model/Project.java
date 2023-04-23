package com.jem.jeeniso.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "project")
public class Project extends AbstractEntity{

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "startdate")
    private Date startdate;

    @Column(name = "deadline")
    private Date deadLine;

    @Column(name = "stat")
    private String stat;

    @Column(name = "clientname")
    private String clientName;

    @Column(name = "clientemail")
    private String clientEmail;

    @Column(name = "clientphonenumber")
    private String clientPhoneNumber;

    @ManyToOne
    @JoinColumn(name="idprojectmanager")
    private ProjectManager projectmanager;

    @ManyToMany
    @JoinTable( name = "projetlistmembre",
            joinColumns = @JoinColumn( name = "idprojet" ),
            inverseJoinColumns = @JoinColumn( name = "idmembre" ) )
    private List<Member> members;

}
