package com.bio.demo.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Table(name = "tbl_patient")
public class Patient {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(nullable = false)
    private UUID id;
    @Column
    @NotNull
    @NotBlank
    private String name;
    @Column
    @NotNull
    @Positive
    private int age;
    @Column
    @NotNull
    @NotBlank
    private String gender;
    @Column
    private String diagnosis;
    @Column
    private String medicine;
    @Column
    private Date prescriptionDate;
    @Column
    private Date nextVisitDate;
}
