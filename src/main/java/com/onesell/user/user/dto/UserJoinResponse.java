package com.onesell.user.user.dto;

import com.onesell.user.user.persistence.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserJoinResponse {

    private String userId;
    private String password;
    private String nickname;
    private String name;
    private String cellphone;
    private String email;

    public static UserJoinResponse byEntity(UserEntity userEntity) {
        return UserJoinResponse.builder()
            .userId(userEntity.getUserId())
            .password(userEntity.getPassword())
            .nickname(userEntity.getNickname())
            .name(userEntity.getName())
            .cellphone(userEntity.getEmail())
            .build();
    }
}
