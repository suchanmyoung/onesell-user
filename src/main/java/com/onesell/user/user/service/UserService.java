package com.onesell.user.user.service;

import com.onesell.user.common.encryptor.Encryptor;
import com.onesell.user.common.response.ApiResponse;
import com.onesell.user.exception.BusinessException;
import com.onesell.user.exception.ErrorCode;
import com.onesell.user.user.dto.UserJoinRequest;
import com.onesell.user.user.dto.UserJoinResponse;
import com.onesell.user.user.dto.UserListResponse;
import com.onesell.user.user.dto.UserModifyRequest;
import com.onesell.user.user.dto.UserModifyResponse;
import com.onesell.user.user.persistence.UserEntity;
import com.onesell.user.user.persistence.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional(readOnly = true)
    public ApiResponse getUsers(final PageRequest pageRequest) {
        final Page<UserEntity> userEntityPage = userRepository.findAll(pageRequest);
        final UserListResponse userListResponse = UserListResponse.from(userEntityPage);
        return ApiResponse.of(HttpStatus.OK, userListResponse);
    }

    @Transactional
    public ApiResponse modify(final String userId, final UserModifyRequest userModifyRequest) {
        final UserEntity userEntity = findByUserId(userId);
        userEntity.modify(encryptor, userModifyRequest);

        final UserModifyResponse userModifyResponse = UserModifyResponse.byEntity(userEntity);

        return ApiResponse.of(HttpStatus.OK, userModifyResponse);
    }

    @Transactional(readOnly = true)
    public boolean existsByUserId(final String userId) {
        return userRepository.existsByUserId(userId);
    }

    public UserEntity findByUserId(final String userId) {
        return userRepository.findByUserId(userId)
            .orElseThrow(() -> new BusinessException(ErrorCode.NOT_FOUND_USER));
    }
}
