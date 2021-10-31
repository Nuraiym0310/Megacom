package com.example.megacom.mappers;

import com.example.megacom.models.dtos.OperationDto;
import com.example.megacom.models.entities.Operation;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OperationMapper {

    OperationMapper INSTANCE = Mappers.getMapper(OperationMapper.class);

    Operation mapToOperation(OperationDto operationDto);

    OperationDto mapToOperationDto(Operation operation);
}