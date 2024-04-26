package com.onesell.user.user.dto;

import com.onesell.user.user.persistence.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class UserModifyResponse {

    private String userId;
    private String password;
    private String nickname;
    private String name;
    private String cellphone;
    private String email;

    public static UserModifyResponse byEntity(UserEntity userEntity) {
        return UserModifyResponse.builder()
            .userId(userEntity.getUserId())
            .password(userEntity.getPassword())
            .nickname(userEntity.getNickname())
            .name(userEntity.getName())
            .cellphone(userEntity.getEmail())
            .email(userEntity.getEmail())
            .build();
    }
}
