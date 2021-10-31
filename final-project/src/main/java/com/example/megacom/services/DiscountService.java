package com.example.megacom.services;

import com.example.megacom.models.dtos.DiscountDto;
import com.example.megacom.models.dtos.ProductDto;
import org.springframework.http.ResponseEntity;

public interface DiscountService {

    ResponseEntity<?> saveDiscount(String token, DiscountDto discountDto);

    ResponseEntity<?> findDiscountByProduct(String token, ProductDto productDto);

    ResponseEntity<?> getAllDiscounts(String token);

    double getDiscountByProduct(ProductDto productDto);
}