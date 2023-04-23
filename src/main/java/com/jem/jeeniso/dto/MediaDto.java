package com.jem.jeeniso.dto;

import com.jem.jeeniso.model.ExternalManager;
import com.jem.jeeniso.model.MarketingManager;
import com.jem.jeeniso.model.Media;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class MediaDto {

    private String name;

    private String phoneNumber;

    private String email;

    private String address;

    private MarketingManagerDto marketingManager ;

    private ExternalManagerDto externalManager ;
}
