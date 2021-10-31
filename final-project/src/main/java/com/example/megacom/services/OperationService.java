package com.example.megacom.services;

import com.example.megacom.models.dtos.InputDataForOperation;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OperationService {

    ResponseEntity<?> provideOperation(String token, List<InputDataForOperation> sellingList);

    ResponseEntity<?> payment(String token, Long operationId, double cash);
}