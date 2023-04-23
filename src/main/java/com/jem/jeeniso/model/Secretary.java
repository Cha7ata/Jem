package com.jem.jeeniso.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name="secretary")
public class Secretary extends User{


    @OneToMany(mappedBy= "secretary")
    private List<Task> task;


    @OneToMany(mappedBy= "secretary")
    private List<Meeting> meeting;


    @OneToMany(mappedBy= "secretary")
    private List<PV> pv;


    @OneToMany(mappedBy="secretary")
    private List<JuniorEntreprise> juniorEntreprise;
}
