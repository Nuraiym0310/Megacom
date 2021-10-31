package com.example.megacom.mappers;

import com.example.megacom.models.dtos.UserDto;
import com.example.megacom.models.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User mapToUser(UserDto userDto);

    UserDto mapToUserDto(User user);
}