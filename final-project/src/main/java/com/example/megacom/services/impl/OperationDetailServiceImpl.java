package com.example.megacom.services.impl;

import com.example.megacom.dao.OperationDetailRepo;
import com.example.megacom.mappers.OperationDetailMapper;
import com.example.megacom.models.dtos.OperationDetailDto;
import com.example.megacom.services.OperationDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperationDetailServiceImpl implements OperationDetailService {

    @Autowired
    private OperationDetailRepo operationDetailRepo;

    @Override
    public void saveOperationDetails(List<OperationDetailDto> operationDetailDtoList) {

        for (OperationDetailDto element: operationDetailDtoList) {

            operationDetailRepo
                    .save(
                            OperationDetailMapper
                                    .INSTANCE
                                    .mapToOperationDetail(element)
                    );
        }
    }
}