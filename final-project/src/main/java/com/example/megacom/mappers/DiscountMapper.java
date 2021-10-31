package com.example.megacom.mappers;

import com.example.megacom.models.dtos.DiscountDto;
import com.example.megacom.models.entities.Discount;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DiscountMapper {

    DiscountMapper INSTANCE = Mappers.getMapper(DiscountMapper.class);

    Discount mapToDiscount(DiscountDto discountDto);

    DiscountDto mapToDiscountDto(Discount discount);
}