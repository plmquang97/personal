package com.axonactive.hospital.repository;

import com.axonactive.hospital.entity.Patient;
import com.axonactive.hospital.service.dto.PatientDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Integer> {
    List<Patient> findPatientByFirstNameContaining(String firstName);

    Patient findPatientByFirstNameAndLastNameContaining(String firstName , String lastName);

    List<Patient> findPatientByAgeBetween(Integer fromAge , Integer toAge);

    List<Patient> findPatientByAgeGreaterThan(Integer age);

    List<Patient> findPatientByAgeLessThanAndFirstNameContaining(Integer age , String firstName);


}
