package com.axonactive.hospital.resource;

import com.axonactive.hospital.entity.Patient;
import com.axonactive.hospital.exception.ResourceNotFoundException;
import com.axonactive.hospital.resource.request.PatientRequest;
import com.axonactive.hospital.service.PatientService;
import com.axonactive.hospital.service.TreatmentDetailService;
import com.axonactive.hospital.service.dto.PatientDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping(PatientResource.PATH)
public class PatientResource {
    public static final String PATH = "/api/patients";

    @Autowired
    PatientService patientService;

    @GetMapping
    ResponseEntity<List<PatientDto>> findAll() {
        return ResponseEntity.ok(patientService.getAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<PatientDto> findPatientById(@PathVariable(value = "id") Integer patientId) throws ResourceNotFoundException {
        return ResponseEntity.ok(patientService.findById(patientId));
    }

    @PostMapping
    ResponseEntity<PatientDto> add (@RequestBody PatientRequest patientRequest){
        PatientDto createdPatient = patientService.save(patientRequest);
        return ResponseEntity.created(URI.create(PatientResource.PATH + "/" + createdPatient.getPatientId())).body(createdPatient);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete (@PathVariable (value = "id")Integer patientId){
        patientService.delete(patientId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    ResponseEntity<PatientDto> update (@PathVariable(value = "id")Integer patientId , @RequestBody PatientRequest patientRequest) throws ResourceNotFoundException {
       return ResponseEntity.ok(patientService.update(patientId,patientRequest));
    }

    @GetMapping("/findByFirstName")
    ResponseEntity<List<PatientDto>> findPatientByFirstName (@RequestParam String firstName){
        return ResponseEntity.ok(patientService.findPatientByFirstNameContaining(firstName));
    }

    @GetMapping("/findByName")
    ResponseEntity<PatientDto> findPatientByName (@RequestParam String firstName , String lastName){
        return ResponseEntity.ok(patientService.findPatientByFirstNameAndLastNameContaining(firstName , lastName));
    }

    @GetMapping("/findBetweenAge")
    ResponseEntity<List<PatientDto>> findPatientBetweenAge (@RequestParam Integer fromAge , Integer toAge){
        return ResponseEntity.ok(patientService.findPatientByAgeBetween(fromAge ,toAge));
    }

    @GetMapping("/findByAgeGreaterThan")
    ResponseEntity<List<PatientDto>> findPatientByAgeGreaterThan (@RequestParam Integer age){
        return ResponseEntity.ok(patientService.findPatientByAgeGreaterThan(age));
    }

    @GetMapping("/findByAgeLessThanAndFirstName")
    ResponseEntity<List<PatientDto>> findPatientByAgeLessThanAndFirstName (@RequestParam Integer age ,String firstName){
        return ResponseEntity.ok(patientService.findPatientByAgeLessThanAndFirstNameContaining(age ,firstName));
    }

    @GetMapping("/PhysicianId")
    ResponseEntity<List<PatientDto>> findByPhysicianId (@RequestParam Integer physicianId){
        return ResponseEntity.ok(patientService.findPatientsByPhysicianId(physicianId));
    }

    @GetMapping("/findByTreatmentDate")
    ResponseEntity<List<PatientDto>> findByTreatmentDate(@RequestParam (value = "date", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date){
        return ResponseEntity.ok(patientService.findPatientByDate(date));
    }

}
