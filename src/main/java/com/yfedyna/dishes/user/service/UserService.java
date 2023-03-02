package com.yfedyna.dishes.user.service;

import com.yfedyna.dishes.user.dto.UserInfoResponse;
import com.yfedyna.dishes.user.dto.ValidationTokenDto;
import com.yfedyna.dishes.user.model.UserEntity;

public interface UserService {

    UserInfoResponse getUserInfo(UserEntity userEntity);

    ValidationTokenDto validateAuthToken(UserEntity userEntity);
}
