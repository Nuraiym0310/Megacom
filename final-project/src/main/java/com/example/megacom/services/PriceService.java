package com.example.megacom.services;

import com.example.megacom.models.dtos.PriceDto;
import com.example.megacom.models.dtos.ProductDto;
import org.springframework.http.ResponseEntity;

public interface PriceService {

    ResponseEntity<?> savePrice(String token, PriceDto priceDto);

    ResponseEntity<?> getPriceByProduct(String token, ProductDto productDto);

    ResponseEntity<?> getAllPrices(String token);

    double findPriceByProductForOperationDetails(ProductDto productDto);
}