package com.example.megacom.mappers;

import com.example.megacom.models.dtos.ProductDto;
import com.example.megacom.models.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {
    
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
    
    Product mapToProduct(ProductDto productDto);
    
    ProductDto mapToProductDto(Product product);
}