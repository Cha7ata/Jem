package com.jem.jeeniso.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Date;


@Data
@SuperBuilder()
@EqualsAndHashCode(callSuper = true)
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "jemuser")
@NoArgsConstructor
@AllArgsConstructor
public class User extends AbstractEntity {

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "email")
    private String email;

    @Column(name = "birthdate")
    private Date birthDate;

    @Column(name = "password")
    private String password;

    @Column(name = "photo")
    private String photo;

    @ManyToOne
    @JoinColumn(name = "idrole")
    private Role role;

}