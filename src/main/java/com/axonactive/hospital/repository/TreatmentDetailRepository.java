package com.axonactive.hospital.repository;

import com.axonactive.hospital.entity.Patient;
import com.axonactive.hospital.entity.Physician;
import com.axonactive.hospital.entity.TreatmentDetail;

import com.axonactive.hospital.service.dto.PatientAndTreatmentAmountDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TreatmentDetailRepository extends JpaRepository<TreatmentDetail,Integer> {

//THIS IS JPAQL QUERY
    @Query("SELECT t.patient FROM TreatmentDetail t WHERE t.date = ?1")
    List<Patient> findPatientByTreatmentDate(LocalDate date);

    @Query("SELECT t.patient FROM TreatmentDetail t WHERE t.physician.physicianId = ?1")
    List<Patient> findPatientsByPhysicianId ( Integer physicianId);

    @Query("SELECT t.physician FROM TreatmentDetail t WHERE t.patient.firstName = ?1")
    List<Physician> findPhysicianByPatientFirstName(String firstName );


    @Query("FROM TreatmentDetail t WHERE t.physician.fullName = ?1")
    List<TreatmentDetail> findTreatmentDetailByPhysicianName (String fullName);

    @Query("SELECT t FROM TreatmentDetail t WHERE t.patient.firstName = ?1")
    List<TreatmentDetail> findByPatientFirstName(String firstName);

    @Query("SELECT new com.axonactive.hospital.service.dto.PatientAndTreatmentAmountDto(p.firstName , p.lastName , count(t.treatmentDetailId)) " +
            "FROM TreatmentDetail t , Patient p " +
            "WHERE p.patientId = t.patient.patientId AND p.patientId = ?1 " +
            "GROUP BY p.firstName, p.lastName ")
    List<PatientAndTreatmentAmountDto> findTotalOfTreatmentsByPatientId (Integer patientId);

//  THIS IS NATIVE QUERY
    @Query(value="SELECT * FROM treatment_detail t WHERE t.result = ?1" ,nativeQuery = true)
    List<TreatmentDetail> findTreatmentByResult (String result);

}
