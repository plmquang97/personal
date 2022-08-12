package com.axonactive.hospital.resource.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhysicianRequest {

    private String physicianCode;

    private String fullName;
}
