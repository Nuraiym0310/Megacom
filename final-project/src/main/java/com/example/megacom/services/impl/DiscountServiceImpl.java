package com.example.megacom.services.impl;

import com.example.megacom.dao.DiscountRepo;
import com.example.megacom.mappers.DiscountMapper;
import com.example.megacom.mappers.ProductMapper;
import com.example.megacom.models.dtos.DiscountDto;
import com.example.megacom.models.dtos.ProductDto;
import com.example.megacom.models.entities.Discount;
import com.example.megacom.models.responses.ErrorResponse;
import com.example.megacom.services.DiscountService;
import com.example.megacom.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class DiscountServiceImpl implements DiscountService {

    @Autowired
    private DiscountRepo discountRepo;

    @Autowired
    private UserService userService;

    @Override
    public ResponseEntity<?> saveDiscount(String token, DiscountDto discountDto) {
        ResponseEntity<?> responseEntity =
                userService
                        .verifyLogin(token);

        if (!responseEntity.getStatusCode().equals(HttpStatus.OK)) {

            return responseEntity;
        }

        List<Discount> discountList =
                discountRepo
                        .findAllByProduct(
                                ProductMapper
                                        .INSTANCE
                                        .mapToProduct(
                                                discountDto
                                                        .getProduct()));

        if (Objects.nonNull(discountList) && !discountList.isEmpty()) {
            discountList.stream().filter(oldDiscount -> oldDiscount.getStartDate().before(discountDto.getStartDate())

                            || oldDiscount.getStartDate().after(discountDto.getStartDate())

                            && oldDiscount.getEndDate().before(discountDto.getEndDate())

                            || oldDiscount.getEndDate().after(discountDto.getEndDate()))
                    .forEach(oldDiscount -> {
                        oldDiscount.setEndDate(new Date());
                        discountRepo.save(oldDiscount);
                    });
        }

        Discount discount =
                DiscountMapper
                        .INSTANCE
                        .mapToDiscount(discountDto);

        discount = discountRepo.save(discount);

        return ResponseEntity.ok(
                DiscountMapper
                        .INSTANCE
                        .mapToDiscountDto(discount));
    }

    @Override
    public ResponseEntity<?> findDiscountByProduct(String token, ProductDto productDto) {

        ResponseEntity<?> responseEntity =
                userService
                        .verifyLogin(token);

        if (!responseEntity.getStatusCode().equals(HttpStatus.OK)) {

            return responseEntity;
        }

        Discount discount =
                discountRepo
                        .findActualDiscount(
                                ProductMapper
                                        .INSTANCE
                                        .mapToProduct(productDto)
                                        .getId()
                        );

        if (Objects.isNull(discount)) {

            return new ResponseEntity<>(
                    new ErrorResponse("???? ?????????? ?????????????????????? ????????????!", null)
                    , HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(
                DiscountMapper
                        .INSTANCE
                        .mapToDiscountDto(discount));
    }

    @Override
    public ResponseEntity<?> getAllDiscounts(String token) {
        ResponseEntity<?> responseEntity =
                userService
                        .verifyLogin(token);

        if (!responseEntity.getStatusCode().equals(HttpStatus.OK)) {

            return responseEntity;
        }

        List<Discount> discountList =
                discountRepo
                        .findAll();

        return ResponseEntity.ok(
                discountList
                        .stream()
                        .map(DiscountMapper
                                .INSTANCE::mapToDiscountDto)
                        .collect(Collectors
                                .toList()));
    }

    @Override
    public double getDiscountByProduct(ProductDto productDto) {

        Discount discount =
                discountRepo
                        .findActualDiscount(
                                productDto
                                        .getId());

        if (Objects.isNull(discount)) {
            return 0;
        }

        return discount
                .getDiscount();
    }
}