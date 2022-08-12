package com.axonactive.hospital.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TreatmentDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer treatmentDetailId;

    private LocalDate date;

    private LocalTime time;

    private String result;

    @JoinColumn
    @ManyToOne
    private Patient patient;

    @JoinColumn
    @ManyToOne
    private Physician physician;


}
