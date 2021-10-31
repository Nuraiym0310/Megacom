package com.example.megacom.mappers;

import com.example.megacom.models.dtos.OperationDetailDto;
import com.example.megacom.models.entities.OperationDetail;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OperationDetailMapper {

    OperationDetailMapper INSTANCE = Mappers.getMapper(OperationDetailMapper.class);

    OperationDetail mapToOperationDetail(OperationDetailDto operationDetailDto);

    OperationDetailDto mapToOperationDetailDto(OperationDetail operationDetail);
}