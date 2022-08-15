package com.axonactive.hospital.service.serviceimpl;

import com.axonactive.hospital.entity.Physician;
import com.axonactive.hospital.exception.ResourceNotFoundException;
import com.axonactive.hospital.repository.PhysicianRepository;
import com.axonactive.hospital.repository.TreatmentDetailRepository;
import com.axonactive.hospital.resource.request.PhysicianRequest;
import com.axonactive.hospital.service.PhysicianService;
import com.axonactive.hospital.service.dto.PhysicianDto;
import com.axonactive.hospital.service.mapper.PhysicianMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PhysicianServiceImpl implements PhysicianService {
    @Autowired
    PhysicianMapper physicianMapper;

    @Autowired
    PhysicianRepository physicianRepository;

    @Autowired
    TreatmentDetailRepository treatmentDetailRepository;


    @Override
    public List<PhysicianDto> getAll() {
        return physicianMapper.toDtos(physicianRepository.findAll());
    }

    @Override
    public PhysicianDto findById(Integer physicianId) throws ResourceNotFoundException {
        return physicianMapper.toDto(physicianRepository.findById(physicianId).orElseThrow(()-> new ResourceNotFoundException("Physician Id not found")));
    }

    @Override
    public PhysicianDto save(PhysicianRequest physicianRequest) {
        Physician createdPhysician = new Physician();
        createdPhysician.setPhysicianCode(physicianRequest.getPhysicianCode());
        createdPhysician.setFullName(physicianRequest.getFullName());
        return physicianMapper.toDto(physicianRepository.save(createdPhysician));
    }

    @Override
    public void delete(Integer physicianId) {
        physicianRepository.deleteById(physicianId);

    }

    @Override
    public PhysicianDto update(Integer physicianId, PhysicianRequest physicianRequest) throws ResourceNotFoundException {
        Physician updatedPhysician = physicianRepository.findById(physicianId).orElseThrow(()->new ResourceNotFoundException("Physician Id not found"));
        updatedPhysician.setPhysicianCode(physicianRequest.getPhysicianCode());
        updatedPhysician.setFullName(physicianRequest.getFullName());
        return physicianMapper.toDto(physicianRepository.save(updatedPhysician));
    }


    @Override
    public List<PhysicianDto> findByPatientFirstName(String firstName) {
        return physicianMapper.toDtos(treatmentDetailRepository.findPhysicianByPatientFirstName(firstName));
    }

    @Override
    public PhysicianDto findByFullName(String fullName) {
        return physicianMapper.toDto(physicianRepository.findByFullName(fullName));
    }

    @Override
    public PhysicianDto findByFullNameAndCode(String fullName, String physicianCode) {
        return physicianMapper.toDto(physicianRepository.findByFullNameAndPhysicianCode(fullName ,physicianCode));
    }

    @Override
    public List<PhysicianDto> findByPhysicianCode(String physicianCode) {
        return physicianMapper.toDtos(physicianRepository.findByPhysicianCode(physicianCode));
    }

}
