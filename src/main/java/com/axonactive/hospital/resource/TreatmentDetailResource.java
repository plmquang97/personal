package com.axonactive.hospital.resource;

import com.axonactive.hospital.exception.ResourceNotFoundException;
import com.axonactive.hospital.resource.request.TreatmentDetailRequest;
import com.axonactive.hospital.service.TreatmentDetailService;
import com.axonactive.hospital.service.dto.TreatmentDetailDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping(TreatmentDetailResource.PATH)
public class TreatmentDetailResource {
    public static final String PATH ="/api/treatments";

    @Autowired
    TreatmentDetailService treatmentDetailService;

    @GetMapping
    ResponseEntity<List<TreatmentDetailDto>> findAll() {
        return ResponseEntity.ok(treatmentDetailService.getAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<TreatmentDetailDto> findTreatmentDetailById(@PathVariable (value = "id")Integer treatmentDetailId) throws ResourceNotFoundException {
        return ResponseEntity.ok(treatmentDetailService.findById(treatmentDetailId));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete (@PathVariable (value = "id")Integer treatmentDetailId) {
        treatmentDetailService.delete(treatmentDetailId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    ResponseEntity<TreatmentDetailDto> add(@RequestBody TreatmentDetailRequest treatmentDetailRequest) throws ResourceNotFoundException {
        TreatmentDetailDto createdTreatmentDetail = treatmentDetailService.save(treatmentDetailRequest);
        return ResponseEntity.created(URI.create(TreatmentDetailResource.PATH + "/" + createdTreatmentDetail.getTreatmentDetailId())).body(createdTreatmentDetail);
    }

    @PutMapping("/{id}")
    ResponseEntity<TreatmentDetailDto> update (@PathVariable (value = "id")Integer treatmentDetailId , @RequestBody TreatmentDetailRequest treatmentDetailRequest) throws ResourceNotFoundException {
        return ResponseEntity.ok(treatmentDetailService.update(treatmentDetailId,treatmentDetailRequest));
    }

    @GetMapping("/PatientName")
    ResponseEntity<List<TreatmentDetailDto>> findByPatientName (@RequestParam String firstName) {
        return ResponseEntity.ok(treatmentDetailService.findByPatientFirstName(firstName));
    }

    @GetMapping("/PhysicianName")
    ResponseEntity<List<TreatmentDetailDto>> findByPhysicianName(@RequestParam String fullName){
        return ResponseEntity.ok(treatmentDetailService.findTreatmentDetailByPhysicianName(fullName));
    }

    @GetMapping("/FindByResult")
    ResponseEntity<List<TreatmentDetailDto>> findTreatmentsByResult(@RequestParam String result){
        return ResponseEntity.ok(treatmentDetailService.findTreatmentByResult(result));
    }
}
