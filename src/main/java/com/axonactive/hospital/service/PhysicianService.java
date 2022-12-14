package com.axonactive.hospital.service;

import com.axonactive.hospital.entity.Physician;
import com.axonactive.hospital.exception.ResourceNotFoundException;
import com.axonactive.hospital.resource.request.PhysicianRequest;
import com.axonactive.hospital.service.dto.PhysicianDto;

import java.util.List;

public interface PhysicianService {
    List<PhysicianDto> getAll ();

    PhysicianDto findById(Integer physicianId) throws ResourceNotFoundException;

    PhysicianDto save(PhysicianRequest physicianRequest);

    void delete (Integer physicianId);

    PhysicianDto update(Integer physicianId ,PhysicianRequest physicianRequest) throws ResourceNotFoundException;

    List<PhysicianDto> findByPatientFirstName(String firstName);

    PhysicianDto findByFullName (String fullName);

    PhysicianDto findByFullNameAndCode(String fullName, String physicianCode);

    List<PhysicianDto> findByPhysicianCode (String physicianCode);


}
