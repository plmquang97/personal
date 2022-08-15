package com.axonactive.hospital.service.serviceimpl;

import com.axonactive.hospital.entity.Patient;
import com.axonactive.hospital.exception.ResourceNotFoundException;
import com.axonactive.hospital.repository.PatientRepository;
import com.axonactive.hospital.repository.TreatmentDetailRepository;
import com.axonactive.hospital.resource.request.PatientRequest;
import com.axonactive.hospital.service.PatientService;
import com.axonactive.hospital.service.dto.PatientAndTreatmentAmountDto;
import com.axonactive.hospital.service.dto.PatientDto;
import com.axonactive.hospital.service.mapper.PatientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    PatientRepository patientRepository;

    @Autowired
    TreatmentDetailRepository treatmentDetailRepository;

    @Autowired
    PatientMapper patientMapper;


    @Override
    public List<PatientDto> getAll() {
        return patientMapper.toDtos(patientRepository.findAll());
    }

    @Override
    public PatientDto findById(Integer patientId) throws ResourceNotFoundException {
        return patientMapper.toDto(patientRepository.findById(patientId)
                .orElseThrow(() -> new ResourceNotFoundException("Patient Id not found")));
    }

    @Override
    public PatientDto save(PatientRequest patientRequest) {
        Patient createdPatient = new Patient();
        createdPatient.setFirstName(patientRequest.getFirstName());
        createdPatient.setLastName(patientRequest.getLastName());
        createdPatient.setAge(patientRequest.getAge());
        return patientMapper.toDto(patientRepository.save(createdPatient));
    }

    @Override
    public void delete(Integer patientId) {
    patientRepository.deleteById(patientId);
    }

    @Override
    public PatientDto update(Integer patientId, PatientRequest patientRequest) throws ResourceNotFoundException {
        Patient updatedPatient = patientRepository.findById(patientId).orElseThrow(()-> new ResourceNotFoundException("Patient Id not found"));
        updatedPatient.setFirstName(patientRequest.getFirstName());
        updatedPatient.setLastName(patientRequest.getLastName());
        updatedPatient.setAge(patientRequest.getAge());
        return patientMapper.toDto(patientRepository.save(updatedPatient));
    }

    @Override
    public List<PatientDto> findPatientByFirstNameContaining(String firstName) {
        return patientMapper.toDtos(patientRepository.findPatientByFirstNameContaining(firstName));
    }

    @Override
    public PatientDto findPatientByFirstNameAndLastNameContaining(String firstName, String lastName) {
        return patientMapper.toDto(patientRepository.findPatientByFirstNameAndLastNameContaining(firstName , lastName));
    }

    @Override
    public List<PatientDto> findPatientByAgeBetween(Integer fromAge, Integer toAge) {
        return patientMapper.toDtos(patientRepository.findPatientByAgeBetween(fromAge, toAge));
    }


    @Override
    public List<PatientDto> findPatientByAgeLessThanAndFirstNameContaining(Integer age, String firstName) {
        return patientMapper.toDtos(patientRepository.findPatientByAgeLessThanAndFirstNameContaining(age , firstName));
    }

    @Override
    public List<PatientDto> findPatientsByPhysicianId(Integer physicianId) {
        return patientMapper.toDtos(treatmentDetailRepository.findPatientsByPhysicianId(physicianId));
    }

    @Override
    public List<PatientDto> findPatientByDate(LocalDate date) {
        return patientMapper.toDtos(treatmentDetailRepository.findPatientByTreatmentDate(date));
    }

    @Override
    public List<PatientDto> findPatientByAgeGreaterThan(Integer age) {
        return patientMapper.toDtos(patientRepository.findPatientByAgeGreaterThan(age));
    }

    @Override
    public List<PatientAndTreatmentAmountDto> findTotalOfTreatmentsByPatientId(Integer patientId) {
        return treatmentDetailRepository.findTotalOfTreatmentsByPatientId(patientId);
    }


}
