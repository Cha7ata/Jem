package com.jem.jeeniso.dto;



import com.jem.jeeniso.model.PV;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.Instant;
import java.util.Date;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PVDto {

    private String title;

    private String subject;

    private Date date;

    private SecretaryDto secretary ;

}
