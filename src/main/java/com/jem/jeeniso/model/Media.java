package com.jem.jeeniso.model;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "media")
public class Media extends AbstractEntity{

    @Column(name = "name")
    private String name;

    @Column(name = "phonenumber")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @ManyToOne
    @JoinColumn(name = "idmarketingmanager")
    private MarketingManager marketingManager;

    @ManyToOne
    @JoinColumn(name = "idexternalmanager")
    private ExternalManager externalManager;
}
