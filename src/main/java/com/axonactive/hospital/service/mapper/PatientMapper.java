package com.axonactive.hospital.service.mapper;

import com.axonactive.hospital.entity.Patient;
import com.axonactive.hospital.service.dto.PatientAndTreatmentAmountDto;
import com.axonactive.hospital.service.dto.PatientDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper (componentModel = "spring")
public interface PatientMapper {
    PatientDto toDto(Patient patient);

    List<PatientDto> toDtos( List<Patient> patients);


}
