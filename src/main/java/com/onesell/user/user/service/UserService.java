package com.onesell.user.user.service;

import com.onesell.user.common.encryptor.Encryptor;
import com.onesell.user.common.response.ApiResponse;
import com.onesell.user.exception.BusinessException;
import com.onesell.user.exception.ErrorCode;
import com.onesell.user.user.dto.UserJoinRequest;
import com.onesell.user.user.dto.UserJoinResponse;
import com.onesell.user.user.dto.UserModifyRequest;
import com.onesell.user.user.dto.UserModifyResponse;
import com.onesell.user.user.persistence.UserEntity;
import com.onesell.user.user.persistence.UserRepository;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final Encryptor encryptor;

    @Transactional
    public ApiResponse join(final UserJoinRequest userJoinRequest) {
        if (existsByUserId(userJoinRequest.getUserId())) {
            throw new BusinessException(ErrorCode.DUPLICATE_USER_ID);
        }

        final UserEntity userEntity = UserEntity.byUserJoinRequest(userJoinRequest);
        userEntity.applyEncryptPassword(encryptor);

        final UserEntity savedUserEntity = userRepository.save(userEntity);
        final UserJoinResponse userJoinResponse = UserJoinResponse.byEntity(savedUserEntity);

        return ApiResponse.of(HttpStatus.CREATED, userJoinResponse);
    }

    @Transactional
    public ApiResponse modify(final String userId, final UserModifyRequest userModifyRequest) {
        final UserEntity userEntity = findByUserId(userId);
        userEntity.modify(encryptor, userModifyRequest);

        final UserModifyResponse userModifyResponse = UserModifyResponse.byEntity(userEntity);

        return ApiResponse.of(HttpStatus.OK, userModifyResponse);
    }

    public boolean existsByUserId(final String userId) {
        return userRepository.existsByUserId(userId);
    }

    public UserEntity findByUserId(final String userId) {
        return userRepository.findByUserId(userId)
            .orElseThrow(() -> new BusinessException(ErrorCode.NOT_FOUND_USER));
    }
}
