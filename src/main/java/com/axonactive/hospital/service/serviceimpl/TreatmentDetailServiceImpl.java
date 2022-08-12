package com.axonactive.hospital.service.serviceimpl;

import com.axonactive.hospital.entity.Patient;
import com.axonactive.hospital.entity.Physician;
import com.axonactive.hospital.entity.TreatmentDetail;
import com.axonactive.hospital.exception.ResourceNotFoundException;
import com.axonactive.hospital.repository.PatientRepository;
import com.axonactive.hospital.repository.PhysicianRepository;
import com.axonactive.hospital.repository.TreatmentDetailRepository;
import com.axonactive.hospital.resource.request.TreatmentDetailRequest;
import com.axonactive.hospital.service.TreatmentDetailService;
import com.axonactive.hospital.service.dto.TreatmentDetailDto;
import com.axonactive.hospital.service.mapper.TreatmentDetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreatmentDetailServiceImpl implements TreatmentDetailService {

    @Autowired
    TreatmentDetailRepository treatmentDetailRepository;

    @Autowired
    PhysicianRepository physicianRepository;

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    TreatmentDetailMapper treatmentDetailMapper;



    @Override
    public List<TreatmentDetailDto> getAll() {
        return treatmentDetailMapper.toDtos(treatmentDetailRepository.findAll());
    }

    @Override
    public TreatmentDetailDto findById(Integer treatmentDetailId) throws ResourceNotFoundException {
        return treatmentDetailMapper.toDto(treatmentDetailRepository.findById(treatmentDetailId)
                .orElseThrow(()->new ResourceNotFoundException("TreatmentDetail Id not found")));
    }

    @Override
    public TreatmentDetailDto save(TreatmentDetailRequest treatmentDetailRequest) throws ResourceNotFoundException {
        TreatmentDetail createdTreatmentDetail = new TreatmentDetail();
        createdTreatmentDetail.setDate(treatmentDetailRequest.getDate());
        createdTreatmentDetail.setTime(treatmentDetailRequest.getTime());
        createdTreatmentDetail.setResult(treatmentDetailRequest.getResult());
        Physician physician = physicianRepository.findById(treatmentDetailRequest.getPhysicianId())
                .orElseThrow(()-> new ResourceNotFoundException("Physician Id not found"));
        createdTreatmentDetail.setPhysician(physician);
        Patient patient = patientRepository.findById(treatmentDetailRequest.getPatientId())
                .orElseThrow(()-> new ResourceNotFoundException("Patient Id not found"));
        createdTreatmentDetail.setPatient(patient);
        return treatmentDetailMapper.toDto(treatmentDetailRepository.save(createdTreatmentDetail));
    }

    @Override
    public void delete(Integer treatmentDetailId) {
        treatmentDetailRepository.deleteById(treatmentDetailId);

    }

    @Override
    public TreatmentDetailDto update(Integer treatmentDetailId, TreatmentDetailRequest treatmentDetailRequest) throws ResourceNotFoundException {
        TreatmentDetail updatedTreatmentDetail = treatmentDetailRepository.findById(treatmentDetailId).orElseThrow(()-> new ResourceNotFoundException("TreatmentDetail Id not found"));
        updatedTreatmentDetail.setDate(treatmentDetailRequest.getDate());
        updatedTreatmentDetail.setTime(treatmentDetailRequest.getTime());
        updatedTreatmentDetail.setResult(treatmentDetailRequest.getResult());
        Physician physician = physicianRepository.findById(treatmentDetailRequest.getPhysicianId())
                .orElseThrow(()-> new ResourceNotFoundException("Physician Id not found"));
        updatedTreatmentDetail.setPhysician(physician);
        Patient patient = patientRepository.findById(treatmentDetailRequest.getPatientId())
                .orElseThrow(()-> new ResourceNotFoundException("Patient Id not found"));
        updatedTreatmentDetail.setPatient(patient);
        return treatmentDetailMapper.toDto(treatmentDetailRepository.save(updatedTreatmentDetail)) ;
    }

    @Override
    public List<TreatmentDetailDto> findByPatientFirstName(String firstName) {
        return treatmentDetailMapper.toDtos(treatmentDetailRepository.findByPatientFirstName(firstName));
    }

    @Override
    public List<TreatmentDetailDto> findTreatmentDetailByPhysicianName(String fullName) {
        return treatmentDetailMapper.toDtos(treatmentDetailRepository.findTreatmentDetailByPhysicianName(fullName));
    }
}
