package com.jem.jeeniso.dto;



import com.jem.jeeniso.model.JuniorEntreprise;
import com.jem.jeeniso.model.Secretary;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JuniorEntrepriseDto {

    private String name;

    private String photo;

    private String place;

    private String email;

    private String phoneNumber;

    private SecretaryDto secretary ;



}
