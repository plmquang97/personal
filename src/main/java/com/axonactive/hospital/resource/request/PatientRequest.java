package com.axonactive.hospital.resource.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientRequest {
    private String firstName;

    private String lastName;

    private Integer age;
}
