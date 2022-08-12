package com.axonactive.hospital.service.dto;

import com.axonactive.hospital.entity.Patient;
import com.axonactive.hospital.entity.Physician;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class TreatmentDetailDto {
    private Integer treatmentDetailId;

    private LocalDate date;

    private LocalTime time;

    private String result;

    private Integer patientId;

    private String firstName;

    private Integer age;

    private Integer physicianId;

    private String fullName;
}
