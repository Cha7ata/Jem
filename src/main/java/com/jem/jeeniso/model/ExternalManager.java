package com.jem.jeeniso.model;


import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "externemanager")
public class ExternalManager extends User{

    @OneToMany( mappedBy = "externalManager")
    private List<Media> media;

}
