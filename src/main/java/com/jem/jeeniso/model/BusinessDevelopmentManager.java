package com.jem.jeeniso.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "businessDevelopmentManager")
public class BusinessDevelopmentManager extends User{

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "businesslDevelopmentManager")
    private List<Prospect> prospects;
}
