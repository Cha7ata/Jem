package com.jem.jeeniso.model;

import lombok.*;
import com.jem.jeeniso.model.enumeration.EventType;
import lombok.experimental.SuperBuilder;
import org.springframework.context.event.EventListener;

import javax.persistence.*;
import java.util.Date;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="event")
public class Event extends AbstractEntity{
    @Column(name="name")
    private String name;

    @Column(name="place")
    private String place;

    @Column(name="eventtype")
    private EventType eventType;

    @Column(name = "date", nullable = false)
    private Date date;

    @ManyToOne
    @JoinColumn(name="idvicepresidentevent")
    private VicePresident vicePresident ;
}
