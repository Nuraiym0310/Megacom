package com.example.megacom.services;

import com.example.megacom.models.dtos.CategoryDto;
import org.springframework.http.ResponseEntity;

public interface CategoryService {

    ResponseEntity<?> saveCategory(String token, CategoryDto categoryDto);

    ResponseEntity<?> getByName(String token, String name);

    ResponseEntity<?> getAllCategories(String token);
}