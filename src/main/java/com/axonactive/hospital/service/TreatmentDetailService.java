package com.axonactive.hospital.service;

import com.axonactive.hospital.exception.ResourceNotFoundException;
import com.axonactive.hospital.resource.request.TreatmentDetailRequest;
import com.axonactive.hospital.service.dto.TreatmentDetailDto;

import java.util.List;

public interface TreatmentDetailService {
    List<TreatmentDetailDto> getAll();

    TreatmentDetailDto findById(Integer treatmentDetailId) throws ResourceNotFoundException;

    TreatmentDetailDto save(TreatmentDetailRequest treatmentDetailRequest) throws ResourceNotFoundException;

    void delete(Integer treatmentDetailId);

    TreatmentDetailDto update(Integer treatmentDetailId , TreatmentDetailRequest treatmentDetailRequest) throws ResourceNotFoundException;

    List<TreatmentDetailDto> findByPatientFirstName(String firstName);

    List<TreatmentDetailDto> findTreatmentDetailByPhysicianName (String fullName);
}
