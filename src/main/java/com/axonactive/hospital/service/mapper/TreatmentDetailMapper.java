package com.axonactive.hospital.service.mapper;

import com.axonactive.hospital.entity.TreatmentDetail;
import com.axonactive.hospital.service.dto.TreatmentDetailDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper (componentModel = "spring")
public interface TreatmentDetailMapper {
//   Patient Mapping
    @Mapping(source = "patient.patientId" ,target = "patientId")
    @Mapping(source ="patient.firstName" , target ="firstName")
    @Mapping(source="patient.age" , target = "age")
//    Physician Mapping
    @Mapping(source = "physician.physicianId", target = "physicianId")
    @Mapping(source = "physician.fullName", target ="fullName")


    TreatmentDetailDto toDto(TreatmentDetail treatmentDetail);

    List<TreatmentDetailDto> toDtos(List<TreatmentDetail> treatmentDetails);




}
