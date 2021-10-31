package com.example.megacom.mappers;

import com.example.megacom.models.dtos.RequestDto;
import com.example.megacom.models.entities.Request;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RequestMapper {

    RequestMapper INSTANCE = Mappers.getMapper(RequestMapper.class);

    @Mapping(source = "code.id", target = "code.id")
    Request mapToRequest(RequestDto requestDto);

    @Mapping(source = "code.id", target = "code.id" )
    RequestDto mapToRequestDto(Request request);
}