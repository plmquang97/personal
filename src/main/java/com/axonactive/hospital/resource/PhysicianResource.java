package com.axonactive.hospital.resource;

import com.axonactive.hospital.entity.Physician;
import com.axonactive.hospital.exception.ResourceNotFoundException;
import com.axonactive.hospital.resource.request.PhysicianRequest;
import com.axonactive.hospital.service.PhysicianService;
import com.axonactive.hospital.service.dto.PatientDto;
import com.axonactive.hospital.service.dto.PhysicianDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping(PhysicianResource.PATH)
public class PhysicianResource {
    public static final String PATH = "/api/physicians";

    @Autowired
    PhysicianService physicianService;


    @GetMapping
    ResponseEntity<List<PhysicianDto>> findAll(){
        return ResponseEntity.ok(physicianService.getAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<PhysicianDto> findPhysicianById (@PathVariable (value = "id") Integer physicianId) throws ResourceNotFoundException {
        return ResponseEntity.ok(physicianService.findById(physicianId));
    }

    @PostMapping
    ResponseEntity<PhysicianDto> add (@RequestBody PhysicianRequest physicianRequest){
        PhysicianDto createdPhysician = physicianService.save(physicianRequest);
        return ResponseEntity.created(URI.create(PhysicianResource.PATH + "/" + createdPhysician.getPhysicianId())).body(createdPhysician);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete (@PathVariable (value = "id")Integer physicianId){
        physicianService.delete(physicianId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    ResponseEntity<PhysicianDto> update (@PathVariable (value = "id")Integer physicianId,@RequestBody PhysicianRequest physicianRequest) throws ResourceNotFoundException {
        return ResponseEntity.ok(physicianService.update(physicianId,physicianRequest));
    }

    @GetMapping("/get-physician-by-patient-first-name")
    ResponseEntity<List<PhysicianDto>> findPhysicianByPatientsFirstName (@RequestParam String firstName){
        return ResponseEntity.ok(physicianService.findByPatientFirstName(firstName));
    }

    @GetMapping("/get-physician-by-full-name-and-code")
    ResponseEntity<PhysicianDto> findPhysicianByFullNameAndCode (@RequestParam String fullName , String physicianCode){
        return ResponseEntity.ok(physicianService.findByFullNameAndCode(fullName,physicianCode));
    }

    @GetMapping("/findByFullName")
    ResponseEntity<PhysicianDto> findPhysicianByFullName (@RequestParam String fullName){
        return ResponseEntity.ok(physicianService.findByFullName(fullName));
    }

    @GetMapping("/findByPhysicianCode")
    ResponseEntity<List<PhysicianDto>> findByPhysicianCode (@RequestParam String physicianCode){
        return ResponseEntity.ok(physicianService.findByPhysicianCode(physicianCode));
    }
}
