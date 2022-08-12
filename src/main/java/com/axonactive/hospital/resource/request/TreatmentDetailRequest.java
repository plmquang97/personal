package com.axonactive.hospital.resource.request;

import com.axonactive.hospital.entity.Patient;
import com.axonactive.hospital.entity.Physician;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class TreatmentDetailRequest {

    private LocalDate date;

    private LocalTime time;

    private String result;

    private Integer patientId;

    private Integer physicianId;
}
