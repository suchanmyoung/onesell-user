package com.onesell.user.user.service;

import com.onesell.user.user.dto.UserJoinRequest;
import com.onesell.user.user.persistence.UserEntity;
import com.onesell.user.user.persistence.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public void join(final UserJoinRequest userJoinRequest) {
        final UserEntity userEntity = UserEntity.byUserJoinRequest(userJoinRequest);

        userRepository.save(userEntity);
    }
}
