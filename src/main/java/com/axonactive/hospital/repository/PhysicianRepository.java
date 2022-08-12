package com.axonactive.hospital.repository;

import com.axonactive.hospital.entity.Physician;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhysicianRepository extends JpaRepository<Physician,Integer> {
    List<Physician> findPhysicianByPhysicianCodeContaining(String physicianCode);

    Physician findPhysicianByFullName(String fullName);

    @Query ("FROM Physician ph WHERE ph.fullName = ?1  AND ph.physicianCode = ?2 ")
    Physician findByFullNameAndPhysicianCode(String fullName , String physicianCode);
}
