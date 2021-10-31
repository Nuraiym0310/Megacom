package com.example.megacom.services;

import com.example.megacom.models.dtos.UserDto;
import com.example.megacom.models.entities.User;
import org.springframework.http.ResponseEntity;

public interface UserService {

    ResponseEntity<?> saveUser(UserDto userDto);

    ResponseEntity<?> sendCode(String login);

    ResponseEntity<?> getToken(String login, String code);

    ResponseEntity<?> verifyLogin(String token);

    boolean userLockOutChecking(User user);

    User findUserByLogin(String login);
}