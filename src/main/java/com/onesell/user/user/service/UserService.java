package com.onesell.user.user.service;

import com.onesell.user.common.encryptor.Encryptor;
import com.onesell.user.common.response.ApiResponse;
import com.onesell.user.user.dto.UserJoinRequest;
import com.onesell.user.user.dto.UserJoinResponse;
import com.onesell.user.user.persistence.UserEntity;
import com.onesell.user.user.persistence.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final Encryptor encryptor;

    public ApiResponse join(final UserJoinRequest userJoinRequest) {
        final UserEntity userEntity = UserEntity.byUserJoinRequest(userJoinRequest);
        final String encryptPassword = encryptor.encrypt(userJoinRequest.getPassword());
        userEntity.applyEncryptPassword(encryptPassword);

        final UserEntity savedUserEntity = userRepository.save(userEntity);
        final UserJoinResponse userJoinResponse = UserJoinResponse.byEntity(savedUserEntity);

        return ApiResponse.of(HttpStatus.CREATED, userJoinResponse);
    }
}
