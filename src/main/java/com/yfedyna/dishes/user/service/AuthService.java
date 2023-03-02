package com.yfedyna.dishes.user.service;

import com.yfedyna.dishes.user.dto.LoginResponse;
import com.yfedyna.dishes.user.dto.UserLoginRequest;
import com.yfedyna.dishes.user.dto.UserRegistrationRequest;
import com.yfedyna.dishes.user.model.UserEntity;

public interface AuthService {

    void register(UserRegistrationRequest userRegistrationRequestDto);

    LoginResponse login(UserLoginRequest request);

    UserEntity getUserEntityByToken(String authHeader);
}
