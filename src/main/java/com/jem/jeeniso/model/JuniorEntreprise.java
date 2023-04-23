package com.jem.jeeniso.model;

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
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name="juniorentreprise")
public class JuniorEntreprise extends AbstractEntity {
    @Column(name="Name")
    private String name;

    @Column(name = "picture")
    private String picture;

    @Column(name="place")
    private String place;

    @Column(name = "email")
    private String email;

    @Column(name = "phonenumber")
    private String phoneNumber;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="idsecretaryje")
    private Secretary secretary ;
}
