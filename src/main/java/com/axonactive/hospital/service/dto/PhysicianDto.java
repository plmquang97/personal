package com.axonactive.hospital.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhysicianDto {
    private Integer physicianId;

    private String fullName;

    private String physicianCode;


}
