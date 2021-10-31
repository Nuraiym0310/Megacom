package com.example.megacom.services;

import com.example.megacom.models.dtos.CodeDto;

public interface RequestService {

    void saveRequest(CodeDto codeDto, boolean value);

    int countFailedAttempts(CodeDto codeDto);
}