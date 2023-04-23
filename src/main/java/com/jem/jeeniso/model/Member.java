package com.jem.jeeniso.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import com.jem.jeeniso.model.enumeration.MemberStatus;
import lombok.experimental.SuperBuilder;
import net.bytebuddy.implementation.bind.annotation.Super;

import javax.persistence.*;
import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "member")
public class Member extends User{

    @Column(name = "status")
    private MemberStatus status;

    @ManyToMany
    @JoinTable( name = "projetlistmembre",
            joinColumns = @JoinColumn( name = "idmembre" ),
            inverseJoinColumns = @JoinColumn( name = "idprojet" ) )
    private List<Project> projets;

}
