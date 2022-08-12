package com.axonactive.hospital.service.mapper;

import com.axonactive.hospital.entity.Physician;
import com.axonactive.hospital.service.dto.PhysicianDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper (componentModel = "spring")
public interface PhysicianMapper {
    PhysicianDto toDto(Physician physician);

    List<PhysicianDto> toDtos(List<Physician> physicians);
}
