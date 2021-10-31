package com.example.megacom.mappers;

import com.example.megacom.models.dtos.PriceDto;
import com.example.megacom.models.entities.Price;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PriceMapper {

    PriceMapper INSTANCE = Mappers.getMapper(PriceMapper.class);

    Price mapToPrice(PriceDto priceDto);

    PriceDto mapToPriceDto(Price price);
}