package com.jem.jeeniso.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="vicepresident")
public class VicePresident extends User{


    @OneToMany(mappedBy="vicePresident")
    private List<Partner> partenaires;

    @OneToMany(mappedBy="vicePresident")
    private List<Event> events;
}
