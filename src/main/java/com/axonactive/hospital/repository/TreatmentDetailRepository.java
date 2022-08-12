package com.axonactive.hospital.repository;

import com.axonactive.hospital.entity.Patient;
import com.axonactive.hospital.entity.Physician;
import com.axonactive.hospital.entity.TreatmentDetail;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TreatmentDetailRepository extends JpaRepository<TreatmentDetail,Integer> {

    @Query("SELECT t FROM TreatmentDetail t WHERE t.patient.firstName = ?1")
    List<TreatmentDetail> findByPatientFirstName(String firstName);

    @Query("SELECT t.patient FROM TreatmentDetail t WHERE t.physician.physicianId = ?1")
    List<Patient> findPatientsByPhysicianId ( Integer physicianId);

    @Query("SELECT t.physician FROM TreatmentDetail t WHERE t.patient.firstName = ?1")
    List<Physician> findPhysicianByPatientFirstName(String firstName );

    @Query("SELECT t.patient FROM TreatmentDetail t WHERE t.date = ?1")
    List<Patient> findPatientByTreatmentDate(LocalDate date);

    @Query("FROM TreatmentDetail t WHERE t.physician.fullName = ?1")
    List<TreatmentDetail> findTreatmentDetailByPhysicianName (String fullName);
}
