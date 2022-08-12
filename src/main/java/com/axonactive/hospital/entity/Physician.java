package com.axonactive.hospital.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Physician {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer physicianId;

    private String fullName;

    private String physicianCode;

}
