package com.jem.jeeniso.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name="calendar")
public class Calendar extends AbstractEntity{

    @Column(name="Name")
    private String name;

    @Column(name="description")
    private String description;

    @Column(name = "date", nullable = false)
    private Date date;
}
