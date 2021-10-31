package com.example.megacom.services;

import com.example.megacom.models.dtos.CodeDto;
import com.example.megacom.models.dtos.UserDto;
import com.example.megacom.models.entities.Code;

public interface CodeService {

    void saveCode(CodeDto codeDto);

    Code findLastCode(UserDto userDto);

    void sendCode(UserDto userDto);
}