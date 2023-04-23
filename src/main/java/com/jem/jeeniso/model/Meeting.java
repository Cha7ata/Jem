package com.jem.jeeniso.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import com.jem.jeeniso.model.enumeration.MeetingType;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name="meeting")
public class Meeting extends AbstractEntity{
    @Column(name="place")
    private String place;

    @Column(name="description")
    private String description;

    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name="meetingtype")
    private MeetingType meetingType;

    @ManyToOne
    @JoinColumn(name="idsecretarymeeting")
    private Secretary secretary;


}
