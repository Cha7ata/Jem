package com.jem.jeeniso.dto;


import com.jem.jeeniso.model.enumeration.EventType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventDto {

    private String name;

    private String place;

    private EventType eventType;

    private Date date;

    private VicePresidentDto vicePresident ;

}
