package com.jem.jeeniso.dto;

import com.jem.jeeniso.model.enumeration.MeetingType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.Instant;
import java.util.Date;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class MeetingDto {

    private String place;

    private String description;

    private Date date;

    private MeetingType meetingType;

    private SecretaryDto secretary ;



}
