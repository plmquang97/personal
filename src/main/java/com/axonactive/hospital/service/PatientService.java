package com.axonactive.hospital.service;

import com.axonactive.hospital.entity.Patient;
import com.axonactive.hospital.exception.ResourceNotFoundException;
import com.axonactive.hospital.resource.request.PatientRequest;
import com.axonactive.hospital.service.dto.PatientDto;

import java.time.LocalDate;
import java.util.List;

public interface PatientService {
     List<PatientDto> getAll();

    PatientDto findById(Integer patientId) throws ResourceNotFoundException;

    PatientDto save(PatientRequest patientRequest);

    void delete(Integer patientId);

    PatientDto update(Integer patientId ,PatientRequest patientRequest) throws ResourceNotFoundException;

    List<PatientDto> findPatientByFirstNameContaining(String firstName);

    PatientDto findPatientByFirstNameAndLastNameContaining(String firstName , String lastName);

    List<PatientDto> findPatientByAgeBetween(Integer fromAge ,Integer toAge);

    List<PatientDto> findPatientByAgeGreaterThan(Integer age);

    List<PatientDto> findPatientByAgeLessThanAndFirstNameContaining(Integer age , String firstName);

    List<PatientDto> findPatientsByPhysicianId ( Integer physicianId);

    List<PatientDto> findPatientByDate (LocalDate date);
}
