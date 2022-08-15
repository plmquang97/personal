package com.axonactive.hospital.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PatientAndTreatmentAmountDto {


    private String firstName;

    private String lastName;

    private Long treatmentsAmount;
}

