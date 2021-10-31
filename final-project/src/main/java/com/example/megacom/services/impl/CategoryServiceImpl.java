package com.example.megacom.services.impl;

import com.example.megacom.dao.CategoryRepo;
import com.example.megacom.mappers.CategoryMapper;
import com.example.megacom.models.dtos.CategoryDto;
import com.example.megacom.models.entities.Category;
import com.example.megacom.models.responses.ErrorResponse;
import com.example.megacom.services.CategoryService;
import com.example.megacom.services.UserService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private UserService userService;

    @Override
    public ResponseEntity<?> saveCategory(String token, CategoryDto categoryDto) {

        ResponseEntity<?> responseEntity =
                userService.verifyLogin(token);

        if (!responseEntity.getStatusCode().equals(HttpStatus.OK)) {

            return responseEntity;
        }

        Category category =
                CategoryMapper
                        .INSTANCE
                        .mapToCategory(categoryDto);

        if (Objects.isNull(categoryRepo.findByName(category.getName()))) {

            categoryRepo.save(category);
        } else {

            return new ResponseEntity<>(
                    new ErrorResponse("Такая категория товаров уже существует!", null)
                    , HttpStatus.CONFLICT);
        }

        return ResponseEntity.ok(
                CategoryMapper
                        .INSTANCE
                        .mapToCategoryDto(category));
    }

    @Override
    public ResponseEntity<?> getByName(String token, String name) {

        ResponseEntity<?> responseEntity =
                userService
                        .verifyLogin(token);

        if (!responseEntity.getStatusCode().equals(HttpStatus.OK)) {

            return responseEntity;
        }

        Category category =
                categoryRepo
                        .findByName(name);

        if (Objects.isNull(category)) {
            return new ResponseEntity<>(
                    new ErrorResponse("Такая категоря товаров не найдена!", null)
                    , HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(
                CategoryMapper
                        .INSTANCE
                        .mapToCategoryDto(category));
    }

    @SneakyThrows
    @Override
    public ResponseEntity<?> getAllCategories(String token) {

        ResponseEntity<?> responseEntity =
                userService
                        .verifyLogin(token);

        if (!responseEntity.getStatusCode().equals(HttpStatus.OK)) {

            return responseEntity;
        }

        List<Category> categoryList =
                categoryRepo.findAll();

        return ResponseEntity.ok(categoryList
                .stream()
                .map(CategoryMapper
                        .INSTANCE::mapToCategoryDto)
                .collect(
                        Collectors.toList()));
    }
}