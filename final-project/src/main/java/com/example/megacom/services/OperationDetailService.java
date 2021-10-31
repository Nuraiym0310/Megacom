package com.example.megacom.services;

import com.example.megacom.models.dtos.OperationDetailDto;

import java.util.List;

public interface OperationDetailService {

    void saveOperationDetails(List<OperationDetailDto> operationDetailDtoList);
}